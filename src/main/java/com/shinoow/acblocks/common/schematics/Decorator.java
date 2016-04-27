package com.shinoow.acblocks.common.schematics;


import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import com.google.common.collect.Lists;

/* This class statically loads blueprints and mod configuration and override generate method @author Ternsip */
/**
 * Copied from Ternsip's Placemod mod.<br>
 * Original file can be found at https://github.com/ternsip/Placemod-1.7.10/blob/master/src/main/java/com/ternsip/placemod/Decorator.java
 *
 */
public class Decorator {

    static boolean[] soil = new boolean[256];
    static boolean[] overlook = new boolean[256];
    static boolean[] liquid = new boolean[256];
	public static List<Structure> structures = Lists.newArrayList();

	private static void loadStructures(File folder) {
		Stack<File> folders = new Stack<File>();
		folders.add(folder);
		while (!folders.empty()) {
			File dir = folders.pop();
			File[] listOfFiles = dir.listFiles();
			for (File file : listOfFiles != null ? listOfFiles : new File[0]) {
				if (file.isFile()) {
					try {
						String pathParallel = file.getPath().replace("\\", "/").replace("//", "/").replace("/schematics/", "/structures/");
						String pathFlags = pathParallel.replace(".schematic", ".flags");
						String pathStructure = pathParallel.replace(".schematic", ".structure");
						final Structure structure = new Structure(file, new File(pathFlags), new File(pathStructure));
						structures.add(structure);
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				} else if (file.isDirectory()) {
					folders.add(file);
				}
			}
		}
	}

	public static void place(World world, int x, int y, int z, long seed) {
		Random random = new Random(seed);
		int curX = x, curZ = z, maxZ = 0;
		int timer = 0, delay = (int) Math.ceil(Math.sqrt(structures.size()));
		Structure structure = structures.get(random.nextInt(structures.size()));
		int rotX = 0, rotY = random.nextInt() % 4, rotZ = 0;
		boolean flipX = random.nextBoolean(), flipY = false, flipZ = random.nextBoolean();
		int width = structure.flags.getShort("Width");
		int height = structure.flags.getShort("Height");
		int length = structure.flags.getShort("Length");
		Posture posture = new Posture(0, 0, 0, rotX, rotY, rotZ, flipX, flipY, flipZ, width, height, length);
		if (--timer <= 0) {
			timer = delay;
			curX = x;
			curZ += maxZ;
			maxZ = 0;
		}
		int sx = curX;
		int sz = curZ;
		curX += posture.getSizeX() + 1;
		maxZ = Math.max(maxZ, posture.getSizeZ());
		posture.shift(sx, y, sz);
		try {
//			posture.shift(0, structure.calibrate(world, posture, seed), 0);
			structure.paste(world, posture, random.nextLong());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void init() {

		soil[Block.getIdFromBlock(Blocks.grass)] = true;
        soil[Block.getIdFromBlock(Blocks.dirt)] = true;
        soil[Block.getIdFromBlock(Blocks.stone)] = true;
        soil[Block.getIdFromBlock(Blocks.cobblestone)] = true;
        soil[Block.getIdFromBlock(Blocks.sandstone)] = true;
        soil[Block.getIdFromBlock(Blocks.netherrack)] = true;
        soil[Block.getIdFromBlock(Blocks.gravel)] = true;
        soil[Block.getIdFromBlock(Blocks.sand)] = true;

        overlook[Block.getIdFromBlock(Blocks.air)] = true;
        overlook[Block.getIdFromBlock(Blocks.log)] = true;
        overlook[Block.getIdFromBlock(Blocks.log2)] = true;
        overlook[Block.getIdFromBlock(Blocks.leaves)] = true;
        overlook[Block.getIdFromBlock(Blocks.leaves2)] = true;
        overlook[Block.getIdFromBlock(Blocks.sapling)] = true;
        overlook[Block.getIdFromBlock(Blocks.web)] = true;
        overlook[Block.getIdFromBlock(Blocks.tallgrass)] = true;
        overlook[Block.getIdFromBlock(Blocks.deadbush)] = true;
        overlook[Block.getIdFromBlock(Blocks.yellow_flower)] = true;
        overlook[Block.getIdFromBlock(Blocks.red_flower)] = true;
        overlook[Block.getIdFromBlock(Blocks.red_mushroom_block)] = true;
        overlook[Block.getIdFromBlock(Blocks.brown_mushroom_block)] = true;
        overlook[Block.getIdFromBlock(Blocks.brown_mushroom)] = true;
        overlook[Block.getIdFromBlock(Blocks.fire)] = true;
        overlook[Block.getIdFromBlock(Blocks.wheat)] = true;
        overlook[Block.getIdFromBlock(Blocks.snow_layer)] = true;
        overlook[Block.getIdFromBlock(Blocks.snow)] = true;
        overlook[Block.getIdFromBlock(Blocks.cactus)] = true;
        overlook[Block.getIdFromBlock(Blocks.pumpkin)] = true;
        overlook[Block.getIdFromBlock(Blocks.vine)] = true;
        overlook[Block.getIdFromBlock(Blocks.waterlily)] = true;
        overlook[Block.getIdFromBlock(Blocks.double_plant)] = true;

        liquid[Block.getIdFromBlock(Blocks.water)] = true;
        liquid[Block.getIdFromBlock(Blocks.flowing_water)] = true;
        liquid[Block.getIdFromBlock(Blocks.ice)] = true;
        liquid[Block.getIdFromBlock(Blocks.lava)] = true;
        liquid[Block.getIdFromBlock(Blocks.flowing_lava)] = true;
		
        File folder = new File("config/acblocks/schematics/");
        folder.mkdirs();
		loadStructures(folder);

	}

}
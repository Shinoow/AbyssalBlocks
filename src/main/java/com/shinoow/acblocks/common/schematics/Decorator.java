package com.shinoow.acblocks.common.schematics;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.google.common.collect.Lists;

/* This class statically loads blueprints and mod configuration and override generate method @author Ternsip */
/**
 * Copied from Ternsip's Placemod mod.<br>
 * Original file can be found at https://github.com/ternsip/Placemod-1.9/blob/master/src/main/java/com/ternsip/placemod/Decorator.java
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
			structure.paste(world, posture, random.nextLong());

		} catch (IOException ioe) {

		}
	}

	public static void init() {

		soil[Block.getIdFromBlock(Blocks.GRASS)] = true;
		soil[Block.getIdFromBlock(Blocks.DIRT)] = true;
		soil[Block.getIdFromBlock(Blocks.STONE)] = true;
		soil[Block.getIdFromBlock(Blocks.COBBLESTONE)] = true;
		soil[Block.getIdFromBlock(Blocks.SANDSTONE)] = true;
		soil[Block.getIdFromBlock(Blocks.NETHERRACK)] = true;
		soil[Block.getIdFromBlock(Blocks.GRAVEL)] = true;
		soil[Block.getIdFromBlock(Blocks.SAND)] = true;

		overlook[Block.getIdFromBlock(Blocks.AIR)] = true;
		overlook[Block.getIdFromBlock(Blocks.LOG)] = true;
		overlook[Block.getIdFromBlock(Blocks.LOG2)] = true;
		overlook[Block.getIdFromBlock(Blocks.LEAVES)] = true;
		overlook[Block.getIdFromBlock(Blocks.LEAVES2)] = true;
		overlook[Block.getIdFromBlock(Blocks.SAPLING)] = true;
		overlook[Block.getIdFromBlock(Blocks.WEB)] = true;
		overlook[Block.getIdFromBlock(Blocks.TALLGRASS)] = true;
		overlook[Block.getIdFromBlock(Blocks.DEADBUSH)] = true;
		overlook[Block.getIdFromBlock(Blocks.YELLOW_FLOWER)] = true;
		overlook[Block.getIdFromBlock(Blocks.RED_FLOWER)] = true;
		overlook[Block.getIdFromBlock(Blocks.RED_MUSHROOM_BLOCK)] = true;
		overlook[Block.getIdFromBlock(Blocks.BROWN_MUSHROOM_BLOCK)] = true;
		overlook[Block.getIdFromBlock(Blocks.BROWN_MUSHROOM)] = true;
		overlook[Block.getIdFromBlock(Blocks.FIRE)] = true;
		overlook[Block.getIdFromBlock(Blocks.WHEAT)] = true;
		overlook[Block.getIdFromBlock(Blocks.SNOW_LAYER)] = true;
		overlook[Block.getIdFromBlock(Blocks.SNOW)] = true;
		overlook[Block.getIdFromBlock(Blocks.CACTUS)] = true;
		overlook[Block.getIdFromBlock(Blocks.PUMPKIN)] = true;
		overlook[Block.getIdFromBlock(Blocks.VINE)] = true;
		overlook[Block.getIdFromBlock(Blocks.WATERLILY)] = true;
		overlook[Block.getIdFromBlock(Blocks.DOUBLE_PLANT)] = true;

		liquid[Block.getIdFromBlock(Blocks.WATER)] = true;
		liquid[Block.getIdFromBlock(Blocks.FLOWING_WATER)] = true;
		liquid[Block.getIdFromBlock(Blocks.ICE)] = true;
		liquid[Block.getIdFromBlock(Blocks.LAVA)] = true;
		liquid[Block.getIdFromBlock(Blocks.FLOWING_LAVA)] = true;

		File folder = new File("config/acblocks/schematics/");
		folder.mkdirs();
		loadStructures(folder);

	}

}
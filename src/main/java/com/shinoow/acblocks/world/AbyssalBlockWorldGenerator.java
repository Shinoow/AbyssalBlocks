package com.shinoow.acblocks.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

import com.shinoow.acblocks.AbyssalBlocks;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class AbyssalBlockWorldGenerator {

	@SubscribeEvent
	public void onGenerate(PopulateChunkEvent.Pre event)
	{
		generate(event.world, new Random(), event.chunkX * 16, event.chunkZ * 16);
	}


	public void generate(World world, Random random, int x, int z) {
		if(random.nextInt(AbyssalBlocks.abyssalBlockSpawnrate) == 0){
			int xPos = x + random.nextInt(16);
			int zPos = z + random.nextInt(16);
			int yPos = world.getTopSolidOrLiquidBlock(xPos, zPos);

			if(world.getBlock(xPos, yPos - 1, zPos).equals(Blocks.bedrock))
			{
				for(int y = 0; y < yPos; y++)
				{

					if(world.getBlock(xPos, y - 1, zPos).isBlockSolid(world, xPos, y, zPos, 1) && world.isAirBlock(xPos, y, zPos))
					{
						yPos = y;
						return;
					}
				}
			}

			world.setBlock(xPos, yPos, zPos, AbyssalBlocks.abyssalBlock);
		}
	}
}
package com.shinoow.acblocks.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.shinoow.acblocks.AbyssalBlocks;

public class AbyssalBlockWorldGenerator {

	@SubscribeEvent
	public void onGenerate(PopulateChunkEvent.Pre event)
	{
		generate(event.getWorld(), new Random(), event.getChunkX() * 16, event.getChunkZ() * 16);
	}


	public void generate(World world, Random random, int x, int z) {
		if(random.nextInt(AbyssalBlocks.abyssalBlockSpawnrate) == 0){
			int xPos = x + random.nextInt(16);
			int zPos = z + random.nextInt(16);
			int yPos = world.getTopSolidOrLiquidBlock(new BlockPos(xPos, 0, zPos)).getY();

			BlockPos pos = new BlockPos(xPos, yPos - 1, zPos);
			
			if(world.getBlockState(pos).getBlock().equals(Blocks.BEDROCK))
			{
				for(int y = 0; y < yPos; y++)
				{
					BlockPos pos1 = new BlockPos(xPos, y, zPos);
					if(world.getBlockState(pos1).getBlock().isBlockSolid(world, pos1, EnumFacing.UP) && world.isAirBlock(pos1))
					{
						yPos = y;
						return;
					}
				}
			}

			world.setBlockState(new BlockPos(xPos, yPos, zPos), AbyssalBlocks.abyssalBlock.getDefaultState());
		}
	}
}
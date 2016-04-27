package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.api.ritual.RitualRegistry;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerFreeRitualAltar extends BlockTrigger {

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(RitualRegistry.instance().canPerformAction(world.provider.getDimension(), 4)){
			int x = 0;
			int y = 0;
			int z = 0;
			world.setBlockState(pos.add(x -3, y, z), ACBlocks.ritual_altar.getStateFromMeta(1), 2);
			world.setBlockState(pos.add(x, y, z -3), ACBlocks.ritual_pedestal.getStateFromMeta(1), 2);
			world.setBlockState(pos.add(x + 3, y, z), ACBlocks.ritual_pedestal.getStateFromMeta(1), 2);
			world.setBlockState(pos.add(x, y, z + 3), ACBlocks.ritual_pedestal.getStateFromMeta(1), 2);
			world.setBlockState(pos.add(x -2, y,z + 2), ACBlocks.ritual_pedestal.getStateFromMeta(1), 2);
			world.setBlockState(pos.add(x -2, y, z -2), ACBlocks.ritual_pedestal.getStateFromMeta(1), 2);
			world.setBlockState(pos.add(x + 2, y, z + 2), ACBlocks.ritual_pedestal.getStateFromMeta(1), 2);
			world.setBlockState(pos.add(x + 2, y, z -2), ACBlocks.ritual_pedestal.getStateFromMeta(1), 2);
			world.setBlockToAir(pos.add(x -3, y, z -1));
			world.setBlockToAir(pos.add(x -3, y, z + 1));
			world.setBlockToAir(pos.add(x -4, y, z));
			world.setBlockToAir(pos.add(x -4, y, z -1));
			world.setBlockToAir(pos.add(x -4, y, z + 1));
			world.setBlockToAir(pos.add(x -3, y, z -2));
			world.setBlockToAir(pos.add(x -3, y, z -3));
			world.setBlockToAir(pos.add(x -2, y, z -3));
			world.setBlockToAir(pos.add(x -1, y, z -3));
			world.setBlockToAir(pos.add(x -1, y, z -4));
			world.setBlockToAir(pos.add(x, y, z -4));
			world.setBlockToAir(pos.add(x + 1, y, z -4));
			world.setBlockToAir(pos.add(x + 1, y, z -3));
			world.setBlockToAir(pos.add(x + 2, y, z -3));
			world.setBlockToAir(pos.add(x + 3, y, z -3));
			world.setBlockToAir(pos.add(x + 3, y, z -2));
			world.setBlockToAir(pos.add(x + 3, y, z -1));
			world.setBlockToAir(pos.add(x + 4, y, z -1));
			world.setBlockToAir(pos.add(x + 4, y, z));
			world.setBlockToAir(pos.add(x + 4, y, z + 1));
			world.setBlockToAir(pos.add(x + 3, y, z + 1));
			world.setBlockToAir(pos.add(x + 3, y, z + 2));
			world.setBlockToAir(pos.add(x + 3, y, z + 3));
			world.setBlockToAir(pos.add(x + 2, y, z + 3));
			world.setBlockToAir(pos.add(x + 1, y, z + 3));
			world.setBlockToAir(pos.add(x + 1, y, z + 4));
			world.setBlockToAir(pos.add(x, y, z + 4));
			world.setBlockToAir(pos.add(x -1, y, z + 4));
			world.setBlockToAir(pos.add(x -1, y, z + 3));
			world.setBlockToAir(pos.add(x -2, y, z + 3));
			world.setBlockToAir(pos.add(x-3, y, z + 3));
			world.setBlockToAir(pos.add(x -3, y, z + 2));
			world.setBlockToAir(pos.add(x-1, y, z + 0));
			world.setBlockToAir(pos.add(x + 1, y, z));
			world.setBlockToAir(pos.add(x, y, z -1));
			world.setBlockToAir(pos.add(x, y, z + 1));
			world.setBlockToAir(pos.add(x-1, y, z + 1));
			world.setBlockToAir(pos.add(x -2, y, z));
			world.setBlockToAir(pos.add(x-2, y, z));
			world.setBlockToAir(pos.add(x -2, y, z -1));
			world.setBlockToAir(pos.add(x-1, y, z -1));
			world.setBlockToAir(pos.add(x -1, y, z -2));
			world.setBlockToAir(pos.add(x, y, z -2));
			world.setBlockToAir(pos.add(x + 1, y, z -2));
			world.setBlockToAir(pos.add(x + 1, y, z -1));
			world.setBlockToAir(pos.add(x + 2, y, z -1));
			world.setBlockToAir(pos.add(x + 2, y, z));
			world.setBlockToAir(pos.add(x + 2, y, z + 1));
			world.setBlockToAir(pos.add(x + 1, y, z + 1));
			world.setBlockToAir(pos.add(x + 1, y, z + 2));
			world.setBlockToAir(pos.add(x, y, z + 2));
			world.setBlockToAir(pos.add(x -1, y, z + 2));
		}
	}
}
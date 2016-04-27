package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.api.ritual.RitualRegistry;
import com.shinoow.abyssalcraft.common.util.SpecialTextUtil;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerFreeRitualAltar extends BlockTrigger {

	@Override
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		if(RitualRegistry.instance().canPerformAction(world.provider.dimensionId, 4)){
			world.setBlock(x, y, z, ACBlocks.ritual_altar, 1, 2);
			world.setBlock(x - 3, y, z, ACBlocks.ritual_pedestal, 1, 2);
			world.setBlock(x, y, z - 3, ACBlocks.ritual_pedestal, 1, 2);
			world.setBlock(x + 3, y, z, ACBlocks.ritual_pedestal, 1, 2);
			world.setBlock(x, y, z + 3, ACBlocks.ritual_pedestal, 1, 2);
			world.setBlock(x - 2, y, z + 2, ACBlocks.ritual_pedestal, 1, 2);
			world.setBlock(x - 2, y, z - 2, ACBlocks.ritual_pedestal, 1, 2);
			world.setBlock(x + 2, y, z + 2, ACBlocks.ritual_pedestal, 1, 2);
			world.setBlock(x + 2, y, z - 2, ACBlocks.ritual_pedestal, 1, 2);
			world.setBlockToAir(x - 3, y, z - 1);
			world.setBlockToAir(x - 3, y, z + 1);
			world.isAirBlock(x - 4, y, z);
			world.setBlockToAir(x - 4, y, z - 1);
			world.isAirBlock(x - 4, y, z + 1);
			world.setBlockToAir(x - 3, y, z - 2);
			world.isAirBlock(x - 3, y, z - 3);
			world.setBlockToAir(x - 2, y, z - 3);
			world.isAirBlock(x - 1, y, z - 3);
			world.setBlockToAir(x - 1, y, z - 4);
			world.isAirBlock(x, y, z - 4);
			world.setBlockToAir(x + 1, y, z - 4);
			world.isAirBlock(x + 1, y, z - 3);
			world.setBlockToAir(x + 2, y, z - 3);
			world.isAirBlock(x + 3, y, z - 3);
			world.setBlockToAir(x + 3, y, z - 2);
			world.isAirBlock(x + 3, y, z - 1);
			world.setBlockToAir(x + 4, y, z - 1);
			world.isAirBlock(x + 4, y, z);
			world.setBlockToAir(x + 4, y, z + 1);
			world.isAirBlock(x + 3, y, z + 1);
			world.setBlockToAir(x + 3, y, z + 2);
			world.isAirBlock(x + 3, y, z + 3);
			world.setBlockToAir(x + 2, y, z + 3);
			world.isAirBlock(x + 1, y, z + 3);
			world.setBlockToAir(x + 1, y, z + 4);
			world.isAirBlock(x, y, z + 4);
			world.setBlockToAir(x - 1, y, z + 4);
			world.isAirBlock(x - 1, y, z + 3);
			world.setBlockToAir(x - 2, y, z + 3);
			world.isAirBlock(x - 3, y, z + 3);
			world.setBlockToAir(x - 3, y, z + 2);
			world.isAirBlock(x - 1, y, z);
			world.setBlockToAir(x + 1, y, z);
			world.isAirBlock(x, y, z - 1);
			world.setBlockToAir(x, y, z + 1);
			world.isAirBlock(x - 1, y, z + 1);
			world.setBlockToAir(x - 2, y, z);
			world.isAirBlock(x - 2, y, z);
			world.setBlockToAir(x - 2, y, z - 1);
			world.isAirBlock(x - 1, y, z - 1);
			world.setBlockToAir(x - 1, y, z - 2);
			world.isAirBlock(x, y, z - 2);
			world.setBlockToAir(x + 1, y, z - 2);
			world.isAirBlock(x + 1, y, z - 1);
			world.setBlockToAir(x + 2, y, z - 1);
			world.isAirBlock(x + 2, y, z);
			world.setBlockToAir(x + 2, y, z + 1);
			world.isAirBlock(x + 1, y, z + 1);
			world.setBlockToAir(x + 1, y, z + 2);
			world.isAirBlock(x, y, z + 2);
			world.setBlockToAir(x - 1, y, z + 2);
		}
	}
}
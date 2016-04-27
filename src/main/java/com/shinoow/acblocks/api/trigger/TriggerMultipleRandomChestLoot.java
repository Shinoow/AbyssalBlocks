package com.shinoow.acblocks.api.trigger;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class TriggerMultipleRandomChestLoot extends TriggerRandomChestLoot {

	/**
	 * A Multiple Random Chest Loot Trigger
	 * @param lootTable Name of a Loot Table registered in ChestGenHooks
	 */
	public TriggerMultipleRandomChestLoot(String lootTable) {
		super(lootTable);
	}
	
	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		for(int i = 0; i < rand.nextInt(3) + 1; i++)
			super.trigger(world, rand, pos, player);
	}
}
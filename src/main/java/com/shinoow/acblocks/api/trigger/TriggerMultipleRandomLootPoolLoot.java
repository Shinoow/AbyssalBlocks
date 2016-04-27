package com.shinoow.acblocks.api.trigger;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class TriggerMultipleRandomLootPoolLoot extends TriggerRandomLootPoolLoot {

	/**
	 * A Multiple Random Loot Pool Loot Trigger
	 * @param lootPool An array of WeightedRandomChestContents to pick from
	 */
	public TriggerMultipleRandomLootPoolLoot(WeightedRandomChestContent[] lootPool) {
		super(lootPool);
	}

	@Override
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		for(int i = 0; i < rand.nextInt(3) + 1; i++)
			super.trigger(world, rand, x, y, z, player);
	}
}
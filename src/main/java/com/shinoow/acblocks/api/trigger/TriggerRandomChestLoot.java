package com.shinoow.acblocks.api.trigger;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

public class TriggerRandomChestLoot extends BlockTrigger {

	private String lootTable;

	/**
	 * A Random Chest Loot Trigger
	 * @param lootTable Name of a Loot Table registered in ChestGenHooks
	 */
	public TriggerRandomChestLoot(String lootTable){
		this.lootTable = lootTable;
	}

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		ItemStack loot = ChestGenHooks.getOneItem(lootTable, rand);
		EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), loot);
		if(!world.isRemote)
			world.spawnEntityInWorld(item);
	}
}
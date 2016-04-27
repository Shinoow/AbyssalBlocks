package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.item.ACItems;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerRandomCrystals extends BlockTrigger {

	@Override
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		ItemStack[] crystals = new ItemStack[rand.nextInt(5)+1];
		for(ItemStack crystal : crystals){
			crystal = new ItemStack(rand.nextBoolean() ? ACItems.crystal : ACItems.crystal_shard, rand.nextInt(6)+1, rand.nextInt(24));
			EntityItem item = new EntityItem(world, x, y, z, crystal);
			if(!world.isRemote)
				world.spawnEntityInWorld(item);
		}
	}
}
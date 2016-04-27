package com.shinoow.acblocks.api.trigger;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

public class TriggerRandomLootPoolLoot extends BlockTrigger {

	private List<WeightedRandomChestContent> lootPool;

	/**
	 * A Random Loot Pool Loot Trigger
	 * @param lootPool An array of WeightedRandomChestContents to pick from
	 */
	public TriggerRandomLootPoolLoot(List<WeightedRandomChestContent> lootPool){
		this.lootPool = lootPool;
	}

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		ItemStack loot = getRandomItem(rand, lootPool);
		EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), loot);
		if(!world.isRemote)
			world.spawnEntityInWorld(item);
	}

	public ItemStack getRandomItem(Random rand, List<WeightedRandomChestContent> items)
    {
        WeightedRandomChestContent item = (WeightedRandomChestContent)WeightedRandom.getRandomItem(rand, items);
        ItemStack[] stacks = ChestGenHooks.generateStacks(rand, item.theItemId, item.minStackSize, item.maxStackSize);
        return (stacks.length > 0 ? stacks[0] : null);
    }
}
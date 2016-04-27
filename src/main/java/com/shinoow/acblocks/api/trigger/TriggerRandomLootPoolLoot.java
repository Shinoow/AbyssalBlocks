package com.shinoow.acblocks.api.trigger;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
        ItemStack[] stacks = generateStacks(rand, item.theItemId, item.minStackSize, item.maxStackSize);
        return (stacks.length > 0 ? stacks[0] : null);
    }
	
	public static ItemStack[] generateStacks(Random rand, ItemStack source, int min, int max)
    {
        int count = min + (rand.nextInt(max - min + 1));

        ItemStack[] ret;
        if (source.getItem() == null)
        {
            ret = new ItemStack[0];
        }
        else if (count > source.getMaxStackSize())
        {
            ret = new ItemStack[count];
            for (int x = 0; x < count; x++)
            {
                ret[x] = source.copy();
                ret[x].stackSize = 1;
            }
        }
        else
        {
            ret = new ItemStack[1];
            ret[0] = source.copy();
            ret[0].stackSize = count;
        }
        return ret;
    }
}
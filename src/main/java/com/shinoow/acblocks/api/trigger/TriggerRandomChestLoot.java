package com.shinoow.acblocks.api.trigger;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;

public class TriggerRandomChestLoot extends BlockTrigger {

	private ResourceLocation lootTable;

	/**
	 * A Random Chest Loot Trigger
	 * @param lootTable Name of a Loot Table registered in ChestGenHooks
	 */
	public TriggerRandomChestLoot(ResourceLocation lootTable){
		this.lootTable = lootTable;
	}

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(world instanceof WorldServer){
			LootTable table = ((WorldServer)world).getLootTableManager().getLootTableFromLocation(lootTable);
			List<ItemStack> stuff = table.generateLootForPools(rand, new LootContext.Builder((WorldServer) world).withLuck(player.getLuck()).build());
			ItemStack loot = stuff.get(rand.nextInt(stuff.size()));
			EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), loot);
			if(!world.isRemote)
				world.spawnEntityInWorld(item);
		}
	}
}
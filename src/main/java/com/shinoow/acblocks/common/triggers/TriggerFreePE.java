package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.energy.IEnergyTransporterItem;
import com.shinoow.abyssalcraft.api.entity.EntityUtil;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerFreePE extends BlockTrigger {

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(EntityUtil.hasNecronomicon(player))
			if(!world.isRemote)
				for(ItemStack stack : player.inventory.mainInventory){
					if(stack != null && stack.getItem() instanceof IEnergyTransporterItem){
						IEnergyTransporterItem container = (IEnergyTransporterItem) stack.getItem();
						container.addEnergy(stack, container.getContainedEnergy(stack)/2);
						return;
					}
				}
	}
}
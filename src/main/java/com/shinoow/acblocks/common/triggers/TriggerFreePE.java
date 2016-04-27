package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.APIUtils;
import com.shinoow.abyssalcraft.api.energy.IEnergyTransporter;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerFreePE extends BlockTrigger {

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(APIUtils.hasNecronomicon(player))
			if(!world.isRemote)
				for(ItemStack stack : player.inventory.mainInventory){
					if(stack != null && stack.getItem() instanceof IEnergyTransporter){
						IEnergyTransporter container = (IEnergyTransporter) stack.getItem();
						container.addEnergy(stack, container.getContainedEnergy(stack)/2);
						return;
					}
				}
	}
}
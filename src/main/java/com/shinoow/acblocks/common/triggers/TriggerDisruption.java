package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.energy.disruption.DisruptionHandler;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerDisruption extends BlockTrigger {

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		DisruptionHandler.instance().generateDisruption(null, world, pos, world.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos).expand(32, 32, 32)));
	}
}
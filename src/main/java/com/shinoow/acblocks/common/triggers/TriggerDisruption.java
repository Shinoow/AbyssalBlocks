package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.energy.disruption.DisruptionHandler;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerDisruption extends BlockTrigger {

	@Override
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		DisruptionHandler.instance().generateDisruption(null, world, x, y, z, world.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1).expand(32, 32, 32)));
	}
}
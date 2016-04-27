package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.shinoow.acblocks.common.schematics.Decorator;

public class TriggerRandomSchematic extends TriggerRandomStructure {

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(Decorator.structures.isEmpty()) super.trigger(world, rand, pos, player);
			Decorator.place(world, pos.getX(), pos.getY(), pos.getZ(), rand.nextLong());
	}
}
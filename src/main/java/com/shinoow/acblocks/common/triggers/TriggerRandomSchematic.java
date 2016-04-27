package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.shinoow.acblocks.common.schematics.Decorator;

public class TriggerRandomSchematic extends TriggerRandomStructure {

	@Override
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		if(Decorator.structures.isEmpty()) super.trigger(world, rand, x, y, z, player);
			Decorator.place(world, x, y, z, rand.nextLong());
	}
}
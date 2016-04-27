package com.shinoow.acblocks.api.trigger;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockTrigger {

	/**
	 * Called when a AbyssalBlock is broken, allowing you to do random things.
	 * @param world Current World
	 * @param rand Random instance
	 * @param pos Current BlockPos
	 * @param player Player who broke the block
	 */
	public abstract void trigger(World world, Random rand, BlockPos pos, EntityPlayer player);
}
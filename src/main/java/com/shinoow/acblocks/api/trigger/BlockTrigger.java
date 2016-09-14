package com.shinoow.acblocks.api.trigger;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract class BlockTrigger {

	private String name;
	private int num;

	/**
	 * Sets the Block Trigger name (used internally, no need to do this yourself)
	 */
	public BlockTrigger setName(String name){
		this.name = name;
		return this;
	}

	/**
	 * Sets the Block Trigger category (used internally, no need to do this yourself)
	 */
	public BlockTrigger setNum(int num){
		this.num = num;
		return this;
	}

	/**
	 * Fetches the Block Trigger name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Fetches the Block Trigger category
	 */
	public int getNum(){
		return num;
	}

	/**
	 * Called when a AbyssalBlock is broken, allowing you to do random things.
	 * @param world Current World
	 * @param rand Random instance
	 * @param pos Current BlockPos
	 * @param player Player who broke the block
	 */
	public abstract void trigger(World world, Random rand, BlockPos pos, EntityPlayer player);
}
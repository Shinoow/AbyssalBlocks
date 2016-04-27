package com.shinoow.acblocks.api;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;

import org.apache.logging.log4j.Level;

import com.google.common.collect.Lists;
import com.shinoow.acblocks.api.trigger.BlockTrigger;


public class AbyssalBlocksAPI {

	private static List<BlockTrigger> triggers100 = Lists.newArrayList();
	private static List<BlockTrigger> triggers90 = Lists.newArrayList();
	private static List<BlockTrigger> triggers80 = Lists.newArrayList();
	private static List<BlockTrigger> triggers70 = Lists.newArrayList();
	private static List<BlockTrigger> triggers60 = Lists.newArrayList();
	private static List<BlockTrigger> triggers50 = Lists.newArrayList();
	private static List<BlockTrigger> triggers40 = Lists.newArrayList();
	private static List<BlockTrigger> triggers30 = Lists.newArrayList();
	private static List<BlockTrigger> triggers20 = Lists.newArrayList();
	private static List<BlockTrigger> triggers10 = Lists.newArrayList();
	private static Map<Integer, List<BlockTrigger>> triggerRegistry = new HashMap<Integer, List<BlockTrigger>>(){{
		put(1, triggers10);
		put(2, triggers20);
		put(3, triggers30);
		put(4, triggers40);
		put(5, triggers50);
		put(6, triggers60);
		put(7, triggers70);
		put(8, triggers80);
		put(9, triggers90);
		put(10, triggers100);
	}};
	static Random rand = new Random();

	/**
	 * Registers a Block Trigger
	 * @param trigger Block Trigger to register
	 * @param num A number between 1 - 10 (used to determine which category the trigger<br>
	 * should be in, where 10 is awesome and 1 is horrible)
	 */
	public static void registerBlockTrigger(BlockTrigger trigger, int num) {
		if(num < 10 || num > 1)
			triggerRegistry.get(num).add(trigger);
		else FMLLog.log("AbyssalBlocks", Level.ERROR, "Mod %s tried to registed a trigger outside of the range!", Loader.instance().activeModContainer().getModId());
	}

	/**
	 * Generates a random Block Trigger
	 * @param world Current World
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 * @param z Z-Coordinate
	 */
	public static void generateBlockTrigger(World world, BlockPos pos, EntityPlayer player) {
		rand.setSeed((long) (((world.rand.nextLong() * (world.rand.nextInt(15)+1))/(10* world.rand.nextInt(3)+1) * Calendar.getInstance(TimeZone.getTimeZone(TimeZone.getAvailableIDs()[world.rand.nextInt(TimeZone.getAvailableIDs().length)])).getTimeInMillis())/Math.PI));
		int num = getNum(rand.nextInt(100));

		triggerRegistry.get(num).get(rand.nextInt(triggerRegistry.get(num).size())).trigger(world, rand, pos, player);
	}

	private static int getNum(int dice){
		if(dice > 90)
			return 10;
		if(dice > 80)
			return 9;
		if(dice > 70)
			return 8;
		if(dice > 60)
			return 7;
		if(dice > 50)
			return 6;
		if(dice > 40)
			return 5;
		if(dice > 30)
			return 4;
		if(dice > 20)
			return 3;
		if(dice > 10)
			return 2;
		return 1;
	}

	/**
	 * This is simply used to get some statistics on the amount of registered triggers.
	 */
	public static int[] getNumbers(){
		if(Loader.instance().activeModContainer().getModId().equals("acblocks"))
			return new int[]{triggerRegistry.get(1).size(), triggerRegistry.get(2).size(), triggerRegistry.get(3).size(),
				triggerRegistry.get(4).size(), triggerRegistry.get(5).size(), triggerRegistry.get(6).size(),
				triggerRegistry.get(7).size(), triggerRegistry.get(8).size(), triggerRegistry.get(9).size(),
				triggerRegistry.get(10).size(), triggerRegistry.get(1).size() + triggerRegistry.get(2).size() + triggerRegistry.get(3).size() +
				triggerRegistry.get(4).size() + triggerRegistry.get(5).size() + triggerRegistry.get(6).size() +
				triggerRegistry.get(7).size() + triggerRegistry.get(8).size() + triggerRegistry.get(9).size() +
				triggerRegistry.get(10).size()};
		else throw new IllegalArgumentException("No.");
	}
}
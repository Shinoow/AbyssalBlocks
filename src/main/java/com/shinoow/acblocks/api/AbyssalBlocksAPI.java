package com.shinoow.acblocks.api;

import java.util.*;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Loader;

import org.apache.logging.log4j.Level;

import com.google.common.collect.Lists;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class AbyssalBlocksAPI {

	private static Map<Integer, List<BlockTrigger>> triggerRegistry = new HashMap<Integer, List<BlockTrigger>>(){{
		put(1, Lists.<BlockTrigger>newArrayList());
		put(2, Lists.<BlockTrigger>newArrayList());
		put(3, Lists.<BlockTrigger>newArrayList());
		put(4, Lists.<BlockTrigger>newArrayList());
		put(5, Lists.<BlockTrigger>newArrayList());
		put(6, Lists.<BlockTrigger>newArrayList());
		put(7, Lists.<BlockTrigger>newArrayList());
		put(8, Lists.<BlockTrigger>newArrayList());
		put(9, Lists.<BlockTrigger>newArrayList());
		put(10, Lists.<BlockTrigger>newArrayList());
	}};
	static Random rand = new Random();

	static int triggerNum;

	/**
	 * Registers a Block Trigger
	 * @param trigger Block Trigger to register
	 * @param num A number between 1 - 10 (used to determine which category the trigger<br>
	 * should be in, where 10 is awesome and 1 is horrible)
	 */
	public static void registerBlockTrigger(BlockTrigger trigger, int num) {
		if(num < 11 && num > 0)
			triggerRegistry.get(num).add(trigger.setName("trigger"+triggerNum++).setNum(num));
		else FMLLog.log("AbyssalBlocks", Level.ERROR, "Mod %s tried to registed a trigger outside of the range!", Loader.instance().activeModContainer().getModId());
	}

	/**
	 * Uses a second Random instance to set the seed of the internal one
	 * @param random Random instance (use world RNG if possible
	 */
	public static void setSeed(Random random){
		rand.setSeed((long) (((random.nextLong() * (random.nextInt(15)+1))/(10* random.nextInt(3)+1) * Calendar.getInstance(TimeZone.getTimeZone(TimeZone.getAvailableIDs()[random.nextInt(TimeZone.getAvailableIDs().length)])).getTimeInMillis())/Math.PI));
	}

	/**
	 * Generates a random Block Trigger
	 */
	public static BlockTrigger generateBlockTrigger() {
		int num = getNum(rand.nextInt(100));

		return triggerRegistry.get(num).get(rand.nextInt(triggerRegistry.get(num).size()));
	}

	/**
	 * Utility method for fetching the random instance used for picking Block Triggers.
	 */
	public static Random getRNG(){
		return rand;
	}

	/**
	 * Fetches a Block Trigger based on it's internal name
	 * @param name Block Trigger name
	 * @param num Block Trigger category
	 * @return A Block Trigger from the specified category, or null if none was found
	 */
	public static BlockTrigger getTriggerFromName(String name, int num){
		if(num < 10 || num > 1){
			for(BlockTrigger trigger : triggerRegistry.get(num)){
				if(trigger.getName().equals(name))
					return trigger;
			}
		}
		return null;
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
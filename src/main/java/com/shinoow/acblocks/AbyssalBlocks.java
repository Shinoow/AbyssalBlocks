package com.shinoow.acblocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;

import com.shinoow.abyssalcraft.api.AbyssalCraftAPI.ACPotions;
import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.common.entity.*;
import com.shinoow.abyssalcraft.common.entity.anti.*;
import com.shinoow.abyssalcraft.common.structures.StructureShoggothPit;
import com.shinoow.abyssalcraft.common.structures.abyss.stronghold.StructureAbyStrongholdPieces;
import com.shinoow.abyssalcraft.common.structures.dreadlands.mineshaft.StructureDreadlandsMinePieces;
import com.shinoow.abyssalcraft.common.world.gen.WorldGenAbyLake;
import com.shinoow.abyssalcraft.common.world.gen.WorldGenAntimatterLake;
import com.shinoow.abyssalcraft.common.world.gen.WorldGenDreadlandsStalagmite;
import com.shinoow.abyssalcraft.common.world.gen.WorldGenShoggothMonolith;
import com.shinoow.acblocks.api.AbyssalBlocksAPI;
import com.shinoow.acblocks.api.trigger.TriggerMultipleRandomChestLoot;
import com.shinoow.acblocks.api.trigger.TriggerMultipleRandomLootPoolLoot;
import com.shinoow.acblocks.api.trigger.TriggerRandomChestLoot;
import com.shinoow.acblocks.api.trigger.TriggerRandomLootPoolLoot;
import com.shinoow.acblocks.api.trigger.TriggerSpawn;
import com.shinoow.acblocks.api.trigger.TriggerSwarm;
import com.shinoow.acblocks.common.blocks.BlockAbyssalBlock;
import com.shinoow.acblocks.common.schematics.Decorator;
import com.shinoow.acblocks.common.structures.AbyPillar;
import com.shinoow.acblocks.common.structures.AbyRuin;
import com.shinoow.acblocks.common.triggers.*;
import com.shinoow.acblocks.world.AbyssalBlockWorldGenerator;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = AbyssalBlocks.modid, name = AbyssalBlocks.name, version = AbyssalBlocks.version, dependencies = "required-after:Forge@[forgeversion,);required-after:abyssalcraft@[1.9.1.1,]", useMetadata = false, guiFactory = "com.shinoow.acblocks.client.config.ACBGuiFactory")
public class AbyssalBlocks {

	public static final String modid = "acblocks";
	public static final String name = "AbyssalBlocks";
	public static final String version = "1.0.0";

	@Metadata(AbyssalBlocks.modid)
	public static ModMetadata metadata;

	@Instance(AbyssalBlocks.modid)
	public static AbyssalBlocks instance = new AbyssalBlocks();

	public static Configuration cfg;

	public static Block abyssalBlock;

	public static int abyssalBlockSpawnrate;
	
	public static boolean shouldGenerate;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){

		metadata = event.getModMetadata();
		metadata.description = metadata.description +"\n\n\u00a76Supporters: "+getSupporterList()+"\u00a7r";

		instance = this;

		cfg = new Configuration(event.getSuggestedConfigurationFile());
		syncConfig();
		Decorator.init();

		abyssalBlock = new BlockAbyssalBlock();

		GameRegistry.registerBlock(abyssalBlock, "abyssalblock");
		
		if(shouldGenerate)
			MinecraftForge.EVENT_BUS.register(new AbyssalBlockWorldGenerator());
	}

	@EventHandler
	public void Init(FMLInitializationEvent event){

		AbyssalBlocksAPI.registerBlockTrigger(new TriggerDisruption(), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerDisruption(), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerDisruption(), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerDisruption(), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerDarkRealmBanish(), 1);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityLesserDreadbeast.class, 3), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityGreaterDreadSpawn.class, 3), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityDreadSpawn.class, 3), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerFreeRitualAltar(), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerAntimatterExplosion(), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomStructure(new StructureShoggothPit()), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.DUNGEON_CHEST), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.DUNGEON_CHEST), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.DUNGEON_CHEST), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.DUNGEON_CHEST), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.DUNGEON_CHEST), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomChestLoot(ChestGenHooks.STRONGHOLD_CORRIDOR), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.STRONGHOLD_CORRIDOR), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.STRONGHOLD_CORRIDOR), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomChestLoot(ChestGenHooks.STRONGHOLD_CROSSING), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.STRONGHOLD_CROSSING), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.STRONGHOLD_CROSSING), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomChestLoot(ChestGenHooks.MINESHAFT_CORRIDOR), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.MINESHAFT_CORRIDOR), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.MINESHAFT_CORRIDOR), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.BONUS_CHEST), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.BONUS_CHEST), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.BONUS_CHEST), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.STRONGHOLD_LIBRARY), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.STRONGHOLD_LIBRARY), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.STRONGHOLD_LIBRARY), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.PYRAMID_DESERT_CHEST), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.PYRAMID_DESERT_CHEST), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.PYRAMID_DESERT_CHEST), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.PYRAMID_JUNGLE_CHEST), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.PYRAMID_JUNGLE_CHEST), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.PYRAMID_JUNGLE_CHEST), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.VILLAGE_BLACKSMITH), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.VILLAGE_BLACKSMITH), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ChestGenHooks.VILLAGE_BLACKSMITH), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomLootPoolLoot(StructureAbyStrongholdPieces.ChestCorridor.strongholdChestContents), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomLootPoolLoot(StructureAbyStrongholdPieces.RoomCrossing.strongholdRoomCrossingChestContents), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomLootPoolLoot(StructureDreadlandsMinePieces.mineshaftChestContents), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomLootPoolLoot(StructureAbyStrongholdPieces.ChestCorridor.strongholdChestContents), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomLootPoolLoot(StructureAbyStrongholdPieces.RoomCrossing.strongholdRoomCrossingChestContents), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomLootPoolLoot(StructureDreadlandsMinePieces.mineshaftChestContents), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomLootPoolLoot(StructureAbyStrongholdPieces.ChestCorridor.strongholdChestContents), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomLootPoolLoot(StructureAbyStrongholdPieces.RoomCrossing.strongholdRoomCrossingChestContents), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomLootPoolLoot(StructureDreadlandsMinePieces.mineshaftChestContents), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomSchematic(), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomSchematic(), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomSchematic(), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomSchematic(), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomSchematic(), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomStructure(ACBlocks.shoggoth_ooze, new WorldGenShoggothMonolith()), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomStructure(), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomStructure(new AbyPillar(), new AbyRuin()), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomStructure(new AbyPillar(), new AbyRuin()), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomStructure(new AbyPillar(), new AbyRuin()), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomStructure(ACBlocks.dreadstone, new WorldGenDreadlandsStalagmite()), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomStructure(ACBlocks.dreadstone, new WorldGenDreadlandsStalagmite()), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomStructure(ACBlocks.dreadstone, new WorldGenDreadlandsStalagmite()), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomStructure(new WorldGenAbyLake(ACBlocks.liquid_coralium), new WorldGenAntimatterLake(ACBlocks.liquid_antimatter)), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityAbyssalZombie.class, 2), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityDepthsGhoul.class, 2), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityAntiAbyssalZombie.class, 2), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityAntiGhoul.class, 2), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityAbyssalZombie.class, 4), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityDepthsGhoul.class, 4), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityAntiAbyssalZombie.class, 4), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityAntiGhoul.class, 4), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityAntiSkeleton.class, 4), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityAntiZombie.class, 4), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityAntiSpider.class, 4), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityAntiCreeper.class, 3), 4);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntitySkeletonGoliath.class, 1), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerDemonAnimals(), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityRemnant.class, 1), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntitySkeletonGoliath.class, 3), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityGatekeeperMinion.class, 1), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityGatekeeperMinion.class, 3), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityLesserShoggoth.class, 1), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityLesserShoggoth.class, 3), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityOmotholGhoul.class, 2), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityOmotholGhoul.class, 4), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerShoggothInfestation(), 1);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomCrystals(), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerFreePE(), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMonolithicCalamity(), 1);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityDreadguard.class, 3), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSwarm(EntityAntiZombie.class, EntityAntiSpider.class, EntityAntiCreeper.class, EntityAntiPlayer.class), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSwarm(EntityAntiAbyssalZombie.class, EntityAntiGhoul.class), 3);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSwarm(EntityAbyssalZombie.class, EntityDepthsGhoul.class, EntitySkeleton.class), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSpawn(EntityDragonMinion.class, 1), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSwarm(EntityDreadSpawn.class, EntityDreadling.class, EntityChagarothSpawn.class, EntityChagarothFist.class), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSwarm(EntityShadowCreature.class, EntityShadowMonster.class), 2);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSwarm(EntityOmotholGhoul.class, EntityLesserShoggoth.class, EntityShadowBeast.class), 1);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSwarm(EntitySkeletonGoliath.class, EntityLesserShoggoth.class, EntityShadowBeast.class), 1);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerSwarm(EntityDreadguard.class, EntityGreaterDreadSpawn.class, EntityLesserShoggoth.class), 1);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerPotionEffect(ACPotions.Coralium_plague), 1);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerPotionEffect(ACPotions.Dread_plague), 1);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event){

		FMLLog.log("AbyssalBlocks", Level.INFO, "Registered triggers:");
		FMLLog.log("AbyssalBlocks", Level.INFO, "Category 1: %d", AbyssalBlocksAPI.getNumbers()[0]);
		FMLLog.log("AbyssalBlocks", Level.INFO, "Category 2: %d", AbyssalBlocksAPI.getNumbers()[1]);
		FMLLog.log("AbyssalBlocks", Level.INFO, "Category 3: %d", AbyssalBlocksAPI.getNumbers()[2]);
		FMLLog.log("AbyssalBlocks", Level.INFO, "Category 4: %d", AbyssalBlocksAPI.getNumbers()[3]);
		FMLLog.log("AbyssalBlocks", Level.INFO, "Category 5: %d", AbyssalBlocksAPI.getNumbers()[4]);
		FMLLog.log("AbyssalBlocks", Level.INFO, "Category 6: %d", AbyssalBlocksAPI.getNumbers()[5]);
		FMLLog.log("AbyssalBlocks", Level.INFO, "Category 7: %d", AbyssalBlocksAPI.getNumbers()[6]);
		FMLLog.log("AbyssalBlocks", Level.INFO, "Category 8: %d", AbyssalBlocksAPI.getNumbers()[7]);
		FMLLog.log("AbyssalBlocks", Level.INFO, "Category 9: %d", AbyssalBlocksAPI.getNumbers()[8]);
		FMLLog.log("AbyssalBlocks", Level.INFO, "Category 10: %d", AbyssalBlocksAPI.getNumbers()[9]);
		FMLLog.log("AbyssalBlocks", Level.INFO, "Total: %d", AbyssalBlocksAPI.getNumbers()[10]);
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if(eventArgs.modID.equals("acblocks"))
			syncConfig();
	}

	private static void syncConfig(){

		abyssalBlockSpawnrate = cfg.get(Configuration.CATEGORY_GENERAL, "AbyssalBlock generation probability", 100, "The probability out of n that a AbyssalBlock will spawn, setting this to higher values will decrease the chance of them spawning, while lower numbers increase it.", 0, Short.MAX_VALUE).getInt();
		shouldGenerate = cfg.get(Configuration.CATEGORY_GENERAL, "AbyssalBlock generating", true, "Toggles whether or not AbyssalBlocks should generate randomly throughout the world.").getBoolean();

		if(cfg.hasChanged())
			cfg.save();
	}

	private String getSupporterList(){
		BufferedReader nameFile;
		String names = "";
		try {
			nameFile = new BufferedReader(new InputStreamReader(new URL("https://raw.githubusercontent.com/Shinoow/AbyssalCraft/master/supporters.txt").openStream()));

			names = nameFile.readLine();
			nameFile.close();

		} catch (IOException e) {
			FMLLog.log("AbyssalBlocks", Level.ERROR, "Failed to fetch supporter list, using local version!");
			names = "Enfalas, Saice Shoop";
		}

		return names;
	}
}
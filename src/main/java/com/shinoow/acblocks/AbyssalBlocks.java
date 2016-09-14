package com.shinoow.acblocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.Metadata;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.Level;

import com.shinoow.abyssalcraft.api.AbyssalCraftAPI;
import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.common.entity.EntityAbyssalZombie;
import com.shinoow.abyssalcraft.common.entity.EntityChagarothFist;
import com.shinoow.abyssalcraft.common.entity.EntityChagarothSpawn;
import com.shinoow.abyssalcraft.common.entity.EntityDepthsGhoul;
import com.shinoow.abyssalcraft.common.entity.EntityDragonMinion;
import com.shinoow.abyssalcraft.common.entity.EntityDreadSpawn;
import com.shinoow.abyssalcraft.common.entity.EntityDreadguard;
import com.shinoow.abyssalcraft.common.entity.EntityDreadling;
import com.shinoow.abyssalcraft.common.entity.EntityGatekeeperMinion;
import com.shinoow.abyssalcraft.common.entity.EntityGreaterDreadSpawn;
import com.shinoow.abyssalcraft.common.entity.EntityLesserDreadbeast;
import com.shinoow.abyssalcraft.common.entity.EntityLesserShoggoth;
import com.shinoow.abyssalcraft.common.entity.EntityOmotholGhoul;
import com.shinoow.abyssalcraft.common.entity.EntityRemnant;
import com.shinoow.abyssalcraft.common.entity.EntityShadowBeast;
import com.shinoow.abyssalcraft.common.entity.EntityShadowCreature;
import com.shinoow.abyssalcraft.common.entity.EntityShadowMonster;
import com.shinoow.abyssalcraft.common.entity.EntitySkeletonGoliath;
import com.shinoow.abyssalcraft.common.entity.anti.EntityAntiAbyssalZombie;
import com.shinoow.abyssalcraft.common.entity.anti.EntityAntiCreeper;
import com.shinoow.abyssalcraft.common.entity.anti.EntityAntiGhoul;
import com.shinoow.abyssalcraft.common.entity.anti.EntityAntiPlayer;
import com.shinoow.abyssalcraft.common.entity.anti.EntityAntiSkeleton;
import com.shinoow.abyssalcraft.common.entity.anti.EntityAntiSpider;
import com.shinoow.abyssalcraft.common.entity.anti.EntityAntiZombie;
import com.shinoow.abyssalcraft.common.structures.StructureShoggothPit;
import com.shinoow.abyssalcraft.common.world.gen.WorldGenAbyLake;
import com.shinoow.abyssalcraft.common.world.gen.WorldGenAntimatterLake;
import com.shinoow.abyssalcraft.common.world.gen.WorldGenDreadlandsStalagmite;
import com.shinoow.abyssalcraft.common.world.gen.WorldGenShoggothMonolith;
import com.shinoow.abyssalcraft.lib.ACLoot;
import com.shinoow.acblocks.api.AbyssalBlocksAPI;
import com.shinoow.acblocks.api.trigger.TriggerMultipleRandomChestLoot;
import com.shinoow.acblocks.api.trigger.TriggerRandomChestLoot;
import com.shinoow.acblocks.api.trigger.TriggerSpawn;
import com.shinoow.acblocks.api.trigger.TriggerSwarm;
import com.shinoow.acblocks.common.blocks.BlockAbyssalBlock;
import com.shinoow.acblocks.common.schematics.Decorator;
import com.shinoow.acblocks.common.structures.AbyPillar;
import com.shinoow.acblocks.common.structures.AbyRuin;
import com.shinoow.acblocks.common.triggers.TriggerAntimatterExplosion;
import com.shinoow.acblocks.common.triggers.TriggerDarkRealmBanish;
import com.shinoow.acblocks.common.triggers.TriggerDemonAnimals;
import com.shinoow.acblocks.common.triggers.TriggerDisruption;
import com.shinoow.acblocks.common.triggers.TriggerFreePE;
import com.shinoow.acblocks.common.triggers.TriggerFreeRitualAltar;
import com.shinoow.acblocks.common.triggers.TriggerMonolithicCalamity;
import com.shinoow.acblocks.common.triggers.TriggerPotionEffect;
import com.shinoow.acblocks.common.triggers.TriggerRandomCrystals;
import com.shinoow.acblocks.common.triggers.TriggerRandomSchematic;
import com.shinoow.acblocks.common.triggers.TriggerRandomStructure;
import com.shinoow.acblocks.common.triggers.TriggerShoggothInfestation;
import com.shinoow.acblocks.world.AbyssalBlockWorldGenerator;

@Mod(modid = AbyssalBlocks.modid, name = AbyssalBlocks.name, version = AbyssalBlocks.version, dependencies = "required-after:Forge@[forgeversion,);required-after:abyssalcraft@[1.9.3,]", useMetadata = false, guiFactory = "com.shinoow.acblocks.client.config.ACBGuiFactory", acceptedMinecraftVersions = "[1.9]", updateJSON = "https://raw.githubusercontent.com/Shinoow/AbyssalBlocks/master/version.json")
public class AbyssalBlocks {

	public static final String modid = "acblocks";
	public static final String name = "AbyssalBlocks";
	public static final String version = "1.2.0";

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

		GameRegistry.register(abyssalBlock, new ResourceLocation(modid, "abyssalblock"));
		GameRegistry.register(new ItemBlock(abyssalBlock), new ResourceLocation(modid, "abyssalblock"));
		
		if(shouldGenerate)
			MinecraftForge.EVENT_BUS.register(new AbyssalBlockWorldGenerator());
	}

	@EventHandler
	public void Init(FMLInitializationEvent event){

		if(FMLCommonHandler.instance().getSide().isClient())
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(abyssalBlock), 0, new ModelResourceLocation("acblocks:abyssalblock", "inventory"));

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
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_SIMPLE_DUNGEON), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_SIMPLE_DUNGEON), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_SIMPLE_DUNGEON), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_SIMPLE_DUNGEON), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_SIMPLE_DUNGEON), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomChestLoot(LootTableList.CHESTS_STRONGHOLD_CORRIDOR), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_STRONGHOLD_CORRIDOR), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_STRONGHOLD_CORRIDOR), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomChestLoot(LootTableList.CHESTS_STRONGHOLD_CROSSING), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_STRONGHOLD_CROSSING), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_STRONGHOLD_CROSSING), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomChestLoot(LootTableList.CHESTS_ABANDONED_MINESHAFT), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_ABANDONED_MINESHAFT), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_ABANDONED_MINESHAFT), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_SPAWN_BONUS_CHEST), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_SPAWN_BONUS_CHEST), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_SPAWN_BONUS_CHEST), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_STRONGHOLD_LIBRARY), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_STRONGHOLD_LIBRARY), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_STRONGHOLD_LIBRARY), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_DESERT_PYRAMID), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_DESERT_PYRAMID), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_DESERT_PYRAMID), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_JUNGLE_TEMPLE), 8);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_JUNGLE_TEMPLE), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_JUNGLE_TEMPLE), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_VILLAGE_BLACKSMITH), 7);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_VILLAGE_BLACKSMITH), 6);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(LootTableList.CHESTS_VILLAGE_BLACKSMITH), 5);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ACLoot.CHEST_ABYSSAL_STRONGHOLD_CORRIDOR), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ACLoot.CHEST_ABYSSAL_STRONGHOLD_CROSSING), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ACLoot.CHEST_DREADLANDS_MINESHAFT), 9);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomChestLoot(ACLoot.CHEST_ABYSSAL_STRONGHOLD_CORRIDOR), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomChestLoot(ACLoot.CHEST_ABYSSAL_STRONGHOLD_CROSSING), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerMultipleRandomChestLoot(ACLoot.CHEST_DREADLANDS_MINESHAFT), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ACLoot.CHEST_ABYSSAL_STRONGHOLD_CORRIDOR), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ACLoot.CHEST_ABYSSAL_STRONGHOLD_CROSSING), 10);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerRandomChestLoot(ACLoot.CHEST_DREADLANDS_MINESHAFT), 10);
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
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerPotionEffect(AbyssalCraftAPI.coralium_plague), 1);
		AbyssalBlocksAPI.registerBlockTrigger(new TriggerPotionEffect(AbyssalCraftAPI.dread_plague), 1);
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
		if(eventArgs.getModID().equals("acblocks"))
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
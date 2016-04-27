package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.shinoow.abyssalcraft.AbyssalCraft;
import com.shinoow.abyssalcraft.common.util.SpecialTextUtil;
import com.shinoow.abyssalcraft.common.world.TeleporterDarkRealm;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerDarkRealmBanish extends BlockTrigger {

	@Override
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		if(world.provider.dimensionId != AbyssalCraft.configDimId4){
			if(rand.nextBoolean()){
				if(!world.isRemote)
					if(player instanceof EntityPlayerMP){
						WorldServer worldServer = (WorldServer) player.worldObj;
						EntityPlayerMP mp = (EntityPlayerMP) player;
						mp.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 80, 255));
						mp.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 20));
						mp.mcServer.getConfigurationManager().transferPlayerToDimension(mp, AbyssalCraft.configDimId4, new TeleporterDarkRealm(worldServer));
						player.addStat(AbyssalCraft.enterDarkRealm, 1);
					}
			} else {
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 30));
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 30));
				SpecialTextUtil.JzaharGroup(world, String.format("You were lucky this time %s, otherwise you'd end up in the depths.", player.getCommandSenderName()));
			}
		} else {
			player.addPotionEffect(new PotionEffect(Potion.blindness.id, 30));
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 30));
		}
	}
}
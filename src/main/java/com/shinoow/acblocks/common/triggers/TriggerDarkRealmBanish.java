package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import com.shinoow.abyssalcraft.AbyssalCraft;
import com.shinoow.abyssalcraft.lib.ACLib;
import com.shinoow.abyssalcraft.lib.util.SpecialTextUtil;
import com.shinoow.abyssalcraft.lib.world.TeleporterDarkRealm;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerDarkRealmBanish extends BlockTrigger {

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(world.provider.getDimensionId() != ACLib.dark_realm_id){
			if(rand.nextBoolean()){
				if(!world.isRemote)
					if(player instanceof EntityPlayerMP){
						WorldServer worldServer = (WorldServer) player.worldObj;
						EntityPlayerMP mp = (EntityPlayerMP) player;
						mp.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 80, 255));
						mp.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 20));
						mp.mcServer.getConfigurationManager().transferPlayerToDimension(mp, ACLib.dark_realm_id, new TeleporterDarkRealm(worldServer));
						player.addStat(AbyssalCraft.enterDarkRealm, 1);
					}
			} else {
				player.addPotionEffect(new PotionEffect(Potion.blindness.id, 30));
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 30));
				if(!world.isRemote)
					SpecialTextUtil.JzaharGroup(world, String.format("You were lucky this time %s, otherwise you'd end up in the depths.", player.getName()));
			}
		} else {
			player.addPotionEffect(new PotionEffect(Potion.blindness.id, 30));
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 30));
		}
	}
}
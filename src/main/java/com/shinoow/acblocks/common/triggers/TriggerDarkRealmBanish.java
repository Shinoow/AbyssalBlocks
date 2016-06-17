package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
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
		if(world.provider.getDimension() != ACLib.dark_realm_id){
			if(rand.nextBoolean()){
				if(!world.isRemote)
					if(player instanceof EntityPlayerMP){
						WorldServer worldServer = (WorldServer) player.worldObj;
						EntityPlayerMP mp = (EntityPlayerMP) player;
						mp.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 80, 255));
						mp.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 20));
						mp.mcServer.getPlayerList().transferPlayerToDimension(mp, ACLib.dark_realm_id, new TeleporterDarkRealm(worldServer));
						player.addStat(AbyssalCraft.enterDarkRealm, 1);
					}
			} else {
				player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 30));
				player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 30));
				if(!world.isRemote)
					SpecialTextUtil.JzaharGroup(world, String.format("You were lucky this time %s, otherwise you'd end up in the depths.", player.getName()));
			}
		} else {
			player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 30));
			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 30));
		}
	}
}
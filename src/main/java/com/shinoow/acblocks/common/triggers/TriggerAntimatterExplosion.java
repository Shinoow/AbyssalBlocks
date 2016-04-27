package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.common.entity.anti.EntityAntiSpider;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerAntimatterExplosion extends BlockTrigger {

	@Override
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		if(!world.isRemote){
		EntitySpider spider = new EntitySpider(world);
		EntityAntiSpider antispider = new EntityAntiSpider(world);
		spider.setLocationAndAngles(player.posX, player.posY, player.posZ, spider.rotationYaw, spider.rotationPitch);
		antispider.setLocationAndAngles(player.posX, player.posY, player.posZ, antispider.rotationYaw, antispider.rotationPitch);
		world.spawnEntityInWorld(spider);
		world.spawnEntityInWorld(antispider);
		}
	}
}
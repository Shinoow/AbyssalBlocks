package com.shinoow.acblocks.api.trigger;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TriggerSwarm extends BlockTrigger {

	private Class<? extends EntityLivingBase>[] entities;

	/**
	 * A Swarm Trigger
	 * @param entities A bunch of Entity classes to spawn
	 */
	public TriggerSwarm(Class<? extends EntityLivingBase>...entities){
		this.entities = entities;
	}

	private int randomNum(Random rand){
		return rand.nextBoolean() ? 5 : -5;
	}

	@Override
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		if(!world.isRemote)
			for(Class<? extends EntityLivingBase> clazz : entities)
				for(int i = 0; i < rand.nextInt(3) + 3; i++)
					try {
						EntityLivingBase entity = clazz.getConstructor(World.class).newInstance(world);
						entity.setLocationAndAngles(x + randomNum(rand), y + 1, z + randomNum(rand), entity.rotationYaw, entity.rotationPitch);
						((EntityLiving) entity).onSpawnWithEgg((IEntityLivingData)null);
						world.spawnEntityInWorld(entity);
					} catch (InstantiationException | IllegalAccessException
							| IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException
							| SecurityException e) {
						e.printStackTrace();
					}
	}
}
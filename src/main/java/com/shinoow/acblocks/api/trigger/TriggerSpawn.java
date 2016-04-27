package com.shinoow.acblocks.api.trigger;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TriggerSpawn extends BlockTrigger {

	private Class<? extends EntityLivingBase> entity;
	private int num;

	/**
	 * A Spawn Trigger
	 * @param entity Entity class to spawn
	 * @param num Amount of entities to spawn
	 */
	public TriggerSpawn(Class<? extends EntityLivingBase> entity, int num){
		this.entity = entity;
		this.num = num;
	}

	private int randomNum(Random rand){
		return rand.nextBoolean() ? 3 : -3;
	}

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote)
			for(int i = 0; i < num+1; i++){
				EntityLivingBase entityliving = null;
				try {
					entityliving = entity.getConstructor(World.class).newInstance(world);
				} catch (InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				if(entityliving != null){
					entityliving.setLocationAndAngles(pos.getX() + randomNum(rand), pos.getY() + 1, pos.getZ() + randomNum(rand), entityliving.rotationYaw, entityliving.rotationPitch);
					((EntityLiving) entityliving).onInitialSpawn(world.getDifficultyForLocation(pos.up()), (IEntityLivingData)null);
					world.spawnEntityInWorld(entityliving);
				}
			}
	}
}
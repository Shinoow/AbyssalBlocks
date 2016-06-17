package com.shinoow.acblocks.common.triggers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerPotionEffect extends BlockTrigger {

	private Potion potion;

	public TriggerPotionEffect(Potion potion){
		this.potion = potion;
	}

	private boolean isEntityImmune(Potion potion, Entity entity){
		boolean result = false;
		try {
			Class utilClass = Class.forName("com.shinoow.abyssalcraft.api.entity.EntityUtil");

			result = (Boolean)utilClass.getDeclaredMethod("isEntityImmune", EntityLivingBase.class, Potion.class).invoke(null, (EntityLivingBase)entity, potion);

		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote){
			List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.fromBounds(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1).expand(16, 16, 16));

			for(EntityLivingBase entity : entities)
				if(!isEntityImmune(potion, entity))
					entity.addPotionEffect(new PotionEffect(potion.id, 600));
		}
	}
}
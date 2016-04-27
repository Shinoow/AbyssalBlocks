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
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.AbyssalCraftAPI.ACPotions;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerPotionEffect extends BlockTrigger {

	private Potion potion;

	public TriggerPotionEffect(Potion potion){
		this.potion = potion;
	}

	private boolean isEntityImmune(Potion potion, Entity entity){
		boolean result = false;
		try {
			Class utilClass = Class.forName("com.shinoow.abyssalcraft.common.util.EntityUtil");

			result = potion == ACPotions.Coralium_plague && (Boolean)utilClass.getDeclaredMethod("isEntityCoralium", EntityLivingBase.class).invoke(null, (EntityLivingBase)entity) ||
					potion == ACPotions.Dread_plague && (Boolean)utilClass.getDeclaredMethod("isEntityDread", EntityLivingBase.class).invoke(null, (EntityLivingBase)entity) ||
					potion == ACPotions.Antimatter && (Boolean)utilClass.getDeclaredMethod("isEntityAnti", EntityLivingBase.class).invoke(null, (EntityLivingBase)entity);

		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		if(!world.isRemote){
			List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(x, y, z, x + 1, y + 1, z + 1).expand(16, 16, 16));

			for(EntityLivingBase entity : entities)
				if(!isEntityImmune(potion, entity))
					entity.addPotionEffect(new PotionEffect(potion.id, 600));
		}
	}
}
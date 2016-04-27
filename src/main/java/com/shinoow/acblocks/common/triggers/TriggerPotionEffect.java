package com.shinoow.acblocks.common.triggers;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.AbyssalCraftAPI;
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

			result = potion == AbyssalCraftAPI.coralium_plague && (Boolean)utilClass.getDeclaredMethod("isEntityCoralium", EntityLivingBase.class).invoke(null, (EntityLivingBase)entity) ||
					potion == AbyssalCraftAPI.dread_plague && (Boolean)utilClass.getDeclaredMethod("isEntityDread", EntityLivingBase.class).invoke(null, (EntityLivingBase)entity) ||
					potion == AbyssalCraftAPI.antimatter_potion && (Boolean)utilClass.getDeclaredMethod("isEntityAnti", EntityLivingBase.class).invoke(null, (EntityLivingBase)entity);

		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote){
			List<EntityLivingBase> entities = world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(pos).expand(16, 16, 16));

			for(EntityLivingBase entity : entities)
				if(!isEntityImmune(potion, entity))
					entity.addPotionEffect(new PotionEffect(potion, 600));
		}
	}
}
package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.common.entity.demon.EntityDemonChicken;
import com.shinoow.abyssalcraft.common.entity.demon.EntityDemonCow;
import com.shinoow.abyssalcraft.common.entity.demon.EntityDemonPig;
import com.shinoow.acblocks.api.trigger.BlockTrigger;

public class TriggerDemonAnimals extends BlockTrigger {

	private int randomNum(Random rand){
		return rand.nextBoolean() ? 3 : -3;
	}

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote){
			EntityDemonPig pig = new EntityDemonPig(world);
			EntityDemonCow cow = new EntityDemonCow(world);
			EntityDemonChicken chicken = new EntityDemonChicken(world);
			pig.setLocationAndAngles(pos.getX() + randomNum(world.rand), pos.getY() + 1, pos.getZ() + randomNum(world.rand), pig.rotationYaw, pig.rotationPitch);
			cow.setLocationAndAngles(pos.getX() + randomNum(world.rand), pos.getY() + 1, pos.getZ() + randomNum(world.rand), cow.rotationYaw, cow.rotationPitch);
			chicken.setLocationAndAngles(pos.getX() + randomNum(world.rand), pos.getY() + 1, pos.getZ() + randomNum(world.rand), chicken.rotationYaw, chicken.rotationPitch);
			pig.onInitialSpawn(world.getDifficultyForLocation(pig.getPosition()), null);
			cow.onInitialSpawn(world.getDifficultyForLocation(cow.getPosition()), null);
			chicken.onInitialSpawn(world.getDifficultyForLocation(chicken.getPosition()), null);
			world.spawnEntityInWorld(pig);
			world.spawnEntityInWorld(cow);
			world.spawnEntityInWorld(chicken);
		}
	}

}

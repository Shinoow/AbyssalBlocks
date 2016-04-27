package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
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
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		if(!world.isRemote){
			EntityDemonPig pig = new EntityDemonPig(world);
			EntityDemonCow cow = new EntityDemonCow(world);
			EntityDemonChicken chicken = new EntityDemonChicken(world);
			pig.setLocationAndAngles(x + randomNum(world.rand), y + 1, z + randomNum(world.rand), pig.rotationYaw, pig.rotationPitch);
			cow.setLocationAndAngles(x + randomNum(world.rand), y + 1, z + randomNum(world.rand), cow.rotationYaw, cow.rotationPitch);
			chicken.setLocationAndAngles(x + randomNum(world.rand), y + 1, z + randomNum(world.rand), chicken.rotationYaw, chicken.rotationPitch);
			world.spawnEntityInWorld(pig);
			world.spawnEntityInWorld(cow);
			world.spawnEntityInWorld(chicken);
		}
	}

}

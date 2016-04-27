package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.common.entity.EntityLesserShoggoth;
import com.shinoow.abyssalcraft.common.world.gen.WorldGenShoggothMonolith;

public class TriggerShoggothInfestation extends TriggerRandomStructure {

	public TriggerShoggothInfestation(){
		super(ACBlocks.shoggoth_ooze, new WorldGenShoggothMonolith());
	}

	protected int randomNum(Random rand){
		int num = 1;
		if(rand.nextInt(10) == 0)
			num *= rand.nextBoolean() ? 3 : 2;
		return rand.nextBoolean() ? num : num * -1;
	}

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		for(int i = 0; i < 6; i++){
			int xPos = rand.nextInt(32) * randomNum(rand);
			int zPos = rand.nextInt(32) * randomNum(rand);

			EntityLesserShoggoth shoggoth = new EntityLesserShoggoth(world);
			shoggoth.setLocationAndAngles(xPos + 5 * randomNum(rand), world.getHeight(pos.add(xPos, 0, zPos)).getY(), zPos + 5 * randomNum(rand), shoggoth.rotationYaw, shoggoth.rotationPitch);
			shoggoth.onInitialSpawn(world.getDifficultyForLocation(shoggoth.getPosition()), null);
			if(!world.isRemote)
				world.spawnEntityInWorld(shoggoth);
			super.trigger(world, rand, world.getHeight(pos.add(xPos, 0, zPos)), player);
		}
	}
}
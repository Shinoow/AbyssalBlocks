package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
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
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		for(int i = 0; i < 6; i++){
			int xPos = x + rand.nextInt(32) * randomNum(rand);
			int zPos = z + rand.nextInt(32) * randomNum(rand);
			int yPos = world.getHeightValue(xPos, zPos);

			EntityLesserShoggoth shoggoth = new EntityLesserShoggoth(world);
			shoggoth.setLocationAndAngles(xPos + 5 * randomNum(rand), yPos, zPos + 5 * randomNum(rand), shoggoth.rotationYaw, shoggoth.rotationPitch);
			shoggoth.onSpawnWithEgg(null);
			if(!world.isRemote)
				world.spawnEntityInWorld(shoggoth);
			super.trigger(world, rand, xPos, yPos, zPos, player);
		}
	}
}
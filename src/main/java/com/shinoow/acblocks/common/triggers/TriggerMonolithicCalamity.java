package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import com.shinoow.abyssalcraft.common.util.SpecialTextUtil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class TriggerMonolithicCalamity extends TriggerShoggothInfestation {

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		SpecialTextUtil.JzaharGroup(world, String.format("Well, prepare for calamity, mortals... Your fellow human %s just initiated the apocalypse.", player.getName()));
		for(int i = 0; i < 4; i++){
			super.trigger(world, rand, pos.add(rand.nextInt(10) * randomNum(rand), 0, rand.nextInt(10) * randomNum(rand)), player);
		}
	}
}
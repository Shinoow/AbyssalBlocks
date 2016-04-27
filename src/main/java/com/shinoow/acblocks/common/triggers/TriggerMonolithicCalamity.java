package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import com.shinoow.abyssalcraft.common.util.SpecialTextUtil;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TriggerMonolithicCalamity extends TriggerShoggothInfestation {

	@Override
	public void trigger(World world, Random rand, int x, int y, int z, EntityPlayer player) {
		SpecialTextUtil.JzaharGroup(world, String.format("Well, prepare for calamity, mortals... Your fellow human %s just initiated the apocalypse.", player.getCommandSenderName()));
		for(int i = 0; i < 4; i++){
			super.trigger(world, rand, x + rand.nextInt(10) * randomNum(rand), y, z + rand.nextInt(10) * randomNum(rand), player);
		}
	}
}
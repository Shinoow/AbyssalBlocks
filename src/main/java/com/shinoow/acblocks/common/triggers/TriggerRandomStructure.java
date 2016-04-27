package com.shinoow.acblocks.common.triggers;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.shinoow.acblocks.api.trigger.BlockTrigger;
import com.shinoow.acblocks.common.structures.ACHouse1;
import com.shinoow.acblocks.common.structures.ACHouse2;
import com.shinoow.acblocks.common.structures.ACPlatform1;
import com.shinoow.acblocks.common.structures.ACPlatform2;
import com.shinoow.acblocks.common.structures.ACScion1;
import com.shinoow.acblocks.common.structures.ACScion2;

public class TriggerRandomStructure extends BlockTrigger {

	private WorldGenerator[] structures;
	private boolean isSingle;
	private Block spawnBlock;

	public TriggerRandomStructure(Block spawnBlock, WorldGenerator...structures){
		this.structures = structures;
		isSingle = structures.length == 1 ? true : false;
		this.spawnBlock = spawnBlock;
	}

	public TriggerRandomStructure(WorldGenerator...structures){
		this(null, structures);
	}

	public TriggerRandomStructure(){
		this(new ACHouse1(), new ACHouse2(), new ACPlatform1(), new ACPlatform2(), new ACScion1(), new ACScion2());
	}

	@Override
	public void trigger(World world, Random rand, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote){
			if(spawnBlock != null){
				world.setBlockState(pos, spawnBlock.getDefaultState());
			}
			if(!isSingle)
				structures[rand.nextInt(structures.length)].generate(world, rand, pos);
			else structures[0].generate(world, rand, pos);
		}
	}
}
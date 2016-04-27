package com.shinoow.acblocks.common.structures;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.shinoow.abyssalcraft.api.block.ACBlocks;

public class ACScion2 extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, BlockPos pos) {

		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		world.setBlockState(new BlockPos(i + 0, j + 0, k + 0), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 6), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 1, k + 0), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 1, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 1, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 1, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 1, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 1, k + 6), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 2, k + 0), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 2, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 2, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 2, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 2, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 2, k + 6), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 0), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 3, k + 6), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 4, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 4, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 4, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 4, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 2), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 3), ACBlocks.darkstone_brick_stairs.getStateFromMeta(0), 2);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 4), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 3, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 1, j + 4, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 1), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 2), ACBlocks.darkstone_brick_slab.getStateFromMeta(13), 2);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 3), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 4), ACBlocks.darkstone_brick_slab.getStateFromMeta(13), 2);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 5), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 2), ACBlocks.darkstone_brick_slab.getStateFromMeta(13), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 3), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 4), ACBlocks.darkstone_brick_slab.getStateFromMeta(13), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 3), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 2, j + 4, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 1), ACBlocks.darkstone_brick_stairs.getStateFromMeta(2), 2);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 2), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 3), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 4), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 5), ACBlocks.darkstone_brick_stairs.getStateFromMeta(3), 2);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 2), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 3), Blocks.emerald_block.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 4), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 2), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 3), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 4), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 1), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 2), ACBlocks.darkstone_brick_slab.getStateFromMeta(13), 2);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 3), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 4), ACBlocks.darkstone_brick_slab.getStateFromMeta(13), 2);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 5), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 2), ACBlocks.darkstone_brick_slab.getStateFromMeta(13), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 3), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 4), ACBlocks.darkstone_brick_slab.getStateFromMeta(13), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 3), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 2), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 3), ACBlocks.darkstone_brick_stairs.getStateFromMeta(1), 2);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 4), ACBlocks.darkstone_brick_slab.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 0), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 6), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 0), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 6), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 0), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 6), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 0), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 6), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 0), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 6), ACBlocks.darkstone_brick.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 1), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 2), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 3), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 4), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 5), Blocks.air.getDefaultState(), 2);
		world.setBlockState(new BlockPos(i + 0, j + 4, k + 0), Blocks.redstone_torch.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 0, j + 4, k + 6), Blocks.redstone_torch.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 0), Blocks.redstone_torch.getStateFromMeta(5), 2);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 6), Blocks.redstone_torch.getStateFromMeta(5), 2);

		return true;
	}
}
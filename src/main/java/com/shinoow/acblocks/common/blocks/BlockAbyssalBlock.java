package com.shinoow.acblocks.common.blocks;

import java.util.Random;

import com.shinoow.abyssalcraft.api.energy.disruption.DisruptionHandler;
import com.shinoow.acblocks.api.AbyssalBlocksAPI;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockAbyssalBlock extends Block {

	public BlockAbyssalBlock() {
		super(Material.grass);
		setHardness(1.0F);
		setResistance(0);
		setCreativeTab(CreativeTabs.tabBlock);
		setUnlocalizedName("abyssalblock");
	}

	@Override
	public boolean removedByPlayer(World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
    {
		world.setBlockToAir(pos);
		AbyssalBlocksAPI.generateBlockTrigger(world, pos, player);
		return true;
    }

	@Override
	public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }

	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemById(0);
    }
}
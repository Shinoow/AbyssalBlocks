package com.shinoow.acblocks.common.blocks;

import java.util.Random;

import com.shinoow.abyssalcraft.api.energy.disruption.DisruptionHandler;
import com.shinoow.acblocks.api.AbyssalBlocksAPI;
import com.shinoow.acblocks.api.trigger.BlockTrigger;
import com.shinoow.acblocks.common.network.PacketDispatcher;
import com.shinoow.acblocks.common.network.client.MessageBlockTrigger;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockAbyssalBlock extends Block {

	public BlockAbyssalBlock() {
		super(Material.grass);
		setHardness(1.0F);
		setResistance(0);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("abyssalblock");
		setBlockTextureName("acblocks:abyssalblock");
	}

	@Override
	public boolean removedByPlayer(World world, EntityPlayer player, int x, int y, int z, boolean willHarvest)
	{
		world.setBlockToAir(x, y, z);
		trigger(world, x, y, z, player);
		return true;
	}

	@Override
	public int quantityDropped(Random p_149745_1_)
	{
		return 0;
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return Item.getItemById(0);
	}

	public void trigger(World world, int x, int y, int z, EntityPlayer player){
		AbyssalBlocksAPI.setSeed(world.rand);
		if(!world.isRemote){
			BlockTrigger trigger = AbyssalBlocksAPI.generateBlockTrigger();
			trigger.trigger(world, AbyssalBlocksAPI.getRNG(), x, y, z, player);
			PacketDispatcher.sendToDimension(new MessageBlockTrigger(trigger, x, y, z), world.provider.dimensionId);
		}
	}
}
package com.shinoow.acblocks.common.network.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

import com.shinoow.acblocks.api.AbyssalBlocksAPI;
import com.shinoow.acblocks.api.trigger.BlockTrigger;
import com.shinoow.acblocks.common.network.AbstractMessage.AbstractClientMessage;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;

public class MessageBlockTrigger extends AbstractClientMessage {

	private BlockTrigger trigger;
	private int x, y, z;

	public MessageBlockTrigger(){}
	
	public MessageBlockTrigger(BlockTrigger trigger, int x, int y, int z){
		this.trigger = trigger;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {

		trigger = AbyssalBlocksAPI.getTriggerFromName(ByteBufUtils.readUTF8String(buffer), ByteBufUtils.readVarInt(buffer, 5));
		x = ByteBufUtils.readVarInt(buffer, 5);
		y = ByteBufUtils.readVarInt(buffer, 5);
		z = ByteBufUtils.readVarInt(buffer, 5);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
	
		ByteBufUtils.writeUTF8String(buffer, trigger.getName());
		ByteBufUtils.writeVarInt(buffer, trigger.getNum(), 5);
		ByteBufUtils.writeVarInt(buffer, x, 5);
		ByteBufUtils.writeVarInt(buffer, y, 5);
		ByteBufUtils.writeVarInt(buffer, z, 5);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if(trigger != null)
			trigger.trigger(player.worldObj, AbyssalBlocksAPI.getRNG(), x, y, z, player);
	}
}
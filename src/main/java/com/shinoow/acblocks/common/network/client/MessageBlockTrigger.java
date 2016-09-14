package com.shinoow.acblocks.common.network.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;

import com.shinoow.acblocks.api.AbyssalBlocksAPI;
import com.shinoow.acblocks.api.trigger.BlockTrigger;
import com.shinoow.acblocks.common.network.AbstractMessage.AbstractClientMessage;

public class MessageBlockTrigger extends AbstractClientMessage {

	private BlockTrigger trigger;
	private int x, y, z;

	public MessageBlockTrigger(){}

	public MessageBlockTrigger(BlockTrigger trigger, BlockPos pos){
		this.trigger = trigger;
		this.x = pos.getX();
		this.y = pos.getY();
		this.z = pos.getZ();
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
		BlockPos pos = new BlockPos(x, y, z);
		if(trigger != null)
			trigger.trigger(player.worldObj, AbyssalBlocksAPI.getRNG(), pos, player);
	}
}
package dazsim.alchemicraft;


import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;



public interface PacketHandler {
	public void readBytes(ByteBuf bytes);
	public void writeBytes(ByteBuf bytes);
	public void executeClient(EntityPlayer player);
	public void executeServer(EntityPlayer player);
	
	
	//public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	
		
	
}


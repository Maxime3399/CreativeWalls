package fr.Maxime3399.CreativeWalls.versions;

import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_7_R1.ChatSerializer;
import net.minecraft.server.v1_7_R1.IChatBaseComponent;
import net.minecraft.server.v1_7_R1.PacketPlayOutChat;

public class Version1_7_R1 implements Versions{

	@Override
	public void sendJsonMessage(Player player, String JsonMessage) {
		
		IChatBaseComponent comp = ChatSerializer.a(JsonMessage);
		PacketPlayOutChat packet = new PacketPlayOutChat(comp);
		
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
		
	}

}

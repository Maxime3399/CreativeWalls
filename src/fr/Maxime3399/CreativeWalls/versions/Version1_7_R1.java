package fr.Maxime3399.CreativeWalls.versions;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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

	@Override
	public ItemStack generateDataItem(String item) {
		
		ItemStack IS = null;
		
		if(item.equalsIgnoreCase("WHITE_STAINED_GLASS")) {
			IS = new ItemStack(Material.STAINED_GLASS);
		}
		
		return IS;
		
	}

	@Override
	public Sound generateSound(String sound) {
		
		Sound s = null;
		
		if(sound.equalsIgnoreCase("VILLAGER_NO")) {
			s = Sound.VILLAGER_NO;
		}else if(sound.equalsIgnoreCase("PISTON_EXTEND")) {
			s = Sound.PISTON_EXTEND;
		}
		
		return s;
		
	}

}

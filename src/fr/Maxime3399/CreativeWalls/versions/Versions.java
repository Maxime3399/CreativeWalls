package fr.Maxime3399.CreativeWalls.versions;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Versions {
	
	public void sendJsonMessage(Player player, String JsonMessage);
	
	public ItemStack generateDataItem(String item);
	
	public Sound generateSound(String sound);

}

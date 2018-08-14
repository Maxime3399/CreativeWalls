package fr.Maxime3399.CreativeWalls.custom;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CustomPlayer {
	
	private UUID uuid;
	private ItemStack[] inventory;
	
	private ArrayList<Location> selectedBlocks = new ArrayList<>();
	
	
	public CustomPlayer(Player player) {
		
		setUuid(player.getUniqueId());
		saveInventory(player);
		
	}


	public UUID getUuid() {
		return uuid;
	}


	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}


	public ItemStack[] getInventory() {
		return inventory;
	}


	public void setInventory(ItemStack[] inventory) {
		this.inventory = inventory;
	}
	
	public void saveInventory(Player player) {
		
		inventory = player.getInventory().getContents().clone();
		
	}
	
	public void restoreInventory(Player player) {
		
		player.getInventory().clear();
		player.getInventory().setContents(inventory);
		
	}


	public ArrayList<Location> getSelectedBlocks() {
		return selectedBlocks;
	}


	public void setSelectedBlocks(ArrayList<Location> selectedBlocks) {
		this.selectedBlocks = selectedBlocks;
	}

}

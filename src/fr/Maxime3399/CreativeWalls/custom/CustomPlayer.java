package fr.Maxime3399.CreativeWalls.custom;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CustomPlayer {
	
	private UUID uuid;
	private ItemStack[] inventory;
	
	private ArrayList<Block> selectedBlocks;
	
	
	public CustomPlayer(Player player) {
		
		setUuid(player.getUniqueId());
		setInventory(player.getInventory().getContents());
		
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


	public ArrayList<Block> getSelectedBlocks() {
		return selectedBlocks;
	}


	public void setSelectedBlocks(ArrayList<Block> selectedBlocks) {
		this.selectedBlocks = selectedBlocks;
	}
	
	public boolean addSelectedBlock(Block block) {
		if(!selectedBlocks.contains(block)) {
			selectedBlocks.add(block);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removeSelectedBlock(Block block) {
		if(selectedBlocks.contains(block)) {
			selectedBlocks.remove(block);
			return true;
		}else {
			return false;
		}
	}

}

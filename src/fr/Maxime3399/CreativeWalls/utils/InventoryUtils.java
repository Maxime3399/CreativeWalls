package fr.Maxime3399.CreativeWalls.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.Maxime3399.CreativeWalls.custom.CustomPlayer;
import fr.Maxime3399.CreativeWalls.managers.PlayersManagers;
import fr.Maxime3399.CreativeWalls.managers.VersionsManager;

public class InventoryUtils {
	
	public static void setCreativeInventory(Player p) {
		
		Inventory inv = p.getInventory();
		
		ItemStack IScancel = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta IMcancel = IScancel.getItemMeta();
		IMcancel.setDisplayName("§4§l✘");
		IScancel.setItemMeta(IMcancel);
		
		ItemStack ISblock = VersionsManager.use().generateDataItem("STAINED_GLASS");
		ItemMeta IMblock = ISblock.getItemMeta();
		IMblock.setDisplayName(MessageUtils.getMessage("Item_wall_block"));
		ISblock.setItemMeta(IMblock);
		ISblock.setAmount(64);
		
		ItemStack ISconfirm = new ItemStack(Material.SLIME_BALL);
		ItemMeta IMconfirm = ISconfirm.getItemMeta();
		IMconfirm.setDisplayName("§2§l✔");
		ISconfirm.setItemMeta(IMconfirm);
		
		inv.setItem(1, IScancel);
		inv.setItem(4, ISblock);
		inv.setItem(7, ISconfirm);
		
	}
	
	public static void resetInventory(Player player) {
		
		CustomPlayer cp = PlayersManagers.getCustomPlayer(player);
		player.getInventory().clear();
		player.getInventory().setContents(cp.getInventory());
		
	}

}

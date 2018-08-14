package fr.Maxime3399.CreativeWalls.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.Maxime3399.CreativeWalls.managers.PlayersManagers;

public class SystemEvents implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		
		Player player = e.getPlayer();
		
		PlayersManagers.removePlayer(player);
		
	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		
		Player player = e.getPlayer();
		
		if(PlayersManagers.playerIsRegistered(player)) {
			
			e.setCancelled(true);
			
		}
		
	}
	
	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		
		Player player = e.getPlayer();
		
		if(PlayersManagers.playerIsRegistered(player)) {
			
			e.setCancelled(true);
			
		}
		
	}
	
	@EventHandler
	public void onInv(InventoryInteractEvent e) {
		
		Player player = (Player) e.getWhoClicked();
		
		if(PlayersManagers.playerIsRegistered(player)) {
			
			e.setCancelled(true);
			
		}
		
	}

}

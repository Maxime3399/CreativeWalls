package fr.Maxime3399.CreativeWalls.managers;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import fr.Maxime3399.CreativeWalls.custom.CustomPlayer;
import fr.Maxime3399.CreativeWalls.utils.InventoryUtils;

public class PlayersManagers {
	
	private static ArrayList<CustomPlayer> players = new ArrayList<>();
	
	public static ArrayList<CustomPlayer> getPlayers(){
		
		return players;
		
	}
	
	public static CustomPlayer addPlayer(Player player) {
		
		CustomPlayer cp = null;
		
		if(!playerIsRegistered(player)) {
			
			cp = new CustomPlayer(player);
			players.add(cp);
			InventoryUtils.setCreativeInventory(player);
			
		}
		
		return cp;
		
	}
	
	public static void removePlayer(Player player) {
		
		if(playerIsRegistered(player)) {
			
			CustomPlayer cp = getCustomPlayer(player);
			cp.restoreInventory(player);
			players.remove(cp);
			
		}
		
	}
	
	public static boolean playerIsRegistered(Player player) {
		
		boolean registered = false;
		
		for(CustomPlayer cp : players) {
			
			if(cp.getUuid() == player.getUniqueId()) {
				
				registered = true;
				
			}
			
		}
		
		return registered;
		
	}
	
	public static CustomPlayer getCustomPlayer(Player player) {
		
		CustomPlayer cp = null;
		
		for(CustomPlayer cps : players) {
			
			if(cps.getUuid() == player.getUniqueId()) {
				
				cp = cps;
				
			}
			
		}
		
		return cp;
		
	}

}

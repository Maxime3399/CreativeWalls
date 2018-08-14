package fr.Maxime3399.CreativeWalls.events;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import fr.Maxime3399.CreativeWalls.custom.CustomPlayer;
import fr.Maxime3399.CreativeWalls.managers.PlayersManagers;
import fr.Maxime3399.CreativeWalls.utils.MessageUtils;

public class BlockEvents implements Listener {
	
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		
		Player player = e.getPlayer();
		
		if(PlayersManagers.playerIsRegistered(player)) {
			
			CustomPlayer cp = PlayersManagers.getCustomPlayer(player);
			
			if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(MessageUtils.getMessage("Item_wall_block"))) {
				
				Block b = e.getBlock();
				Location l = b.getLocation();
				cp.getSelectedBlocks().add(l);
				
			}else {
				
				e.setCancelled(true);
				
			}
			
		}
		
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		Player player = e.getPlayer();
		
		
	}

}

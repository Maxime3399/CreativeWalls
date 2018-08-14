package fr.Maxime3399.CreativeWalls.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.CreativeWalls.managers.PlayersManagers;
import fr.Maxime3399.CreativeWalls.managers.VersionsManager;
import fr.Maxime3399.CreativeWalls.utils.MessageUtils;

public class CreateCMD {
	
	public static void commandPlayer(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(player.hasPermission("creativewalls.command.create")) {
			
			PlayersManagers.addPlayer(player);
			
			player.sendMessage(MessageUtils.getPluginPrefix()+"§r "+MessageUtils.getMessage("Message_create_wall"));
			player.playSound(player.getLocation(), VersionsManager.use().generateSound("LEVEL_UP"), 100, 1);
			
		}else {
			
			player.sendMessage(MessageUtils.getPluginPrefix()+"§r "+MessageUtils.getMessage("No_permission"));
			player.playSound(player.getLocation(), VersionsManager.use().generateSound("VILLAGER_NO"), 100, 1);
			
		}
		
	}

}

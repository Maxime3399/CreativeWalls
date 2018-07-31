package fr.Maxime3399.CreativeWalls.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.CreativeWalls.MainClass;
import fr.Maxime3399.CreativeWalls.managers.VersionsManager;
import fr.Maxime3399.CreativeWalls.utils.MessageUtils;

public class ReloadCMD {
	
	public static void commandPlayer(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(player.hasPermission("creativewalls.command.reload")) {
			
			MainClass.reload();
			player.sendMessage(MessageUtils.getPluginPrefix()+"§r "+MessageUtils.getMessage("Plugin_reloaded"));
			player.playSound(player.getLocation(), VersionsManager.use().generateSound("PISTON_EXTEND"), 100, 1);
			
		}else {
			
			player.sendMessage(MessageUtils.getPluginPrefix()+"§r "+MessageUtils.getMessage("No_permission"));
			player.playSound(player.getLocation(), VersionsManager.use().generateSound("VILLAGER_NO"), 100, 1);
			
		}
		
	}
	
	public static void commandConsole(CommandSender sender, Command cmd, String label, String[] args) {
		
		MainClass.reload();
		sender.sendMessage(MessageUtils.getPluginPrefix()+"§r "+MessageUtils.getMessage("Plugin_reloaded"));
		
	}

}

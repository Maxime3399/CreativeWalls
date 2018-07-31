package fr.Maxime3399.CreativeWalls.managers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Maxime3399.CreativeWalls.utils.MessageUtils;

public class CommandsManager {
	
	public static void execute(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
			Player player = (Player) sender;
			
			if(args.length <= 0) {
				
				if(player.hasPermission("creativewalls.command.help")) {
					
					player.sendMessage(MessageUtils.getPluginPrefix()+"§r "+MessageUtils.getMessage("Command_invalid_help"));
					player.playSound(player.getLocation(), VersionsManager.use().generateSound("VILLAGER_NO"), 100, 1);
					
				}else {
					
					player.sendMessage(MessageUtils.getPluginPrefix()+"§r "+MessageUtils.getMessage("No_permission"));
					player.playSound(player.getLocation(), VersionsManager.use().generateSound("VILLAGER_NO"), 100, 1);
					
				}
				
			}else {
				
				String argument = args[0];
				
				if(argument.equalsIgnoreCase("reload")) {
					
					
					
				}
				
			}
			
		}
		
		/*if(sender instanceof ConsoleCommandSender) {
			
			
			
		}*/
		
	}

}

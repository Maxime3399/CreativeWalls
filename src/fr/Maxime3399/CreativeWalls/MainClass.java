package fr.Maxime3399.CreativeWalls;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Maxime3399.CreativeWalls.managers.CommandsManager;
import fr.Maxime3399.CreativeWalls.managers.ConfigManager;
import fr.Maxime3399.CreativeWalls.managers.VersionsManager;
import fr.Maxime3399.CreativeWalls.utils.MessageUtils;

public class MainClass extends JavaPlugin{
	
	private static Plugin plugin;
	
	public void onEnable() {
		
		plugin = this;
		MessageUtils.setupSimpleMessages();
		
		if(VersionsManager.setupVersion()) {
			
			if(ConfigManager.setupConfiguration()) {
				
				//start
				MessageUtils.setupMessages();
				
			}else {
				
				Bukkit.getConsoleSender().sendMessage(MessageUtils.getPluginPrefix()+" §r"+MessageUtils.getMessage("Configuration_creation_problem"));
				disable();
				
			}
			
		}else {
			
			Bukkit.getConsoleSender().sendMessage(MessageUtils.getPluginPrefix()+" §r"+MessageUtils.getMessage("Invalid_version").replaceAll("%version%", VersionsManager.getVersion()));
			disable();
			
		}
		
	}
	
	public static Plugin getInstance() {
		
		return plugin;
		
	}
	
	private static void disable() {
		
		Bukkit.getPluginManager().disablePlugin(plugin);
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		CommandsManager.execute(sender, cmd, label, args);
		
		return true;
		
	}

}

package fr.Maxime3399.CreativeWalls;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Maxime3399.CreativeWalls.managers.CommandsManager;
import fr.Maxime3399.CreativeWalls.managers.ConfigManager;
import fr.Maxime3399.CreativeWalls.managers.EventsManager;
import fr.Maxime3399.CreativeWalls.managers.PlayersManagers;
import fr.Maxime3399.CreativeWalls.managers.SchedulersManagers;
import fr.Maxime3399.CreativeWalls.managers.VersionsManager;
import fr.Maxime3399.CreativeWalls.utils.MessageUtils;

public class MainClass extends JavaPlugin{
	
	private static Plugin plugin;
	
	public void onEnable() {
		
		plugin = this;
		MessageUtils.setupSimpleMessages();
		
		if(VersionsManager.setupVersion()) {
			
			if(ConfigManager.setupConfiguration()) {
				
				MessageUtils.setupMessages();
				EventsManager.registerEvents();		
				SchedulersManagers.registerSchedulers();
				
			}else {
				
				Bukkit.getConsoleSender().sendMessage(MessageUtils.getPluginPrefix()+" §r"+MessageUtils.getMessage("Configuration_creation_problem"));
				disable();
				
			}
			
		}else {
			
			Bukkit.getConsoleSender().sendMessage(MessageUtils.getPluginPrefix()+" §r"+MessageUtils.getMessage("Invalid_version").replaceAll("%version%", VersionsManager.getVersion()));
			disable();
			
		}
		
	}
	
	public void onDisable() {
		
		for(Player pls : Bukkit.getOnlinePlayers()) {
			
			PlayersManagers.removePlayer(pls);
			
		}
		
	}
	
	public static Plugin getInstance() {
		
		return plugin;
		
	}
	
	public static void reload() {
		
		disable();
		enable();
		
	}
	
	public static void disable() {
		
		Bukkit.getPluginManager().disablePlugin(plugin);
		
	}
	
	public static void enable() {
		
		Bukkit.getPluginManager().enablePlugin(plugin);
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		CommandsManager.execute(sender, cmd, label, args);
		
		return true;
		
	}
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args){
		
		return CommandsManager.tabComplete(sender, cmd, label, args);
		
	}

}

package fr.Maxime3399.CreativeWalls.managers;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import fr.Maxime3399.CreativeWalls.MainClass;

public class ConfigManager {
	
	private static FileConfiguration config;
	private static FileConfiguration walls;
	
	public static boolean setupConfiguration() {
		
		boolean success = true;
		Plugin plugin = MainClass.getInstance();
		
		if(!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdir();
		}
		
		File fConfig = new File(plugin.getDataFolder(), "config.yml");
		if(!fConfig.exists()) {
			plugin.getConfig().options().copyDefaults(true);
			plugin.saveDefaultConfig();
		}
		config = YamlConfiguration.loadConfiguration(fConfig);
		
		File fWalls = new File(plugin.getDataFolder(), "walls.yml");
		if(!fWalls.exists()) {
			try {
				fWalls.createNewFile();
			} catch (IOException e) {
				success = false;
			}
		}
		walls = YamlConfiguration.loadConfiguration(fWalls);
		
		return success;
		
	}
	
	public static FileConfiguration get(String configurationFile) {
		
		if(configurationFile.contains("config")) {
			
			return config;
			
		}else if(configurationFile.contains("walls")) {
			
			return walls;
			
		}else {
			
			return null;
			
		}
		
	}

}

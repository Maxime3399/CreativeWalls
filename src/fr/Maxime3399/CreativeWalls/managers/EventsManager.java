package fr.Maxime3399.CreativeWalls.managers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.Maxime3399.CreativeWalls.MainClass;
import fr.Maxime3399.CreativeWalls.events.BlockEvents;
import fr.Maxime3399.CreativeWalls.events.SystemEvents;

public class EventsManager {
	
	public static void registerEvents() {
		
		Plugin p = MainClass.getInstance();
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new SystemEvents(), p);
		pm.registerEvents(new BlockEvents(), p);
		
	}

}

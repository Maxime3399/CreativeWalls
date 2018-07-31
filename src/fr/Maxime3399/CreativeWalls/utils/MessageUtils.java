package fr.Maxime3399.CreativeWalls.utils;

import java.util.HashMap;

public class MessageUtils {
	
	private static HashMap<String, String> messagesEN = new HashMap<>();
	
	public static void setupSimpleMessages() {
		
		messagesEN.put("Invalid_version", "§cThe plugin is not available in version %version%");
		messagesEN.put("Configuration_creation_problem", "§&cThe configuration files could not be created");
		
	}
	
	public static void setupMessages() {
		
		messagesEN.put("Item_wall_block", "§eWall Block");
		messagesEN.put("Command_invalid_help", "§cInvalid command ! Use : §l/cw help");
		messagesEN.put("No_permission", "§cYou don't have the permission !");
		messagesEN.put("Plugin_reloaded", "§aPlugin reloaded.");
		
	}
	
	public static String getPluginPrefix() {
		
		return "§9§l[§r§aCreative§eWalls§9§l]";
		
	}
	
	public static String getMessage(String MessageID) {
		
		if(messagesEN.containsKey(MessageID)) {
			return messagesEN.get(MessageID);
		}else {
			return null;
		}
		
	}

}

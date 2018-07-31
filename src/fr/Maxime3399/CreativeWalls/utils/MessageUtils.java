package fr.Maxime3399.CreativeWalls.utils;

import java.util.HashMap;

public class MessageUtils {
	
	private static HashMap<String, String> messagesEN = new HashMap<>();
	
	public static void setupSimpleMessages() {
		
		messagesEN.put("Invalid_version", "§cThe plugin is not available in version %version%");
		messagesEN.put("Configuration_creation_problem", "§&cThe configuration files could not be created");
		messagesEN.put("Command_invalid_help", "§cInvalid command ! Use : §l/cw help");
		messagesEN.put("No_permission", "§cYou don't have the permission !");
		
	}
	
	public static void setupMessages() {
		
		messagesEN.put("Item_wall_block", "§eWall Block");
		
	}
	
	public static String getPluginPrefix() {
		
		return "§9§l[§r§aCreative§eWalls§9§l]";
		
	}
	
	public static String getMessage(String MessageID) {
		
		if(messagesEN.containsValue(MessageID)) {
			return messagesEN.get(MessageID);
		}else {
			return null;
		}
		
	}

}

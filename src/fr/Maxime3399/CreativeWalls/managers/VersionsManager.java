package fr.Maxime3399.CreativeWalls.managers;

import org.bukkit.Bukkit;

import fr.Maxime3399.CreativeWalls.versions.Version1_7_R1;
import fr.Maxime3399.CreativeWalls.versions.Versions;

public class VersionsManager {
	
	private static String version = "?";
	private static Versions vclass;
	
	public static boolean setupVersion() {
		
		boolean result = true;
		
		try {
			version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		}catch (ArrayIndexOutOfBoundsException e) {
			result = false;
		}
		
		if(version.equals("v1_7_R1")) {
			vclass = new Version1_7_R1();
		}else {
			result = false;
		}
		
		return result;
		
	}
	
	public static Versions use() {
		
		return vclass;
		
	}
	
	public static String getVersion() {
		
		return version;
		
	}

}

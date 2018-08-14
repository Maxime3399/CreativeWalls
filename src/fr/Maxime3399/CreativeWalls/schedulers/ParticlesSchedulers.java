package fr.Maxime3399.CreativeWalls.schedulers;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import fr.Maxime3399.CreativeWalls.MainClass;
import fr.Maxime3399.CreativeWalls.custom.CustomPlayer;
import fr.Maxime3399.CreativeWalls.custom.Particles;
import fr.Maxime3399.CreativeWalls.managers.PlayersManagers;
import fr.Maxime3399.CreativeWalls.utils.UtilParticles;

public class ParticlesSchedulers {
	
	public static void start() {
		
		Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				
				ArrayList<Location> locs = new ArrayList<>();
				for(CustomPlayer cps : PlayersManagers.getPlayers()) {
					
					locs.addAll(cps.getSelectedBlocks());
					
				}
				
				for(Location ls : locs) {
					
					Location la = ls.clone().add(0.5, 0.5, 0.5);
					UtilParticles.display(Particles.CLOUD, la, 1, 0);
					
				}
				
			}
			
		}, 3, 3);
		
	}

}

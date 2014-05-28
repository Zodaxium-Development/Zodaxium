package me.zodaxium.essentials.timers;

import java.util.logging.Level;

import me.zodaxium.essentials.Zodaxium;

import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerWorldSave extends BukkitRunnable{

	Zodaxium plugin;
	
	public TimerWorldSave(Zodaxium plugin){
		this.plugin = plugin;
	}
	
	public void run(){
		for(World world : plugin.getServer().getWorlds()){
			world.save();
		}
		plugin.getLogger().log(Level.INFO, "All Worlds Saved! Total: " + plugin.getServer().getWorlds().size());
	}
}

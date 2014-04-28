package me.zodaxium.zessentials.listeners;

import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.Chunk;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Listenerrespawn implements Listener{

	ZEssentials plugin;
	
	public Listenerrespawn(ZEssentials plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e){
		final Player p = e.getPlayer();
		final Chunk chunk = plugin.spawn.getChunk();
		plugin.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable(){
			@Override
			public void run(){
				if(!chunk.isLoaded()){
					chunk.load();
				}
				p.teleport(plugin.spawn);
			}		
		}, 2);
	}
}

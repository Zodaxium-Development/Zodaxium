package me.zodaxium.zessentials.listeners;

import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Listenerjoin implements Listener{

	ZEssentials plugin;
	
	public Listenerjoin(ZEssentials plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		final Player p = e.getPlayer();
		e.setJoinMessage(null);
		if(!p.hasPlayedBefore()){
			plugin.getServer().getScheduler().runTaskLater(plugin, new BukkitRunnable(){
				@Override
				public void run() {
					p.teleport(plugin.spawn);
				}			
			}, 10);
		}
	}
}

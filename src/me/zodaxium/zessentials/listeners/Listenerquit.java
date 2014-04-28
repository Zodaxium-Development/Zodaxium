package me.zodaxium.zessentials.listeners;

import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listenerquit implements Listener{

ZEssentials plugin;
	
	public Listenerquit(ZEssentials plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerQuitEvent e){
		e.setQuitMessage(null);
	}
}

package me.zodaxium.essentials.listeners;

import me.zodaxium.essentials.Zodaxium;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listenerquit implements Listener{

Zodaxium plugin;
	
	public Listenerquit(Zodaxium plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerQuitEvent e){
		e.setQuitMessage(null);
	}
}

package me.zodaxium.zessentials.listeners;

import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class Listenersign implements Listener{

	ZEssentials plugin;
	
	public Listenersign(ZEssentials plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e){
		String[] lines = e.getLines();
		for(int i = 0; i < lines.length; i++){
			e.setLine(i, plugin.colorize(lines[i]));
		}
	}
}

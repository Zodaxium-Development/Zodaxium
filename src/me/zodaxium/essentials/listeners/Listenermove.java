package me.zodaxium.essentials.listeners;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Listenermove implements Listener{

	Zodaxium plugin;
	
	public Listenermove(Zodaxium plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Location loc = p.getLocation();
		if(e.getTo() == e.getFrom()) return;
		if(loc.getY() <= -5){ 
			ZodaxApi.sendMessage(p, "&aYou were teleported to spawn");
			p.teleport(plugin.spawn);
			p.setFallDistance(0);
		}
	}
}

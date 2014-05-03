package me.zodaxium.zessentials.listeners;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Listenermove implements Listener{

	ZEssentials plugin;
	
	public Listenermove(ZEssentials plugin){
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Location loc = p.getLocation();
		if(e.getTo() == e.getFrom()) return;
		if(loc.getY() <= -5){ 
			p.sendMessage(plugin.colorize(Reference.PREFIX + "&aYou were teleported to spawn"));
			p.teleport(plugin.spawn);
			p.setFallDistance(0);
		}
	}
}

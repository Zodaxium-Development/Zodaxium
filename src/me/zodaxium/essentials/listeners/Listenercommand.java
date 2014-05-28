package me.zodaxium.essentials.listeners;

import java.util.Arrays;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class Listenercommand implements Listener{

	Zodaxium plugin;
	
	public Listenercommand(Zodaxium plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerCommand(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		String[] args = e.getMessage().split(" ");
		String cmd = args[0].replaceFirst("/", "");
		if(cmd.equalsIgnoreCase("plugins") || cmd.equalsIgnoreCase("pl") || cmd.equalsIgnoreCase("?")){
			e.setCancelled(true);
			if(p.hasPermission("zessentials.plugin")){
				Plugin[] plugins = plugin.getServer().getPluginManager().getPlugins();
				String[] names = new String[plugins.length];
				for(int i = 0; i < plugins.length; i++){
					if(plugins[i].isEnabled())
						names[i] = "&a" + plugins[i].getDescription().getName();
					else
						names[i] = "&c" + plugins[i].getDescription().getName();
				}
				Arrays.sort(names);
				ZodaxApi.sendMessage(p, "&9Plugins(&6" + names.length + "&9): " + StringUtils.join(names, "&9, "));
			}else{
				ZodaxApi.sendMessage(p, "&9Plugins(&61&9): &aZodaxiumGaming");
			}
		}
	}
}

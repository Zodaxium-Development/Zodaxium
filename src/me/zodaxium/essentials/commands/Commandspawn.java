package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;

import org.bukkit.entity.Player;

public class Commandspawn extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandspawn(Zodaxium plugin){
		this.plugin = plugin;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void execute(Player p, String[] args){
		if(plugin.spawn != null && plugin.getServer().getWorlds().contains(plugin.spawn.getWorld())){
			if(args.length < 1){
				p.teleport(plugin.spawn);
				ZodaxApi.sendMessage(p, "&aYou were teleported to spawn");
			}else{
				if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
					Player t = plugin.getServer().getPlayer(args[0]);
					if(t != null){
						t.teleport(plugin.spawn);
						ZodaxApi.sendMessage(t, "&aYou were teleported to spawn");
						ZodaxApi.sendMessage(p, "&aPlayer: &9" + t.getName() + " &asent to spawn");
					}else{
						p.sendMessage(ZodaxApi.DENY_USER);
					}
				}else{
					p.teleport(plugin.spawn);
				}
			}
		}else{
			ZodaxApi.sendMessage(p, "&aSpawn has not been set!");
		}
	}
}

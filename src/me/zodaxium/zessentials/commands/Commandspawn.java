package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.entity.Player;

public class Commandspawn extends AbstractCommand{

	ZEssentials plugin;
	
	public Commandspawn(ZEssentials plugin){
		this.plugin = plugin;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void execute(Player p, String[] args){
		if(plugin.spawn != null && plugin.getServer().getWorlds().contains(plugin.spawn.getWorld())){
			if(args.length < 1){
				if(plugin.spawn != null && plugin.getServer().getWorld(plugin.spawn.getWorld().getName()) != null){
					p.teleport(plugin.spawn);
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aYou were teleported to spawn"));
				}else{
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aNo Spawn Set!"));
				}
			}else{
				if(p.hasPermission(Reference.PERM_ADMIN)){
					Player t = plugin.getServer().getPlayer(args[0]);
					if(plugin.spawn != null && plugin.getServer().getWorld(plugin.spawn.getWorld().getName()) != null){
						if(t != null){
							t.teleport(plugin.spawn);
							t.sendMessage(Reference.colorize(Reference.PREFIX + "&aYou were teleported to spawn"));
							p.sendMessage(Reference.colorize(Reference.PREFIX + "&aPlayer: &9" + t.getName() + " &asent to spawn"));
						}else{
							p.sendMessage(Reference.DENY_USER);
						}
					}else{
						p.sendMessage(Reference.colorize(Reference.PREFIX + "&aNo Spawn Set!"));
					}
				}else{
					if(plugin.spawn != null && plugin.getServer().getWorld(plugin.spawn.getWorld().getName()) != null){
						p.teleport(plugin.spawn);
					}else{
						p.sendMessage(Reference.colorize(Reference.PREFIX + "&aNo Spawn Set!"));
					}
				}
			}
		}else{
			p.sendMessage(Reference.colorize(Reference.PREFIX + "&aSpawn has not been set!"));
		}
	}
}

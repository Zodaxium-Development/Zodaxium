package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandspawn implements CommandExecutor{

	ZEssentials plugin;
	
	public Commandspawn(ZEssentials plugin, String cmd){
		plugin.getCommand(cmd).setExecutor(this);
		this.plugin = plugin;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(plugin.spawn != null && plugin.getServer().getWorlds().contains(plugin.spawn.getWorld())){
				if(args.length < 1){
					if(plugin.spawn != null && plugin.getServer().getWorld(plugin.spawn.getWorld().getName()) != null){
						p.teleport(plugin.spawn);
						p.sendMessage(plugin.colorize(Reference.PREFIX + "&aYou were teleported to spawn"));
					}else{
						p.sendMessage(plugin.colorize(Reference.PREFIX + "&aNo Spawn Set!"));
					}
				}else{
					if(p.hasPermission(Reference.PERM_ADMIN)){
						Player t = plugin.getServer().getPlayer(args[0]);
						if(plugin.spawn != null && plugin.getServer().getWorld(plugin.spawn.getWorld().getName()) != null){
							if(t != null){
								t.teleport(plugin.spawn);
								t.sendMessage(plugin.colorize(Reference.PREFIX + "&aYou were teleported to spawn"));
								p.sendMessage(plugin.colorize(Reference.PREFIX + "&aPlayer: &9" + t.getName() + " &asent to spawn"));
							}else{
								p.sendMessage(plugin.colorize(Reference.PREFIX + "&aPlayer Not Online"));
							}
						}else{
							p.sendMessage(plugin.colorize(Reference.PREFIX + "&aNo Spawn Set!"));
						}
					}else{
						if(plugin.spawn != null && plugin.getServer().getWorld(plugin.spawn.getWorld().getName()) != null){
							p.teleport(plugin.spawn);
						}else{
							p.sendMessage(plugin.colorize(Reference.PREFIX + "&aNo Spawn Set!"));
						}
					}
				}
			}else{
				p.sendMessage(plugin.colorize(Reference.PREFIX + "&aSpawn has not been set!"));
			}
		}
		return true;
	}
}

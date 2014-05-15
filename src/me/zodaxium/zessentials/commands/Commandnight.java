package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandnight implements CommandExecutor{

	ZEssentials plugin;
	
	public Commandnight(ZEssentials plugin, String cmd){
		plugin.getCommand(cmd).setExecutor(this);
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission(Reference.PERM_ADMIN)){
				if(args.length < 1){
					p.getWorld().setTime(15000L);
					p.sendMessage(plugin.colorize(Reference.PREFIX + "&aWorld: &9" + p.getWorld().getName() + " &atime set to night"));
				}else{
					World world = plugin.getServer().getWorld(args[0]);
					if(world != null){
						world.setTime(15000L);
						p.sendMessage(plugin.colorize(Reference.PREFIX + "&aWorld: &9" + world.getName() + " &atime set to night"));
					}else{
						p.sendMessage(plugin.colorize(Reference.PREFIX + "&aWorld: &9" + args[0] + " &anot found"));
					}
				}
			}else{
				p.sendMessage(plugin.colorize(Reference.PREFIX + "&aPermission Denied"));
			}
		}
		return true;
	}
}

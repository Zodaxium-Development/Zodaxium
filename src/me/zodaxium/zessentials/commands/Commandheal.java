package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandheal implements CommandExecutor{

	ZEssentials plugin;
	
	public Commandheal(ZEssentials plugin, String cmd){
		plugin.getCommand(cmd).setExecutor(this);
		this.plugin = plugin;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission(Reference.PERM_ADMIN)){
				if(args.length == 0){
					p.setHealth(p.getMaxHealth());
					p.setFoodLevel(25);
					p.setFallDistance(0);
					p.setFireTicks(0);
					p.sendMessage(plugin.colorize(Reference.PREFIX + "&aYou have been healed"));
				}else if(!(args.length < 1)){
					Player t = plugin.getServer().getPlayer(args[0]);
					if(p.hasPermission(Reference.PERM_ADMIN)){
						if(t != null){
							t.setHealth(p.getMaxHealth());
							t.setFoodLevel(25);
							t.setFallDistance(0);
							t.setFireTicks(0);
							t.sendMessage(plugin.colorize(Reference.PREFIX + "&aYou have been healed"));
							p.sendMessage(plugin.colorize(Reference.PREFIX + "&aYou have healed: &9" + t.getName()));
						}else{
							p.sendMessage(plugin.colorize(Reference.PREFIX + "&aPlayer Not Online"));
						}
					}else{
						p.sendMessage(plugin.colorize(Reference.PREFIX + "&aPermisssion Denied"));
					}
				}else{
					p.sendMessage(plugin.colorize(Reference.PREFIX + "&aUsage: /Heal (Player)"));
				}
			}else{
				p.sendMessage(plugin.colorize(Reference.PREFIX + "&aPermisssion Denied"));
			}
		}
		return true;
	}
}

package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandclear implements CommandExecutor{

ZEssentials plugin;
	
	public Commandclear(ZEssentials plugin, String cmd){
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
					p.getInventory().clear();
					p.getInventory().setArmorContents(null);
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aInventory cleared"));
				}else{
					Player t = plugin.getServer().getPlayer(args[0]);
					if(p.hasPermission(Reference.PERM_ADMIN)){
						if(t != null){
							t.getInventory().clear();
							t.getInventory().setArmorContents(null);
							t.sendMessage(Reference.colorize(Reference.PREFIX + "&aInventory cleared"));
							if(p.getName() != t.getName()){
								p.sendMessage(Reference.colorize(Reference.PREFIX + "&aPlayer: &9" + t.getName() + " &ainventory cleared"));
							}
						}else{
							p.sendMessage(Reference.DENY_USER);
						}
					}else{
						p.sendMessage(Reference.DENY_PERM);
					}
				}
			}else{
				p.sendMessage(Reference.DENY_PERM);
			}
		}else{
			sender.sendMessage(Reference.DENY_CONSOLE);
		}
		return true;
	}
}

package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandlore implements CommandExecutor{

	ZEssentials plugin;
	
	public Commandlore(ZEssentials plugin, String cmd){
		plugin.getCommand(cmd).setExecutor(this);
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission(Reference.PERM_ADMIN)){
				if(!(args.length < 1)){
					Reference.nameItem(p.getItemInHand(), StringUtils.join(args, " "), "LORE");
				}else{
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aUsage: /Lore (Lore)"));
				}
			}else{
				p.sendMessage(Reference.DENY_PERM);
			}
		}
		return true;
	}
}

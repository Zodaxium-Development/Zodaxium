package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BaseCommand implements CommandExecutor{

	ZEssentials plugin;
	
	public BaseCommand(ZEssentials plugin, String[] cmds){
		for(String cmd : cmds){
			plugin.getCommand(cmd).setExecutor(this);
		}
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player) sender;
			AbstractCommand cmd = null;
			switch(label.toLowerCase()){
				case "ci":
					cmd = new Commandclear(plugin);
					break;
				case "day":
					cmd = new Commandday(plugin);
					break;
				case "gm":
					cmd = new Commandgamemode(plugin);
					break;
				case "head":
					cmd = new Commandhead(plugin);
					break;
				case "lore":
					cmd = new Commandlore(plugin);
					break;
				case "name":
					cmd = new Commandname(plugin);
					break;
				case "night":
					cmd = new Commandnight(plugin);
					break;
				case "setspawn":
					cmd = new Commandsetspawn(plugin);
					break;
				case "spawn":
					cmd = new Commandspawn(plugin);
					break;
				case "time":
					cmd = new Commandtime(plugin);
					break;
				case "top":
					cmd = new Commandtop(plugin);
					break;
				default:
					return true;
			}
			if(cmd != null)
				cmd.execute(p, args);
		}else{
			sender.sendMessage(Reference.DENY_CONSOLE);
		}
		return true;
	}
}

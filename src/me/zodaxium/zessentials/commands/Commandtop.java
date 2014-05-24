package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandtop implements CommandExecutor{

	ZEssentials plugin;
	
	public Commandtop(ZEssentials plugin, String cmd){
		plugin.getCommand(cmd).setExecutor(this);
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission(Reference.PERM_ADMIN)){
				Block block = p.getWorld().getHighestBlockAt(p.getLocation());
				if(block != null){
					p.teleport(new Location(p.getWorld(), block.getLocation().getX(), block.getLocation().getY() + 2, block.getLocation().getZ(), p.getLocation().getYaw(), p.getLocation().getPitch()));
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aTeleporting to: (" + block.getX() + "," + (block.getY() + 2) + "," + block.getZ()));
				}else{
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aError getting highest block"));
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

package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Commandtop extends AbstractCommand{

	ZEssentials plugin;
	
	public Commandtop(ZEssentials plugin){
		this.plugin = plugin;
	}

	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(Reference.PERM_ADMIN)){
			Block block = p.getWorld().getHighestBlockAt(p.getLocation());
			if(block != null){
				p.teleport(new Location(p.getWorld(), block.getLocation().getX() + .5, block.getLocation().getY() + 1, block.getLocation().getZ() + .5, p.getLocation().getYaw(), p.getLocation().getPitch()));
				p.sendMessage(Reference.colorize(Reference.PREFIX + "&aTeleporting to: (" + block.getX() + "," + (block.getY() + 2) + "," + block.getZ()));
			}else{
				p.sendMessage(Reference.colorize(Reference.PREFIX + "&aError getting highest block"));
			}
		}else{
			p.sendMessage(Reference.DENY_PERM);
		}
	}
}

package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Reference;
import me.zodaxium.essentials.Zodaxium;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Commandtop extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandtop(Zodaxium plugin){
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

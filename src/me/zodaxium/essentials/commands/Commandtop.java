package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;

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
		if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
			Block block = p.getWorld().getHighestBlockAt(p.getLocation());
			if(block != null){
				p.teleport(new Location(p.getWorld(), block.getLocation().getX() + .5, block.getLocation().getY() + 1, block.getLocation().getZ() + .5, p.getLocation().getYaw(), p.getLocation().getPitch()));
				ZodaxApi.sendMessage(p, "&aTeleporting to: (" + block.getX() + "," + (block.getY() + 2) + "," + block.getZ());
			}else{
				ZodaxApi.sendMessage(p, "&aError getting highest block");
			}
		}else{
			p.sendMessage(ZodaxApi.DENY_PERM);
		}
	}
}

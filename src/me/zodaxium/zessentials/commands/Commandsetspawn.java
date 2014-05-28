package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Commandsetspawn extends AbstractCommand{

	ZEssentials plugin;
	
	public Commandsetspawn(ZEssentials plugin){
		this.plugin = plugin;
	}

	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(Reference.PERM_ADMIN)){
			Location loc = p.getLocation();
			World world = loc.getWorld();
			plugin.spawn = new Location(world, loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
			String location = world.getName() + ":" + loc.getX() + ":" + loc.getY() + ":" + loc.getZ() + ":" + loc.getYaw() + ":" + loc.getPitch();
			plugin.getConfig().set("Spawn", location);
			plugin.saveConfig();
			p.sendMessage(Reference.colorize(Reference.PREFIX + "&aSpawn has been set!"));
		}else{
			p.sendMessage("Unknown command. Type \"/help\" for help.");
		}
	}
}

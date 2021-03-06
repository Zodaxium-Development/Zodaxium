package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Commandsetspawn extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandsetspawn(Zodaxium plugin){
		this.plugin = plugin;
	}

	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
			Location loc = p.getLocation();
			World world = loc.getWorld();
			plugin.spawn = new Location(world, loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
			String location = world.getName() + ":" + loc.getX() + ":" + loc.getY() + ":" + loc.getZ() + ":" + loc.getYaw() + ":" + loc.getPitch();
			plugin.getConfig().set("Spawn", location);
			plugin.saveConfig();
			ZodaxApi.sendMessage(p, "&aSpawn has been set!");
		}else{
			p.sendMessage("Unknown command. Type \"/help\" for help.");
		}
	}
}

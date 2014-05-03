package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandsetspawn implements CommandExecutor {

	ZEssentials plugin;
	
	public Commandsetspawn(ZEssentials plugin, String cmd){
		plugin.getCommand(cmd).setExecutor(this);
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission("zessentials.setspawn")){
				Location loc = p.getLocation();
				World world = loc.getWorld();
				plugin.spawn = new Location(world, loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
				String location = world.getName() + ":" + loc.getX() + ":" + loc.getY() + ":" + loc.getZ() + ":" + loc.getYaw() + ":" + loc.getPitch();
				plugin.getConfig().set("Spawn", location);
				plugin.saveConfig();
				p.sendMessage(plugin.colorize(Reference.PREFIX + "&aSpawn has been set!"));
			}else{
				p.sendMessage("Unknown command. Type \"/help\" for help.");
			}
		}
		return true;
	}
}
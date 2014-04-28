package me.zodaxium.zessentials;

import me.zodaxium.zessentials.commands.Commandclear;
import me.zodaxium.zessentials.commands.Commandday;
import me.zodaxium.zessentials.commands.Commandgamemode;
import me.zodaxium.zessentials.commands.Commandnight;
import me.zodaxium.zessentials.commands.Commandsetspawn;
import me.zodaxium.zessentials.commands.Commandspawn;
import me.zodaxium.zessentials.commands.Commandtime;
import me.zodaxium.zessentials.listeners.Listenercommand;
import me.zodaxium.zessentials.listeners.Listenerjoin;
import me.zodaxium.zessentials.listeners.Listenermove;
import me.zodaxium.zessentials.listeners.Listenerquit;
import me.zodaxium.zessentials.listeners.Listenerrespawn;
import me.zodaxium.zessentials.listeners.Listenersign;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class ZEssentials extends JavaPlugin{
	
	public Location spawn = null;
	
	public void onEnable(){
		saveDefaultConfig();
		
		generateVariables();
		registerClasses();
	}
	
	private void registerClasses(){
		new Commandclear(this, "ci");
		new Commandday(this, "day");
		new Commandgamemode(this, "gm");
		new Commandnight(this, "night");
		new Commandspawn(this, "spawn");
		new Commandsetspawn(this, "setspawn");
		new Commandtime(this, "time");
		
		new Listenercommand(this);
		new Listenerjoin(this);
		new Listenermove(this);
		new Listenerquit(this);
		new Listenerrespawn(this);
		new Listenersign(this);
	}
	
	private void generateVariables(){
		String[] loc = getConfig().getString("Spawn").split(":");
		spawn = ((getServer().getWorld(loc[0]) != null) ? new Location(getServer().getWorld(loc[0]), Double.parseDouble(loc[1]), Double.parseDouble(loc[2]), Double.parseDouble(loc[3]), Float.parseFloat(loc[4]), Float.parseFloat(loc[5])) : null);
	}
	
	public String colorize(String message){
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}
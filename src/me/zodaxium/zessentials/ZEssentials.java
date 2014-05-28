package me.zodaxium.zessentials;

import java.util.logging.Level;

import me.zodaxium.zessentials.commands.BaseCommand;
import me.zodaxium.zessentials.listeners.Listenercommand;
import me.zodaxium.zessentials.listeners.Listenerjoin;
import me.zodaxium.zessentials.listeners.Listenermove;
import me.zodaxium.zessentials.listeners.Listenerquit;
import me.zodaxium.zessentials.listeners.Listenerrespawn;
import me.zodaxium.zessentials.listeners.Listenersign;
import me.zodaxium.zessentials.timers.TimerWorldSave;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public class ZEssentials extends JavaPlugin{
	
	public Location spawn = null;
	public int saveTimer = 0;
	public boolean plib = true;
	String[] cmds = {"ci", "day", "gm", "head", "heal", "lore", "name", "night", "spawn", "setspawn", "time", "top"};
	
	public void onEnable(){
		if(!getServer().getPluginManager().isPluginEnabled("ProtocolLib")){
			plib = false;
			getLogger().log(Level.SEVERE, "Could not load ProtocolLib!");
		}
		
		saveDefaultConfig();
		
		new BaseCommand(this, cmds);
		
		generateVariables();
		registerClasses();
		
		getServer().getScheduler().scheduleSyncRepeatingTask(this, new TimerWorldSave(this), 0, saveTimer);
	}
	
	private void registerClasses(){
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
		saveTimer = (getConfig().getInt("SaveTimer") * 1200);
	}
}
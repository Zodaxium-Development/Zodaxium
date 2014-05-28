package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class Commandtime extends AbstractCommand{

	ZEssentials plugin;
	
	public Commandtime(ZEssentials plugin){
		this.plugin = plugin;
	}

	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(Reference.PERM_ADMIN)){
			if(args.length < 1){
				p.sendMessage(Reference.colorize(Reference.PREFIX + "&aWorld: &9" + p.getWorld().getName() + "&a, Time: &9" + parseTime(p.getWorld().getTime())));
			}else{
				World world = plugin.getServer().getWorld(args[0]);
				if(world != null){
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aWorld: &9" + world.getName() + "&a, Time: &9" + parseTime(world.getTime())));
				}else{
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aWorld: &9" + args[0] + " &anot found"));
				}
			}
		}else{
			p.sendMessage(Reference.DENY_PERM);
		}
	}
	
	private String parseTime(long time){
		long hours = time / 1000 + 6;
		long minutes = (time % 1000) * 60 / 1000;
		String ampm = "AM";
		if(hours >= 12){
			hours -= 12; ampm = "PM";
		}
	 
		if (hours >= 12){
			hours -= 12; ampm = "AM";
		}
	 
		if (hours == 0) hours = 12;
	 
		String mm = "0" + minutes;
		mm = mm.substring(mm.length() - 2, mm.length());
	 
		return hours + ":" + mm + " " + ampm;
	}
}

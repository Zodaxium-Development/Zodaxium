package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Reference;
import me.zodaxium.essentials.Zodaxium;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class Commandday extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandday(Zodaxium plugin){
		this.plugin = plugin;
	}

	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(Reference.PERM_ADMIN)){
			if(args.length < 1){
				p.getWorld().setTime(3000L);
				p.sendMessage(Reference.colorize(Reference.PREFIX + "&aWorld: &9" + p.getWorld().getName() + " &atime set to day"));
			}else{
				World world = plugin.getServer().getWorld(args[0]);
				if(world != null){
					world.setTime(3000L);
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aWorld: &9" + world.getName() + " &atime set to day"));
				}else{
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aWorld: &9" + args[0] + " &anot found"));
				}
			}
		}else{
			p.sendMessage(Reference.DENY_PERM);
		}
	}
}

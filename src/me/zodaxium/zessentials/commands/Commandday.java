package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class Commandday extends AbstractCommand{

	ZEssentials plugin;
	
	public Commandday(ZEssentials plugin){
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

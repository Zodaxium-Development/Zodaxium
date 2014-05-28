package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class Commandday extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandday(Zodaxium plugin){
		this.plugin = plugin;
	}

	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
			if(args.length < 1){
				p.getWorld().setTime(3000L);
				ZodaxApi.sendMessage(p, "&aWorld: &9" + p.getWorld().getName() + " &atime set to day");
			}else{
				World world = plugin.getServer().getWorld(args[0]);
				if(world != null){
					world.setTime(3000L);
					ZodaxApi.sendMessage(p, "&aWorld: &9" + p.getWorld().getName() + " &atime set to day");
				}else{
					ZodaxApi.sendMessage(p, "&aWorld: &9" + args[0] + " &anot found");
				}
			}
		}else{
			p.sendMessage(ZodaxApi.DENY_PERM);
		}
	}
}

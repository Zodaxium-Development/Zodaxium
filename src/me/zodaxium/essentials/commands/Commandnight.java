package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class Commandnight extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandnight(Zodaxium plugin){
		this.plugin = plugin;
	}

	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
			if(args.length < 1){
				p.getWorld().setTime(15000L);
				ZodaxApi.sendMessage(p, "&aWorld: &9" + p.getWorld().getName() + " &atime set to night");
			}else{
				World world = plugin.getServer().getWorld(args[0]);
				if(world != null){
					world.setTime(15000L);
					ZodaxApi.sendMessage(p, "&aWorld: &9" + world.getName() + " &atime set to night");
				}else{
					ZodaxApi.sendMessage(p, "&aWorld: &9" + args[0] + " &anot found");
				}
			}
		}else{
			p.sendMessage(ZodaxApi.DENY_PERM);
		}
	}
}

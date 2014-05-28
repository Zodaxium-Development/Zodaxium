package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;

import org.bukkit.entity.Player;

public class Commandclear extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandclear(Zodaxium plugin){
		this.plugin = plugin;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void execute(Player p, String[] args) {
		if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
			if(args.length == 0){
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				ZodaxApi.sendMessage(p, "&aInventory cleared");
			}else{
				Player t = plugin.getServer().getPlayer(args[0]);
				if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
					if(t != null){
						t.getInventory().clear();
						t.getInventory().setArmorContents(null);
						ZodaxApi.sendMessage(t, "&aInventory cleared");
						if(p.getName() != t.getName()){
							ZodaxApi.sendMessage(p, "&aPlayer: &9" + t.getName() + " &ainventory cleared");
						}
					}else{
						p.sendMessage(ZodaxApi.DENY_USER);
					}
				}else{
					p.sendMessage(ZodaxApi.DENY_PERM);
				}
			}
		}else{
			p.sendMessage(ZodaxApi.DENY_PERM);
		}
	}
}

package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Reference;
import me.zodaxium.essentials.Zodaxium;

import org.bukkit.entity.Player;

public class Commandclear extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandclear(Zodaxium plugin){
		this.plugin = plugin;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void execute(Player p, String[] args) {
		if(p.hasPermission(Reference.PERM_ADMIN)){
			if(args.length == 0){
				p.getInventory().clear();
				p.getInventory().setArmorContents(null);
				p.sendMessage(Reference.colorize(Reference.PREFIX + "&aInventory cleared"));
			}else{
				Player t = plugin.getServer().getPlayer(args[0]);
				if(p.hasPermission(Reference.PERM_ADMIN)){
					if(t != null){
						t.getInventory().clear();
						t.getInventory().setArmorContents(null);
						t.sendMessage(Reference.colorize(Reference.PREFIX + "&aInventory cleared"));
						if(p.getName() != t.getName()){
							p.sendMessage(Reference.colorize(Reference.PREFIX + "&aPlayer: &9" + t.getName() + " &ainventory cleared"));
						}
					}else{
						p.sendMessage(Reference.DENY_USER);
					}
				}else{
					p.sendMessage(Reference.DENY_PERM);
				}
			}
		}else{
			p.sendMessage(Reference.DENY_PERM);
		}
	}
}

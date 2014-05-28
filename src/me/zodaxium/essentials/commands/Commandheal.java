package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Reference;
import me.zodaxium.essentials.Zodaxium;

import org.bukkit.entity.Player;

public class Commandheal extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandheal(Zodaxium plugin){
		this.plugin = plugin;
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void execute(Player p, String[] args){
		if(p.hasPermission(Reference.PERM_ADMIN)){
			if(args.length == 0){
				p.setHealth(p.getMaxHealth());
				p.setFoodLevel(25);
				p.setFallDistance(0);
				p.setFireTicks(0);
				p.sendMessage(Reference.colorize(Reference.PREFIX + "&aYou have been healed"));
			}else if(!(args.length < 1)){
				Player t = plugin.getServer().getPlayer(args[0]);
				if(p.hasPermission(Reference.PERM_ADMIN)){
					if(t != null){
						t.setHealth(p.getMaxHealth());
						t.setFoodLevel(25);
						t.setFallDistance(0);
						t.setFireTicks(0);
						t.sendMessage(Reference.colorize(Reference.PREFIX + "&aYou have been healed"));
						p.sendMessage(Reference.colorize(Reference.PREFIX + "&aYou have healed: &9" + t.getName()));
					}else{
						p.sendMessage(Reference.DENY_USER);
					}
				}else{
					p.sendMessage(Reference.DENY_PERM);
				}
			}else{
				p.sendMessage(Reference.colorize(Reference.PREFIX + "&aUsage: /Heal (Player)"));
			}
		}else{
			p.sendMessage(Reference.DENY_PERM);
		}
	}
}

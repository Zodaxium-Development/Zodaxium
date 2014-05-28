package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Reference;
import me.zodaxium.essentials.Zodaxium;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

public class Commandlore extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandlore(Zodaxium plugin){
		this.plugin = plugin;
	}
	
	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(Reference.PERM_ADMIN)){
			if(!(args.length < 1)){
				Reference.nameItem(p.getItemInHand(), StringUtils.join(args, " "), "LORE");
			}else{
				p.sendMessage(Reference.colorize(Reference.PREFIX + "&aUsage: /Lore (Lore)"));
			}
		}else{
			p.sendMessage(Reference.DENY_PERM);
		}
	}
}

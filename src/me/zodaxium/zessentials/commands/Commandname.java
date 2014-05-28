package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

public class Commandname extends AbstractCommand{

	ZEssentials plugin;
	
	public Commandname(ZEssentials plugin){
		this.plugin = plugin;
	}

	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(Reference.PERM_ADMIN)){
			if(!(args.length < 1)){
				Reference.nameItem(p.getItemInHand(), StringUtils.join(args, " "), "NAME");
			}else{
				p.sendMessage(Reference.colorize(Reference.PREFIX + "&aUsage: /Name (Name)"));
			}
		}else{
			p.sendMessage(Reference.DENY_PERM);
		}
	}
}

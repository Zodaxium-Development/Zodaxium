package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;
import me.zodaxium.zapi.api.ItemApi;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

public class Commandname extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandname(Zodaxium plugin){
		this.plugin = plugin;
	}

	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
			if(!(args.length < 1)){
				ItemApi.lore(p.getItemInHand(), StringUtils.join(args, " "));
			}else{
				ZodaxApi.sendMessage(p, "&aUsage: /Name (Name)");
			}
		}else{
			p.sendMessage(ZodaxApi.DENY_PERM);
		}
	}
}

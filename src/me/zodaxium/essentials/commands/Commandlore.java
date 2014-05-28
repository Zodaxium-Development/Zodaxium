package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;
import me.zodaxium.zapi.api.ItemApi;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

public class Commandlore extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandlore(Zodaxium plugin){
		this.plugin = plugin;
	}
	
	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
			if(!(args.length < 1)){
				ItemApi.name(p.getItemInHand(), StringUtils.join(args, " "));
			}else{
				ZodaxApi.sendMessage(p, "&aUsage: /Lore (Lore)");
			}
		}else{
			p.sendMessage(ZodaxApi.DENY_PERM);
		}
	}
}

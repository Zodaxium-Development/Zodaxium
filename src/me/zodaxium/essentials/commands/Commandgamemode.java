package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Commandgamemode extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandgamemode(Zodaxium plugin){
		this.plugin = plugin;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void execute(Player p, String[] args){
		if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
			if(args.length == 1){
				switch(args[0]){
					case "0":
						p.setGameMode(GameMode.SURVIVAL);
						ZodaxApi.sendMessage(p, "&aGameMode: &9&osurvival");
						break;
					case "1":
						p.setGameMode(GameMode.CREATIVE);
						ZodaxApi.sendMessage(p, "&aGameMode: &9&ocreative");
						break;
					case "2":
						p.setGameMode(GameMode.ADVENTURE);
						ZodaxApi.sendMessage(p, "&aGameMode: &9&oadventure");
						break;
					default:
						ZodaxApi.sendMessage(p, "&aUsage: /Gm (Mode)");
				}
			}else if(!(args.length < 2)){
				Player t = plugin.getServer().getPlayer(args[1]);
				if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
					if(t != null){
						switch(args[0]){
							case "0":
								t.setGameMode(GameMode.SURVIVAL);
								ZodaxApi.sendMessage(t, "&aGameMode: &9&oadventure");
								ZodaxApi.sendMessage(p, "&a" + t.getName() + " GameMode: &9&osurvival");
								break;
							case "1":
								t.setGameMode(GameMode.CREATIVE);
								ZodaxApi.sendMessage(t, "&aGameMode: &9&oadventure");
								ZodaxApi.sendMessage(p, "&a" + t.getName() + " GameMode: &9&ocreative");
								break;
							case "2":
								t.setGameMode(GameMode.ADVENTURE);
								ZodaxApi.sendMessage(t, "&aGameMode: &9&oadventure");
								ZodaxApi.sendMessage(p, "&a" + t.getName() + " GameMode: &9&oadventure");
								break;
							default:
								ZodaxApi.sendMessage(p, "&aUsage: /Gm (Mode) (Player)");
						}
					}else{
						p.sendMessage(ZodaxApi.DENY_USER);
					}
				}else{
					p.sendMessage(ZodaxApi.DENY_PERM);
				}
			}else{
				ZodaxApi.sendMessage(p, "&aUsage: /Gm (Mode) (Player)");
			}
		}else{
			p.sendMessage(ZodaxApi.DENY_PERM);
		}
	}
}

package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Commandgamemode extends AbstractCommand{

	ZEssentials plugin;
	
	public Commandgamemode(ZEssentials plugin){
		this.plugin = plugin;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void execute(Player p, String[] args){
		if(p.hasPermission(Reference.PERM_ADMIN)){
			if(args.length == 1){
				switch(args[0]){
					case "0":
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(Reference.colorize(Reference.PREFIX + "&aGameMode: &9&osurvival"));
						break;
					case "1":
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Reference.colorize(Reference.PREFIX + "&aGameMode: &9&ocreative"));
						break;
					case "2":
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage(Reference.colorize(Reference.PREFIX + "&aGameMode: &9&oadventure"));
						break;
					default:
						p.sendMessage(Reference.colorize(Reference.PREFIX + "&aUsage: /Gm (Mode)"));
				}
			}else if(!(args.length < 2)){
				Player t = plugin.getServer().getPlayer(args[1]);
				if(p.hasPermission(Reference.PERM_ADMIN)){
					if(t != null){
						switch(args[0]){
							case "0":
								t.setGameMode(GameMode.SURVIVAL);
								t.sendMessage(Reference.colorize(Reference.PREFIX + "&aGameMode: &9&osurvival"));
								p.sendMessage(Reference.colorize(Reference.PREFIX + "&a" + t.getName() + " GameMode: &9&osurvival"));
								break;
							case "1":
								t.setGameMode(GameMode.CREATIVE);
								t.sendMessage(Reference.colorize(Reference.PREFIX + "&aGameMode: &9&ocreative"));
								p.sendMessage(Reference.colorize(Reference.PREFIX + "&a" + t.getName() + " GameMode: &9&ocreative"));
								break;
							case "2":
								t.setGameMode(GameMode.ADVENTURE);
								t.sendMessage(Reference.colorize(Reference.PREFIX + "&aGameMode: &9&oadventure"));
								p.sendMessage(Reference.colorize(Reference.PREFIX + "&a" + t.getName() + " GameMode: &9&oadventure"));
								break;
							default:
								p.sendMessage(Reference.colorize(Reference.PREFIX + "&aUsage: /Gm (Mode) (Player)"));
						}
					}else{
						p.sendMessage(Reference.DENY_USER);
					}
				}else{
					p.sendMessage(Reference.DENY_PERM);
				}
			}else{
				p.sendMessage(Reference.colorize(Reference.PREFIX + "&aUsage: /Gm (Mode) (Player)"));
			}
		}else{
			p.sendMessage(Reference.DENY_PERM);
		}
	}
}

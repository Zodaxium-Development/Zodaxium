package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandsign implements CommandExecutor{

	ZEssentials plugin;
	
	public Commandsign(ZEssentials plugin, String cmd){
		plugin.getCommand(cmd).setExecutor(this);
		this.plugin = plugin;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission("zessentials.sign")){
				if(!(args.length < 2)){
					if(p.getTargetBlock(null, 5).getType() == Material.SIGN_POST || p.getTargetBlock(null, 5).getType() == Material.WALL_SIGN){
						Sign sign = (Sign) p.getTargetBlock(null, 5).getState();
						if(args[0].matches("-?\\d+(\\.\\d+)?")){
							int line = Integer.parseInt(args[0]);
							String text = plugin.colorize(StringUtils.join(args, " ", 1, args.length));
							if(line <= 4 && line >= 1){
								if(text.length() <= 16){
									if(!text.equalsIgnoreCase("%empty%")){
										String newtext = text.replaceAll("%", " ");
										sign.setLine(line - 1, newtext);
										sign.update();
										p.sendMessage(plugin.colorize(Reference.PREFIX + "&aLine: &9" + line + "&a, Text: &9" + newtext));
									}else{
										sign.setLine(line - 1, "");
										sign.update();
										p.sendMessage(plugin.colorize(Reference.PREFIX + "&aLine: &9" + line + "&a, Text: &9blank"));
									}
								}else{
									p.sendMessage(plugin.colorize(Reference.PREFIX + "&aText must cannot be greater than 16"));
								}
							}else{
								p.sendMessage(plugin.colorize(Reference.PREFIX + "&aLine numbers must be between 1-4"));
							}
						}else{
							p.sendMessage(plugin.colorize(Reference.PREFIX + "&aUsage: /signedit (#) (text)"));
						}
					}else{
						p.sendMessage(plugin.colorize(Reference.PREFIX + "&aThat block is not a sign"));
					}
				}else{
					p.sendMessage(plugin.colorize(Reference.PREFIX + "&aUsage: /signedit (#) (text)"));
				}
			}else{
				p.sendMessage(plugin.colorize(Reference.PREFIX + "&aPermission Denied"));
			}
		}
		return true;
	}
}

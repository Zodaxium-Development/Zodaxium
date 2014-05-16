package me.zodaxium.zessentials.commands;

import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Commandhead implements CommandExecutor{

	ZEssentials plugin;
	
	public Commandhead(ZEssentials plugin, String cmd){
		plugin.getCommand(cmd).setExecutor(this);
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission(Reference.PERM_ADMIN)){
				if(args.length < 1){
					p.getInventory().addItem(getHead(p.getName()));
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aPlayer Head: &9" + p.getName() + " &areceived"));
				}else{
					p.getInventory().addItem(getHead(args[0]));
					p.sendMessage(Reference.colorize(Reference.PREFIX + "&aPlayer Head: &9" + args[0] + " &areceived"));
				}
			}else{
				p.sendMessage(Reference.DENY_PERM);
			}
		}
		return true;
	}
	
	private ItemStack getHead(String owner){
		ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta meta = (SkullMeta) head.getItemMeta();
		meta.setOwner(owner);
		meta.setDisplayName(Reference.colorize("&a" + owner + "'s head"));
		head.setItemMeta(meta);
		return head;
	}
}

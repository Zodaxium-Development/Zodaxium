package me.zodaxium.essentials.commands;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;
import me.zodaxium.zapi.api.ColorApi;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Commandhead extends AbstractCommand{

	Zodaxium plugin;
	
	public Commandhead(Zodaxium plugin){
		this.plugin = plugin;
	}

	@Override
	public void execute(Player p, String[] args){
		if(p.hasPermission(ZodaxApi.PERM_ADMIN)){
			if(args.length < 1){
				p.getInventory().addItem(getHead(p.getName()));
				ZodaxApi.sendMessage(p, "&aPlayer Head: &9" + p.getName() + " &areceived");
			}else{
				p.getInventory().addItem(getHead(args[0]));
				ZodaxApi.sendMessage(p, "&aPlayer Head: &9" + args[0] + " &areceived");
			}
		}else{
			p.sendMessage(ZodaxApi.DENY_PERM);
		}
	}
	
	private ItemStack getHead(String owner){
		ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
		SkullMeta meta = (SkullMeta) head.getItemMeta();
		meta.setOwner(owner);
		meta.setDisplayName(ColorApi.color("&a" + owner + "'s head"));
		head.setItemMeta(meta);
		return head;
	}
}

package me.zodaxium.zessentials.listeners;

import java.lang.reflect.InvocationTargetException;

import me.zodaxium.zessentials.PacketUtils;
import me.zodaxium.zessentials.Reference;
import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Listenersign implements Listener{

	ZEssentials plugin;
	
	public Listenersign(ZEssentials plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e){
		String[] lines = e.getLines();
		for(int i = 0; i < lines.length; i++){
			e.setLine(i, plugin.colorize(lines[i]));
		}
	}
	
	@EventHandler
	public void onPlayerSignInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(!e.hasBlock()) return;
		if(p.getItemInHand().getType() != Material.AIR) return;
		if(e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		Block block = e.getClickedBlock();
		if(block == null || !(block.getState() instanceof Sign)) return;
		Sign sign = (Sign) block.getState();
		if(p.isSneaking()) return;
		if(!p.hasPermission("zessentials.signedit")) return;
		if(PacketUtils.edited.contains(sign)){
			p.sendMessage(plugin.colorize(Reference.PREFIX + "&aSign editing in progress"));
			e.setCancelled(true);
			return;
		}
		PacketUtils.edited.add(sign);
		try{
			PacketUtils.sendSignWindow(p, sign);
		}catch(InvocationTargetException e1){
			p.sendMessage(plugin.colorize(Reference.PREFIX + "&aError when trying to edit sign"));
		}
		e.setCancelled(true);
	}
}

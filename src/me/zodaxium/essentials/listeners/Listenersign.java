package me.zodaxium.essentials.listeners;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import me.zodaxium.essentials.Zodaxium;
import me.zodaxium.zapi.ZodaxApi;
import me.zodaxium.zapi.api.ColorApi;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Listenersign implements Listener{

	Zodaxium plugin;
	List<Sign> edit = new ArrayList<Sign>();
	private static ProtocolManager pm;
	
	public Listenersign(Zodaxium plugin){
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
		if(plugin.plib){
			pm = ProtocolLibrary.getProtocolManager();
			registerPacketReceiver();
		}
	}
	
	@EventHandler
	public void onSignChange(SignChangeEvent e){
		String[] lines = e.getLines();
		for(int i = 0; i < lines.length; i++){
			e.setLine(i, ColorApi.color(lines[i]));
		}
	}
	
	@EventHandler
	public void onPlayerSignInteract(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(!plugin.plib) return;
		if(!e.hasBlock()) return;
		if(p.getItemInHand().getType() != Material.AIR) return;
		if(e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		if(e.getClickedBlock() == null) return;
		if(!(e.getClickedBlock().getState() instanceof Sign)) return;
		Sign sign = (Sign) e.getClickedBlock().getState();
		if(!p.isSneaking()) return;
		if(!p.hasPermission(ZodaxApi.PERM_ADMIN)) return;
		if(edit.contains(sign)){
			ZodaxApi.sendMessage(p, "&aSign editing in progress");
			e.setCancelled(true);
			return;
		}
		edit.add(sign);
		try{
			sendSignWindow(p, sign);
		}catch(InvocationTargetException e1){
			ZodaxApi.sendMessage(p, "&aError when trying to edit sign");
		}
		e.setCancelled(true);
	}
	
	public void sendSignWindow(Player p, Sign sign) throws InvocationTargetException{
		PacketContainer packet = pm.createPacket(PacketType.Play.Server.OPEN_SIGN_ENTITY);
		packet.getIntegers().write(0, Integer.valueOf(sign.getX())).write(1, Integer.valueOf(sign.getY())).write(2, Integer.valueOf(sign.getZ()));
		pm.sendServerPacket(p, packet);
	}
	
	public void registerPacketReceiver(){
		pm.addPacketListener(new PacketAdapter(plugin, new PacketType[] { PacketType.Play.Client.UPDATE_SIGN }){
			public void onPacketReceiving(PacketEvent e){
				PacketContainer packet = e.getPacket();
				String[] lines = (String[]) packet.getStringArrays().read(0);
				Integer x = (Integer) packet.getIntegers().read(0);
				Integer y = (Integer) packet.getIntegers().read(1);
				Integer z = (Integer) packet.getIntegers().read(2);
				if(x == null || y == null || z == null) return;
				Sign sign = (Sign) new Location(e.getPlayer().getWorld(), x.intValue(), y.intValue(), z.intValue()).getBlock().getState();
				if(!edit.contains(sign)) return;
				edit.remove(sign);
				for(int i = 0; i < 4; i++){
					sign.setLine(i, lines[i]);
				}
				ZodaxApi.sendMessage(e.getPlayer(), "&aSign Updated!");
				updateSign(sign);
			}
		});
	}
	
	private void updateSign(Sign sign){
		String[] lines = sign.getLines();
		for(int i = 0; i < 4; i++){
			 sign.setLine(i, ColorApi.color(lines[i]));
		}
		sign.update();
	}
}

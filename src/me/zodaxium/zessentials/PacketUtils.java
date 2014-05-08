package me.zodaxium.zessentials;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import me.zodaxium.zessentials.ZEssentials;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class PacketUtils{

	private static ProtocolManager pm = ProtocolLibrary.getProtocolManager();
	public static List<Sign> edited = new ArrayList<Sign>();
	
	public static void sendSignWindow(Player p, Sign sign) throws InvocationTargetException{
		PacketContainer packet = pm.createPacket(PacketType.Play.Server.OPEN_SIGN_ENTITY);
		packet.getIntegers().write(0, Integer.valueOf(sign.getX())).write(1, Integer.valueOf(sign.getY())).write(2, Integer.valueOf(sign.getZ()));
		pm.sendServerPacket(p, packet);
	}
	
	public static void registerPacketReceiver(ZEssentials plugin){
		pm.addPacketListener(new PacketAdapter(plugin, new PacketType[] { PacketType.Play.Client.UPDATE_SIGN }){
			public void onPacketReceiving(PacketEvent e){
				PacketContainer packet = e.getPacket();
				String[] lines = (String[]) packet.getStringArrays().read(0);
				Integer x = (Integer) packet.getIntegers().read(0);
				Integer y = (Integer) packet.getIntegers().read(1);
				Integer z = (Integer) packet.getIntegers().read(2);
				if(x == null || y == null || z == null) return;
				Sign sign = (Sign) new Location(e.getPlayer().getWorld(), x.intValue(), y.intValue(), z.intValue()).getBlock().getState();
				if(!edited.contains(sign)) return;
				edited.remove(sign);
				for(int i = 0; i < 4; i++){
					sign.setLine(i, lines[i]);
				}
				e.getPlayer().sendMessage(colorize(Reference.PREFIX + "&aSign Updated!"));
				updateSign(sign);
			}
		});
	}
	
	private static void updateSign(Sign sign){
		String[] lines = sign.getLines();
		for(int i = 0; i < 4; i++){
			 sign.setLine(i, colorize(lines[i]));
		}
		sign.update();
	}
	
	public static String colorize(String message){
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}

package me.zodaxium.zessentials;

import org.bukkit.ChatColor;

public class Reference{
	public static String PREFIX = colorize("&9[&6Zodaxium&9] ");
	public static String PERM_ADMIN = colorize("zodaxium.admin");
	public static String PERM_DONATE = colorize("zodaxium.donator");
	public static String PERM_USER = colorize("zodaxium.user");
	public static String DENY_PERM = colorize(PREFIX + "&aPermission Denied");
	public static String DENY_USER = colorize(PREFIX + "&aPlayer is not online");
	
	public static String colorize(String message){
		return ChatColor.translateAlternateColorCodes('&', message);
	}
}

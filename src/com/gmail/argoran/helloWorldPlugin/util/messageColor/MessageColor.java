package com.gmail.argoran.helloWorldPlugin.util.messageColor;

import org.bukkit.ChatColor;

public class MessageColor {
	public static String colorPlayerName(String _name) {
		return ChatColor.BLUE.toString().concat(_name).concat(ChatColor.WHITE.toString());
	}
	
	public static String colorDamage(int _damage) {
		return ChatColor.RED.toString().concat(String.valueOf(_damage)).concat(ChatColor.WHITE.toString());
	}
}

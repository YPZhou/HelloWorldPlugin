package com.gmail.argoran.helloWorldPlugin.palutaPortal;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.argoran.helloWorldPlugin.HelloWorldPlugin;
import com.gmail.argoran.helloWorldPlugin.util.messageColor.MessageColor;

public class PalutaPortal implements Listener, CommandExecutor {

	private HelloWorldPlugin plugin_;
	
	public PalutaPortal(HelloWorldPlugin _plugin) {
		this.plugin_ = _plugin;
	}
	
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent _event) {
		Location locFrom = _event.getFrom();
		Location locTo = _event.getTo();
		int xFrom = locFrom.getBlockX();
		int zFrom = locFrom.getBlockZ();
		int xTo = locTo.getBlockX();
		int yTo = locTo.getBlockY();
		int zTo = locTo.getBlockZ();
		
		if ((xFrom != 154 || zFrom != 273) && xTo == 154 && zTo == 273 && yTo >= 150) {
			Player player = _event.getPlayer();
			Inventory inventory = player.getInventory();
			ItemStack[] content = inventory.getContents();
			if (content[8] != null && content[8].getType() == Material.DIRT) {
				player.teleport(new Location(player.getWorld(), 96.5, 56.0, 262.0));
				this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " has travelled to " + MessageColor.colorLocation("mine") + " through portal .");
			} else {
				this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " does not have the correct key .");
			}
		}
		
		if ((xFrom != 96 || zFrom != 262) && xTo == 96 && zTo == 262 && yTo >= 56 && yTo <= 59) {
			Player player = _event.getPlayer();
			Inventory inventory = player.getInventory();
			ItemStack[] content = inventory.getContents();
			if (content[8] != null && content[8].getType() == Material.COBBLESTONE) {
				player.teleport(new Location(player.getWorld(), 154.0, 150.0, 273.0));
				this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " has travelled to " + MessageColor.colorLocation("Paluta") + " through portal .");
			} else {
				this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " does not have the correct key .");
			}
		}
	}
	
	@Override
	public boolean onCommand(CommandSender _sender, Command _cmd, String _label, String[] _args) {
		if (_cmd.getName().equalsIgnoreCase("hw_teleport_mine")) {
			if (_args.length > 0) return false;
			if (_sender instanceof Player) {
				Player player = (Player) _sender;
				Location loc = player.getLocation();
				double x = loc.getX();
				double y = loc.getY();
				double z = loc.getZ();
				if (x > 152.3 && x < 156.7 && z > 271.3 && z < 275.7 && y >= 150) {
					player.teleport(new Location(player.getWorld(), 96.5, 56.0, 262.0));
					this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " has travelled to " + MessageColor.colorLocation("mine") + " through portal .");
				} else {
					this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " shouted some words and performed some gestures, but nothing happened .");
				}
				return true;
			}
		} else if (_cmd.getName().equalsIgnoreCase("hw_teleport_paluta")) {
			if (_args.length > 0) return false;
			if (_sender instanceof Player) {
				Player player = (Player) _sender;
				Location loc = player.getLocation();
				double x = loc.getX();
				double y = loc.getY();
				double z = loc.getZ();
				if (x > 95.3 && x < 98.7 && z > 260.3 && z < 264.7 && y >= 56 && y <= 59) {
					player.teleport(new Location(player.getWorld(), 154.0, 150.0, 273.0));
					this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " has travelled to " + MessageColor.colorLocation("Paluta") + " through portal .");
				} else {
					this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " shouted some words and performed some gestures, but nothing happened .");
				}
				return true;
			}
		}
		return false;
	}

}

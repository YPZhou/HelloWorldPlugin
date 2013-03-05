package com.gmail.argoran.helloWorldPlugin.replaceBrokenTool;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.argoran.helloWorldPlugin.HelloWorldPlugin;

public class ReplaceBrokenTool implements Listener {
	
	HelloWorldPlugin plugin_;
	
	public ReplaceBrokenTool(HelloWorldPlugin _plugin) {
		this.plugin_ = _plugin;
	}
	
	@EventHandler
	public void onPlayerInteractEvent(PlayerInteractEvent _event) {
		Player player = _event.getPlayer();
		Action action = _event.getAction();
		if (action == Action.LEFT_CLICK_BLOCK) {
			ItemStack item = _event.getItem();
			if (item == null) {
				
			}
		}
	}
	
	@EventHandler
	public void onItemBrokenEvent(PlayerItemBreakEvent _event) {
//		Player player = _event.getPlayer();
//		ItemStack item = _event.getBrokenItem();
//		player.sendMessage((item.hasItemMeta() ? item.getItemMeta().getDisplayName() : "") + "[" + item.getType().toString() + "] is broken .");
//		Inventory inventory = player.getInventory();
//		ItemStack[] content = inventory.getContents();
//		int targetIndex = -1;
//		int replaceIndex = -1;
//		for (int i = 0; i < content.length; ++i) {
//			if (content[i] != null && content[i].getType().equals(item.getType()) && content[i].getAmount() == 0) {
//				targetIndex = i;
//				this.plugin_.getServer().broadcastMessage("Need to replace index " + targetIndex + " .");
//			}
//			if (content[i] != null && content[i].getType().equals(item.getType()) && content[i].getAmount() > 0) {
//				replaceIndex = i;
//				this.plugin_.getServer().broadcastMessage("Found replacement at index " + replaceIndex + " .");
//			}
//			if (targetIndex != -1 && replaceIndex != -1) {
//				break;
//			}
//		}
//		if (replaceIndex != -1 && targetIndex != -1) {
////			ItemStack neweItem = inventory.getItem(replaceIndex);
////			inventory.removeItem(replaceIndex);
////			inventory.addItem(neweItem);
//			content[targetIndex] = content[replaceIndex];
//			content[replaceIndex] = null;
//			inventory.setContents(content);
////			player.updateInventory();
//			player.sendMessage("You got a new " + (item.hasItemMeta() ? item.getItemMeta().getDisplayName() : "") + "[" + item.getType().toString() + "] from your inventory .");
//		} else {
//			player.sendMessage("You ran out of " + (item.hasItemMeta() ? item.getItemMeta().getDisplayName() : "") + "[" + item.getType().toString() + "] .");
//		}
	}
	
	@EventHandler
	public void onItemHeldEvent(PlayerItemHeldEvent _event) {
//		Player player = _event.getPlayer();
//		int newIndex = _event.getNewSlot();
//		int prevIndex = _event.getPreviousSlot();
////		ItemStack item = _event.getBrokenItem();
////		player.sendMessage((item.hasItemMeta() ? item.getItemMeta().getDisplayName() : "") + "[" + item.getType().toString() + "] is broken .");
//		Inventory inventory = player.getInventory();
//		ItemStack[] content = inventory.getContents();
//		int replaceIndex = -1;
//		for (int i = 0; i < content.length; ++i) {
////			if (content[i].getType().equals(item.getType()) && content[i].getAmount() > 0) {
////				replaceIndex = i;
////				this.plugin_.getServer().broadcastMessage("Found replacement at index " + replaceIndex + " .");
////				break;
////			}
//			if (content[i] != null) {
//				this.plugin_.getServer().broadcastMessage("[" + i + "]" + (content[i].hasItemMeta() ? content[i].getItemMeta().getDisplayName() : "") + "[" + content[i].getType().toString() + "] is broken .");
//			}
//		}
////		if (replaceIndex != -1) {
////			ItemStack neweItem = inventory.getItem(replaceIndex);
////			inventory.remove(replaceIndex);
////			player.setItemInHand(neweItem);
////			player.sendMessage("You got a new " + (item.hasItemMeta() ? item.getItemMeta().getDisplayName() : "") + "[" + item.getType().toString() + "] from your inventory .");
////		} else {
////			player.sendMessage("You ran out of " + (item.hasItemMeta() ? item.getItemMeta().getDisplayName() : "") + "[" + item.getType().toString() + "] .");
////		}
	}
}

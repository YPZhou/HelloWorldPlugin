package com.gmail.argoran.helloWorldPlugin.damageIndicator;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import com.gmail.argoran.helloWorldPlugin.HelloWorldPlugin;
import com.gmail.argoran.helloWorldPlugin.util.messageColor.MessageColor;

public class DamageListener implements Listener {

	HelloWorldPlugin plugin_;
	
	public DamageListener(HelloWorldPlugin _plugin) {
		this.plugin_ = _plugin;
	}
	
	@EventHandler
	public void onEntityDamageEvent(EntityDamageEvent _event) {
		Entity entity = _event.getEntity();
		if (_event instanceof EntityDamageByEntityEvent) {
			EntityDamageByEntityEvent edbeEvent = (EntityDamageByEntityEvent) _event;
			Entity srcEntity = edbeEvent.getDamager();
			if (srcEntity instanceof Player) {
				if (entity instanceof Player) {
					Player srcPlayer = (Player) srcEntity;
					Player rcvPlayer = (Player) entity;
					this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(srcPlayer.getDisplayName()) + " has dealt " + MessageColor.colorDamage(_event.getDamage()) + " damage(s) to " + MessageColor.colorPlayerName(rcvPlayer.getDisplayName()) + " .");
				} else {
					Player player = (Player) srcEntity;
					this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " has dealt " + MessageColor.colorDamage(_event.getDamage()) + " damage(s) to " + _event.getEntityType().getName() + " .");
				}					
			} else if (entity instanceof Player) {
				Player player = (Player) entity;
				this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " has taken " + MessageColor.colorDamage(_event.getDamage()) + " damage(s) [" + srcEntity.getType().getName() + "] .");
			}
		} else {			
			if (entity instanceof Player) {
				Player player = (Player) entity;
				this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " has taken " + MessageColor.colorDamage(_event.getDamage()) + " damage(s) [" + _event.getCause().toString() + "] .");
			}
		}
	}
}

package com.gmail.argoran.helloWorldPlugin.damageIndicator;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
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
				Player srcPlayer = (Player) srcEntity;
				String weaponName = srcPlayer.getItemInHand().getType().toString();
				if (entity instanceof Player) {					
					Player rcvPlayer = (Player) entity;
					this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(srcPlayer.getDisplayName()) + " has dealt " + MessageColor.colorDamage(_event.getDamage()) + " damage(s) to " + MessageColor.colorPlayerName(rcvPlayer.getDisplayName()) + " [" + weaponName + "] .");
				} else {
					this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(srcPlayer.getDisplayName()) + " has dealt " + MessageColor.colorDamage(_event.getDamage()) + " damage(s) to " + _event.getEntityType().getName() + " [" + weaponName + "] .");
				}					
			} else if (srcEntity instanceof Projectile) {
				Projectile proj = (Projectile) srcEntity;
				LivingEntity shooter = proj.getShooter();
				if (shooter instanceof Player) {
					Player srcPlayer = (Player) shooter;
					String weaponName = srcPlayer.getItemInHand().getType().toString();
					if (entity instanceof Player) {					
						Player rcvPlayer = (Player) entity;
						this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(srcPlayer.getDisplayName()) + " has dealt " + MessageColor.colorDamage(_event.getDamage()) + " damage(s) to " + MessageColor.colorPlayerName(rcvPlayer.getDisplayName()) + " [" + weaponName + "] .");
					} else {
						this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(srcPlayer.getDisplayName()) + " has dealt " + MessageColor.colorDamage(_event.getDamage()) + " damage(s) to " + _event.getEntityType().getName() + " [" + weaponName + "] .");
					}
				} else if (entity instanceof Player) {
					Player player = (Player) entity;
					this.plugin_.getServer().broadcastMessage(MessageColor.colorPlayerName(player.getDisplayName()) + " has taken " + MessageColor.colorDamage(_event.getDamage()) + " damage(s) [" + shooter.getType().getName() + " -> " + srcEntity.getType().getName() + "] .");
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

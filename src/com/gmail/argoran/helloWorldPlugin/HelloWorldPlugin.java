package com.gmail.argoran.helloWorldPlugin;

import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.argoran.helloWorldPlugin.changeName.ChangeName;
import com.gmail.argoran.helloWorldPlugin.damageIndicator.DamageListener;
import com.gmail.argoran.helloWorldPlugin.palutaPortal.PalutaPortal;
import com.gmail.argoran.helloWorldPlugin.replaceBrokenTool.ReplaceBrokenTool;

public class HelloWorldPlugin extends JavaPlugin {

	@Override
	public void onDisable() {
	}

	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new DamageListener(this), this);
		this.getServer().getPluginManager().registerEvents(new ReplaceBrokenTool(this), this);		
		this.getCommand("hw_change_name").setExecutor(new ChangeName(this));		
		
		PalutaPortal paluta = new PalutaPortal(this);
		this.getServer().getPluginManager().registerEvents(paluta, this);
		this.getCommand("hw_teleport_mine").setExecutor(paluta);
		this.getCommand("hw_teleport_paluta").setExecutor(paluta);
		
		this.getLogger().info("Hello World Plugin initialization done");
	}
}

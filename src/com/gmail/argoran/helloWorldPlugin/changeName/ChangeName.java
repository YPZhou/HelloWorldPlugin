package com.gmail.argoran.helloWorldPlugin.changeName;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.argoran.helloWorldPlugin.HelloWorldPlugin;

public class ChangeName implements CommandExecutor {
	
	private HelloWorldPlugin plugin_;
	
	public ChangeName(HelloWorldPlugin _plugin) {
		this.plugin_ = _plugin;
	}

	@Override
	public boolean onCommand(CommandSender _sender, Command _cmd, String _label, String[] _args) {
		if (_cmd.getName().equalsIgnoreCase("hw_change_name")) {
			if (_sender instanceof Player) {
				if (_args.length == 1) {
					Player player = (Player) _sender;
					String name = _args[0];
					player.setDisplayName(name);
					player.setPlayerListName(name);
					this.plugin_.getServer().broadcastMessage(player.getName() + " now has a new nickname " + name + " .");
				} else {
					return false;
				}
			} else {
				_sender.sendMessage("You can not use this command from console .");
			}
			return true;
		}
		return false;
	}
}

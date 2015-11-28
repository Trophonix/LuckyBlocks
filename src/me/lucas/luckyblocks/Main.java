package me.lucas.luckyblocks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor {

	@Override
	public void onEnable() {
		getCommand("lb").setExecutor(new CommandLB());
		
		new ListenerLB(this);
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
package me.lucas.luckyblocks;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandLB implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Must be executed via player!");
			return true;
		}
		
		Player player = (Player)sender;
		
		if(args.length == 0){
			player.sendMessage(ChatColor.RED + "Invalid command. Use /lb help for help.");
			return true;
		}
		
		
		if(args.length == 1){
			if (args[0].equalsIgnoreCase("help")) {
				player.sendMessage(ChatColor.BLUE + "/lb spawn" + ChatColor.YELLOW + " Spawns a lucky block where you are standing");
				return true;
			} else if (args[0].equalsIgnoreCase("spawn")) {
				ListenerLB.SpawnSponge(player, player.getLocation());
				player.sendMessage(ChatColor.AQUA + "A lucky block has been spawned at your current location!");
				return true;
			}
		}
		
		//Print invalid arguments at the end so if someone does any other weird combination of args it will always catch an invalid args at the end if its not caught else where.
		player.sendMessage(ChatColor.RED + "Invalid command. Use /lb help for help.");
		return true;
	}

}

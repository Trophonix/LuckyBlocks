package me.lucas.luckyblocks;

import javax.persistence.Entity;

import net.minecraft.server.v1_8_R2.ChatMessage;
import net.minecraft.server.v1_8_R2.Item;
import net.minecraft.server.v1_8_R2.PlayerConnection;
import net.minecraft.server.v1_8_R2.PlayerList;
import net.minecraft.server.v1_8_R2.PlayerSelector;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Egg;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.*;
import org.bukkit.inventory.ItemStack;

import com.avaje.ebeaninternal.server.cluster.mcast.Message;
import com.google.common.base.Ticker;
import com.mysql.jdbc.Messages;

public class ListenerLB implements Listener {
	static int amt;
	public ListenerLB(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onBreakSponge(BlockBreakEvent e) {
		Block block = e.getBlock();
		Player player = e.getPlayer();
		if (block.getType() == Material.SPONGE) {
			e.setCancelled(true);
			block.setType(Material.AIR);
			
			
			ItemStack item = new ItemStack(getRandItem(player, block), amt);
			player.getWorld().dropItem(e.getBlock().getLocation(), item);
		}
	}

	
	public static Material getRandItem(Player p, Block b) {
		Material item = null;
		int rand = randomInt(0, 22);
		int randItem = randomInt(1, 16);
		switch (rand) {
		case 0: item = Material.DIAMOND; amt = randItem; break;
		case 1: item = Material.GOLD_INGOT; amt = randItem; break;
		case 2: item = Material.IRON_INGOT; amt = randItem; break;
		case 3: item = Material.IRON_INGOT; amt = randItem; break;
		case 4: item = Material.DIAMOND_PICKAXE; amt = 1; break;
		case 5: item = Material.DIAMOND_AXE; amt = 1; break;
		case 6: item = Material.DIRT; amt = 0; SpawnEntity(p, b, EntityType.SKELETON); break;
		case 7: item = Material.DIRT; amt = 0; SpawnEntity(p, b, EntityType.SKELETON); break;
		case 8: item = Material.DIRT; amt = 0; SpawnEntity(p, b, EntityType.ZOMBIE); break;
		case 9: item = Material.DIRT; amt = 0; SpawnEntity(p, b, EntityType.ZOMBIE); break;
		case 10: item = Material.DIRT; amt = 0; SpawnEntity(p, b, EntityType.ZOMBIE); break;
		case 11: item = Material.LOG; amt = randomInt(32, 64); break;
		case 12: item = Material.COBBLESTONE; amt = randomInt(32, 128); break;
		case 13: item = Material.COBBLESTONE; amt = randomInt(16, 64); break;
		case 14: item = Material.COBBLESTONE; amt = randomInt(32, 64); break;
		case 15: item = Material.DIAMOND_CHESTPLATE; amt = 1; break;
		case 16: item = Material.DIAMOND_LEGGINGS; amt = 1; break;
		case 17: item = Material.DIRT; amt = 0; SpawnEntity(p, b, EntityType.ZOMBIE); break;
		case 18: item = Material.DIRT; amt = 0; SpawnEntity(p, b, EntityType.CREEPER); break;
		case 19: item = Material.DIRT; amt = 0; SpawnEntity(p, b, EntityType.CREEPER); break;
		case 20: item = Material.DIRT; amt = 0; SpawnEntity(p, b, EntityType.BLAZE); break;
		case 21: item = Material.DIRT; amt = 0; SpawnEntity(p, b, EntityType.PRIMED_TNT); break;
		}
		
		return item;
	}
	
	public static void SpawnEntity(Player p, Block b, EntityType e) {
		int randMobAmt = randomInt(1, 4);
		
		for (int i = 0; i < randMobAmt; i++) {
			p.getWorld().spawnEntity(b.getLocation(), e);
		}
	}
	
	public static void SpawnSponge(Player p, Location l) {
		Byte blockData = 0x0;
			p.getWorld().spawnFallingBlock(l, Material.SPONGE, blockData);
	}
	
	public static int randomInt(int Min, int Max) {
		return (int) (Math.floor(Math.random()*(Max-Min))+Min);
	}
}

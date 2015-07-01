package io.github.wolfleader116.customeffects.commands;

import io.github.wolfleader116.customeffects.CustomEffects;
import io.github.wolfleader116.wolfapi.Errors;
import io.github.wolfleader116.wolfapi.ItemModifiers;
import io.github.wolfleader116.wolfapi.ParticleEffect;
import io.github.wolfleader116.wolfapi.WolfAPI;

import java.util.Arrays;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItemsC implements CommandExecutor {
	
	private static final Logger log = Logger.getLogger("Minecraft");

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("customitems")) {
			if (!(sender instanceof Player)) {
				log.info("Only a player can run this command!");
			} else {
				Player p = (Player) sender;
				if (sender.hasPermission("customitems.use")) {
					if (args.length >= 1) {
						if (args[0].equalsIgnoreCase("ExplosiveBow")) {
							ItemStack explosivebow = new ItemStack(Material.BOW, 1, Short.parseShort("0"));
							explosivebow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
							explosivebow.addUnsafeEnchantment(Enchantment.DURABILITY, 32767);
							ItemMeta meta = explosivebow.getItemMeta();
							meta.setDisplayName("§c§lExplosive Bow");
							meta.setLore(Arrays.asList("§6" + p.getName() + "§b's", "§c§lExplosive Bow"));
							explosivebow.setItemMeta(meta);
							explosivebow = ItemModifiers.setFinal(explosivebow);
							p.getInventory().addItem(explosivebow);
							createDoubleHelix(p.getLocation());
							WolfAPI.message("Got explosive bow!", p, "CustomItems");
						} else if (args[0].equalsIgnoreCase("Jetpack")) {
							ItemStack jetpack = new ItemStack(Material.GOLD_CHESTPLATE, 1, Short.parseShort("0"));
							jetpack.addUnsafeEnchantment(Enchantment.DURABILITY, 32767);
							ItemMeta meta = jetpack.getItemMeta();
							meta.setDisplayName("§6§lJetpack");
							meta.setLore(Arrays.asList("§6" + p.getName() + "§b's", "§6§lJetpack"));
							jetpack.setItemMeta(meta);
							jetpack = ItemModifiers.setFinal(jetpack);
							if (p.getInventory().getChestplate() != null) {
								ItemStack originalchest = p.getInventory().getChestplate();
								p.getInventory().addItem(originalchest);
								p.getInventory().setChestplate(jetpack);
							} else {
								p.getInventory().setChestplate(jetpack);
							}
							createDoubleHelix(p.getLocation());
							WolfAPI.message("Got jetpack!", p, "CustomItems");
						} else if (args[0].equalsIgnoreCase("JetpackControl")) {
							ItemStack jetpackcontrol = new ItemStack(Material.STICK, 1, Short.parseShort("0"));
							jetpackcontrol.addUnsafeEnchantment(Enchantment.DURABILITY, 32767);
							ItemMeta meta = jetpackcontrol.getItemMeta();
							meta.setDisplayName("§6§lJetpack Control Stick");
							meta.setLore(Arrays.asList("§6" + p.getName() + "§b's", "§6§lJetpack Control Stick"));
							jetpackcontrol.setItemMeta(meta);
							jetpackcontrol = ItemModifiers.setFinal(jetpackcontrol);
							p.getInventory().addItem(jetpackcontrol);
							createDoubleHelix(p.getLocation());
							WolfAPI.message("Got jetpack control stick!", p, "CustomItems");
						} else if (args[0].equalsIgnoreCase("JetpackSet")) {
							ItemStack jetpackcontrol = new ItemStack(Material.STICK, 1, Short.parseShort("0"));
							jetpackcontrol.addUnsafeEnchantment(Enchantment.DURABILITY, 32767);
							ItemMeta controlmeta = jetpackcontrol.getItemMeta();
							controlmeta.setDisplayName("§6§lJetpack Control Stick");
							controlmeta.setLore(Arrays.asList("§6" + p.getName() + "§b's", "§6§lJetpack Control Stick"));
							jetpackcontrol.setItemMeta(controlmeta);
							jetpackcontrol = ItemModifiers.setFinal(jetpackcontrol);
							p.getInventory().addItem(jetpackcontrol);
							createDoubleHelix(p.getLocation());
							ItemStack jetpack = new ItemStack(Material.GOLD_CHESTPLATE, 1, Short.parseShort("0"));
							jetpack.addUnsafeEnchantment(Enchantment.DURABILITY, 32767);
							ItemMeta jetpackmeta = jetpack.getItemMeta();
							jetpackmeta.setDisplayName("§6§lJetpack");
							jetpackmeta.setLore(Arrays.asList("§6" + p.getName() + "§b's", "§6§lJetpack"));
							jetpack.setItemMeta(jetpackmeta);
							jetpack = ItemModifiers.setFinal(jetpack);
							if (p.getInventory().getChestplate() != null) {
								ItemStack originalchest = p.getInventory().getChestplate();
								p.getInventory().addItem(originalchest);
								p.getInventory().setChestplate(jetpack);
							} else {
								p.getInventory().setChestplate(jetpack);
							}
							createDoubleHelix(p.getLocation());
							WolfAPI.message("Got jetpack set!", p, "CustomItems");
						}
					} else {
						WolfAPI.message("Please add an item or set to get.", p, "CustomItems");
					}
				} else {
					Errors.sendError(Errors.NO_PERMISSION, p, "CustomItems");
				}
			}
		}
		return false;
	}
	
	public void createDoubleHelix(Location loc) {
		int radius = 1;
		long da = (long) -0.5;
		for (double y = 0; y <= 50; y+=0.05) {
			da = (long) (da + 0.5);
			if (y >= 6) {
				break;
			}
			double x = radius * Math.cos(y);
			double z = radius * Math.sin(y);
			final Location loca = new Location(loc.getWorld(), loc.getX() + x, loc.getY() + y, loc.getZ() + z);
			Bukkit.getScheduler().scheduleSyncDelayedTask(CustomEffects.plugin, new Runnable() {
				public void run() {
					try {
						ParticleEffect.FLAME.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, da);
		}
		long db = (long) -0.5;
		for (double y = 0; y <= 50; y+=0.05) {
			db = (long) (db + 0.5);
			if (y >= 6) {
				break;
			}
			double x = radius * Math.cos(y) * -1;
			double z = radius * Math.sin(y) * -1;
			final Location loca = new Location(loc.getWorld(), loc.getX() + x, loc.getY() + y, loc.getZ() + z);
			Bukkit.getScheduler().scheduleSyncDelayedTask(CustomEffects.plugin, new Runnable() {
				public void run() {
					try {
						ParticleEffect.FLAME.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, db);
		}
	}

}

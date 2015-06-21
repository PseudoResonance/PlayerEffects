package io.github.wolfleader116.customeffects;

import java.util.ArrayList;
import java.util.logging.Logger;

import io.github.wolfleader116.customeffects.commands.CustomItemsC;
import io.github.wolfleader116.customeffects.tabcompleters.CustomItemsTC;
import io.github.wolfleader116.wolfapi.Errors;
import io.github.wolfleader116.wolfapi.Particles;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class CustomEffects extends JavaPlugin implements Listener {
	
	private static final Logger log = Logger.getLogger("Minecraft");

	public ArrayList<Projectile> arrows = new ArrayList<Projectile>();

	public static CustomEffects plugin;

	@Override
	public void onEnable() {
		if (Bukkit.getServer().getPluginManager().getPlugin("WolfAPI") == null) {
			log.severe("WolfAPI was not found on the server! Disabling CustomEffects!");
			Bukkit.getServer().getPluginManager().disablePlugin(this);
		}
		Bukkit.getPluginManager().registerEvents(this, this);
		getCommand("customitems").setExecutor(new CustomItemsC());
		getCommand("customitems").setTabCompleter(new CustomItemsTC());
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for (Player online : Bukkit.getOnlinePlayers()) {
					Location loc = online.getLocation();
					if (online.hasPermission("customeffects.trail.portal")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.PORTAL, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 10);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.enchantmenttable")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.ENCHANTMENT_TABLE, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 10);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.cloud")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.CLOUD, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 0, 7);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.note")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.NOTE, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 6);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.redstone")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.REDSTONE, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 7);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.redstonered")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.REDSTONE, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 0, 7);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.critmagic")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.CRIT_MAGIC, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 8);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.barrier")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.BARRIER, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 0, 3);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.crit")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.CRIT, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 8);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.driplava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.DRIP_LAVA, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 10);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.dripwater")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.DRIP_WATER, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 10);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.fireworksspark")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.FIREWORKS_SPARK, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 9);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.flame")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.FLAME, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 7);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.heart")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.HEART, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 6);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.lava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.LAVA, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 4);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.slime")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.SLIME, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 8);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.smoke")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.SMOKE_NORMAL, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 9);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.snowshovel")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.SNOW_SHOVEL, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 8);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.snowball")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.SNOWBALL, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 6);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.spell")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.SPELL, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 7);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.spellinstant")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.SPELL_INSTANT, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 7);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.spellmob")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.SPELL_MOB, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 7);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.spellmobambient")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.SPELL_MOB_AMBIENT, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 7);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.spellwitch")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.SPELL_WITCH, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 7);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.depth")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.SUSPENDED_DEPTH, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 13);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.villagerangry")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.VILLAGER_ANGRY, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 5);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.villagerhappy")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.VILLAGER_HAPPY, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 5);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.waterbubble")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.WATER_BUBBLE, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 6);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.waterdrop")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.WATER_DROP, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 7);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.watersplash")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.WATER_SPLASH, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 9);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.waterwake")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.plugin.sendParticles(rec, Particles.WATER_WAKE, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 2, (float) 1, (float) 2, (float) 1, 9);
							}
						}
					}
				}
			}
		}, 0, 8);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				circle();
			}
		}, 0, 60);
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				for (Projectile arrow : arrows) {
					Location loc = arrow.getLocation();
					for (Player online : Bukkit.getOnlinePlayers()) {
						Particles.plugin.sendParticles(online, Particles.FLAME, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
					}
				}
			}
		}, 0, 3);
		plugin = this;
	}

	@Override
	public void onDisable() {
		plugin = null;
	}

	public void circle() {
		for (final Player online : Bukkit.getOnlinePlayers()) {
			final Location loc = online.getLocation();
			Location loca = loc;
			loca.setX(loca.getX() + 1);
			loca.setX(loca.getY() + 2.1);
			if (online.hasPermission("customeffects.circle.lava")) {
				for (Player rec : Bukkit.getOnlinePlayers()) {
					Particles.plugin.sendParticles(rec, Particles.DRIP_WATER, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
				}
			} else if (online.hasPermission("customeffects.circle.water")) {
				for (Player rec : Bukkit.getOnlinePlayers()) {
					Particles.plugin.sendParticles(rec, Particles.DRIP_LAVA, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
				}
			}
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = loc;
					loca.setX(loca.getX() + 0.7);
					loca.setX(loca.getY() + 2.1);
					loca.setZ(loca.getZ() + 0.7);
					if (online.hasPermission("customeffects.circle.lava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_WATER, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_LAVA, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					}
				}
			}, 3);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = loc;
					loca.setX(loca.getY() + 2.1);
					loca.setZ(loca.getZ() + 1);
					if (online.hasPermission("customeffects.circle.lava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_WATER, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_LAVA, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					}
				}
			}, 6);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = loc;
					loca.setX(loca.getX() - 0.7);
					loca.setX(loca.getY() + 2.1);
					loca.setZ(loca.getZ() + 0.7);
					if (online.hasPermission("customeffects.circle.lava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_WATER, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_LAVA, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					}
				}
			}, 9);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = loc;
					loca.setX(loca.getX() - 1);
					loca.setX(loca.getY() + 2.1);
					if (online.hasPermission("customeffects.circle.lava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_WATER, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_LAVA, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					}
				}
			}, 12);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = loc;
					loca.setX(loca.getX() - 0.7);
					loca.setX(loca.getY() + 2.1);
					loca.setZ(loca.getZ() - 0.7);
					if (online.hasPermission("customeffects.circle.lava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_WATER, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_LAVA, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					}
				}
			}, 15);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = loc;
					loca.setX(loca.getY() + 2.1);
					loca.setZ(loca.getZ() - 1);
					if (online.hasPermission("customeffects.circle.lava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_WATER, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_LAVA, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					}
				}
			}, 18);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = loc;
					loca.setX(loca.getX() + 0.7);
					loca.setX(loca.getY() + 2.1);
					loca.setZ(loca.getZ() - 0.7);
					if (online.hasPermission("customeffects.circle.lava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_WATER, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.plugin.sendParticles(rec, Particles.DRIP_LAVA, (float) loca.getX(), (float) loca.getY(), (float) loca.getZ(), (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					}
				}
			}, 21);
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getPlayer().getItemInHand().getType() == Material.BOW) {
				ItemMeta meta = e.getPlayer().getItemInHand().getItemMeta();
				if (meta.hasDisplayName()) {
					if (meta.getDisplayName().contains("§c§lExplosive Bow")) {
						if (e.getPlayer().hasPermission("customeffects.use")) {
							if (e.getPlayer().hasPermission("customeffects.explosive")) {
								Projectile shootarrow = e.getPlayer().launchProjectile(Arrow.class);
								shootarrow.setMetadata("Explosive1", new FixedMetadataValue(this, true));
								arrows.add(shootarrow);
								e.setCancelled(true);
							} else {
								Projectile shootarrow = e.getPlayer().launchProjectile(Arrow.class);
								shootarrow.setMetadata("Explosive", new FixedMetadataValue(this, true));
								arrows.add(shootarrow);
								e.setCancelled(true);
							}
						} else {
							Errors.sendError(Errors.NO_PERMISSION, e.getPlayer(), "CustomEffects");
						}
					}
				}
			} else if (e.getPlayer().getItemInHand().getType() == Material.STICK) {
				ItemMeta meta = e.getPlayer().getItemInHand().getItemMeta();
				if (meta.hasDisplayName()) {
					if (meta.getDisplayName().contains("§6§lJetpack Control Stick")) {
						if (e.getPlayer().hasPermission("customeffects.use")) {
							if (e.getPlayer().getInventory().getChestplate() != null) {
								ItemStack jetpack = e.getPlayer().getInventory().getChestplate();
								ItemMeta jetpackmeta = jetpack.getItemMeta();
								if (jetpack.getType() == Material.GOLD_CHESTPLATE) {
									if (jetpackmeta.hasDisplayName()) {
										if (jetpackmeta.getDisplayName().contains("§6§lJetpack")) {
											int dur = jetpack.getDurability();
											if (dur < 112) {
												Vector direction = e.getPlayer().getLocation().getDirection();
												direction.multiply(1.5);
												e.getPlayer().setVelocity(new Vector(direction.getX(), direction.getY(), direction.getZ()));
												dur = dur + 1;
												jetpack.setDurability((short) dur);
												e.getPlayer().getInventory().setChestplate(jetpack);
											}
										}
									}
								}
							}
						} else {
							Errors.sendError(Errors.NO_PERMISSION, e.getPlayer(), "CustomEffects");
						}
					}
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow) {
			Arrow arrow = (Arrow) e.getDamager();
			if (arrow.getShooter() instanceof Player) {
				Player shooter = (Player) arrow.getShooter();
				if (shooter.hasPermission("customeffects.use")) {
					if (arrow.hasMetadata("Explosive")) {
						Location loc = arrow.getLocation();
						arrow.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 3.0F, false, false);
						if (arrow.getWorld() != null) {
							arrow.remove();
							arrows.remove(arrow);
						} else {
							arrows.remove(arrow);
						}
					} else if (arrow.hasMetadata("Explosive1")) {
						Location loc = arrow.getLocation();
						arrow.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 6.0F, true, true);
						if (arrow.getWorld() != null) {
							arrow.remove();
							arrows.remove(arrow);
						} else {
							arrows.remove(arrow);
						}
					}
				}
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onProjectileHit(ProjectileHitEvent e) {
		if (e.getEntity() instanceof Arrow) {
			Arrow arrow = (Arrow) e.getEntity();
			if (arrow.getShooter() instanceof Player) {
				Player shooter = (Player) arrow.getShooter();
				if (shooter.hasPermission("customeffects.use")) {
					if (arrow.hasMetadata("Explosive")) {
						Location loc = arrow.getLocation();
						arrow.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 3.0F, false, false);
						if (arrow.getWorld() != null) {
							arrow.remove();
							arrows.remove(arrow);
						} else {
							arrows.remove(arrow);
						}
					} else if (arrow.hasMetadata("Explosive1")) {
						Location loc = arrow.getLocation();
						arrow.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), 6.0F, true, true);
						if (arrow.getWorld() != null) {
							arrow.remove();
							arrows.remove(arrow);
						} else {
							arrows.remove(arrow);
						}
					}
				}
			}
		}
	}
}

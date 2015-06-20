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
								Particles.PORTAL.display((float) 2, (float) 1, (float) 2, (float) 1, 10, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.enchantmenttable")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.ENCHANTMENT_TABLE.display((float) 2, (float) 1, (float) 2, (float) 1, 10, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.cloud")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.CLOUD.display((float) 2, (float) 1, (float) 2, (float) 0, 7, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.note")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.NOTE.display((float) 2, (float) 1, (float) 2, (float) 1, 6, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.redstone")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.REDSTONE.display((float) 2, (float) 1, (float) 2, (float) 1, 7, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.redstonered")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.REDSTONE.display((float) 2, (float) 1, (float) 2, (float) 0, 7, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.critmagic")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.CRIT_MAGIC.display((float) 2, (float) 1, (float) 2, (float) 1, 8, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.barrier")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.BARRIER.display((float) 2, (float) 1, (float) 2, (float) 0, 3, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.crit")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.CRIT.display((float) 2, (float) 1, (float) 2, (float) 1, 8, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.driplava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.DRIP_LAVA.display((float) 2, (float) 1, (float) 2, (float) 1, 10, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.dripwater")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.DRIP_WATER.display((float) 2, (float) 1, (float) 2, (float) 1, 10, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.fireworksspark")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.FIREWORKS_SPARK.display((float) 2, (float) 1, (float) 2, (float) 1, 9, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.flame")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.FLAME.display((float) 2, (float) 1, (float) 2, (float) 1, 7, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.heart")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.HEART.display((float) 2, (float) 1, (float) 2, (float) 1, 6, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.lava")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.LAVA.display((float) 2, (float) 1, (float) 2, (float) 1, 4, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.slime")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.SLIME.display((float) 2, (float) 1, (float) 2, (float) 1, 8, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.smoke")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.SMOKE_NORMAL.display((float) 2, (float) 1, (float) 2, (float) 1, 9, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.snowshovel")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.SNOW_SHOVEL.display((float) 2, (float) 1, (float) 2, (float) 1, 8, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.snowball")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.SNOWBALL.display((float) 2, (float) 1, (float) 2, (float) 1, 6, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.spell")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.SPELL.display((float) 2, (float) 1, (float) 2, (float) 1, 7, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.spellinstant")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.SPELL_INSTANT.display((float) 2, (float) 1, (float) 2, (float) 1, 7, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.spellmob")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.SPELL_MOB.display((float) 2, (float) 1, (float) 2, (float) 1, 7, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.spellmobambient")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.SPELL_MOB_AMBIENT.display((float) 2, (float) 1, (float) 2, (float) 1, 7, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.spellwitch")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.SPELL_WITCH.display((float) 2, (float) 1, (float) 2, (float) 1, 7, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.depth")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.SUSPENDED_DEPTH.display((float) 2, (float) 1, (float) 2, (float) 1, 13, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.villagerangry")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.VILLAGER_ANGRY.display((float) 2, (float) 1, (float) 2, (float) 1, 5, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.villagerhappy")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.VILLAGER_HAPPY.display((float) 2, (float) 1, (float) 2, (float) 1, 5, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.waterbubble")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.WATER_BUBBLE.display((float) 2, (float) 1, (float) 2, (float) 1, 6, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.waterdrop")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.WATER_DROP.display((float) 2, (float) 1, (float) 2, (float) 1, 7, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.watersplash")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.WATER_SPLASH.display((float) 2, (float) 1, (float) 2, (float) 1, 9, loc, rec);
							}
						}
					}
					if (online.hasPermission("customeffects.trail.waterwake")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							if (rec != online) {
								Particles.WATER_WAKE.display((float) 2, (float) 1, (float) 2, (float) 1, 9, loc, rec);
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
						Particles.FLAME.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loc, online);
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
					Particles.DRIP_WATER.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
				}
			} else if (online.hasPermission("customeffects.circle.water")) {
				for (Player rec : Bukkit.getOnlinePlayers()) {
					Particles.DRIP_LAVA.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
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
							Particles.DRIP_WATER.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.DRIP_LAVA.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
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
							Particles.DRIP_WATER.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.DRIP_LAVA.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
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
							Particles.DRIP_WATER.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.DRIP_LAVA.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
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
							Particles.DRIP_WATER.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.DRIP_LAVA.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
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
							Particles.DRIP_WATER.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.DRIP_LAVA.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
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
							Particles.DRIP_WATER.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.DRIP_LAVA.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
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
							Particles.DRIP_WATER.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
						}
					} else if (online.hasPermission("customeffects.circle.water")) {
						for (Player rec : Bukkit.getOnlinePlayers()) {
							Particles.DRIP_LAVA.display((float) 0, (float) 0, (float) 0, (float) 0, 1, loca, rec);
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

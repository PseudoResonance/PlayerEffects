package io.github.wolfleader116.customeffects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import io.github.wolfleader116.customeffects.commands.CustomItemsC;
import io.github.wolfleader116.customeffects.tabcompleters.CustomItemsTC;
import io.github.wolfleader116.wolfapi.Errors;
import io.github.wolfleader116.wolfapi.ParticleEffect;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class CustomEffects extends JavaPlugin implements Listener {

	private static final Logger log = Logger.getLogger("Minecraft");

	public ArrayList<Projectile> arrows = new ArrayList<Projectile>();
	
	public HashMap<Projectile, String> arrowdata = new HashMap<Projectile, String>();

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
				try {
					for (Player online : Bukkit.getOnlinePlayers()) {
						Location loc = online.getLocation();
						if (online.hasPermission("customeffects.trail.portal")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.PORTAL.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 10);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.enchantmenttable")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.ENCHANTMENT_TABLE.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 10);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.cloud")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.CLOUD.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 0, 7);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.note")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.NOTE.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 6);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.redstone")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.REDSTONE.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 7);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.redstonered")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.REDSTONE.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 0, 7);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.critmagic")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.CRIT_MAGIC.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 8);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.barrier")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.BARRIER.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 0, 3);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.crit")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.CRIT.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 8);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.driplava")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.DRIP_LAVA.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 10);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.dripwater")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.DRIP_WATER.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 10);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.fireworksspark")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.FIREWORKS_SPARK.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 9);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.flame")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.FLAME.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 7);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.heart")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.HEART.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 6);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.lava")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.LAVA.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 4);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.slime")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.SLIME.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 8);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.smoke")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.SMOKE_NORMAL.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 9);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.snowshovel")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.SNOW_SHOVEL.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 8);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.snowball")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.SNOWBALL.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 6);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.spell")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.SPELL.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 7);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.spellinstant")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.SPELL_INSTANT.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 7);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.spellmob")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.SPELL_MOB.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 7);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.spellmobambient")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.SPELL_MOB_AMBIENT.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 7);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.spellwitch")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.SPELL_WITCH.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 7);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.depth")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.SUSPENDED_DEPTH.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 13);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.villagerangry")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.VILLAGER_ANGRY.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 5);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.villagerhappy")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.VILLAGER_HAPPY.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 5);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.waterbubble")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.WATER_BUBBLE.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 6);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.waterdrop")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.WATER_DROP.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 7);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.watersplash")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.WATER_SPLASH.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 9);
								}
							}
						}
						if (online.hasPermission("customeffects.trail.waterwake")) {
							for (Player rec : Bukkit.getOnlinePlayers()) {
								if (rec != online) {
									ParticleEffect.WATER_WAKE.sendToPlayer(rec, loc, (float) 2, (float) 1, (float) 2, (float) 1, 9);
								}
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
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
					try {
						ParticleEffect.FLAME.sendToPlayers(Bukkit.getOnlinePlayers(), loc, (float) 0, (float) 0, (float) 0, (float) 0, 1);
					} catch (Exception e) {
						e.printStackTrace();
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
			Location loca = new Location(loc.getWorld(), loc.getX() + 1, loc.getY() + 2.1, loc.getZ());
			try {
				if (online.hasPermission("customeffects.circle.water")) {
					ParticleEffect.DRIP_WATER.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
				} else if (online.hasPermission("customeffects.circle.lava")) {
					ParticleEffect.DRIP_LAVA.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = new Location(loc.getWorld(), loc.getX() + 0.7, loc.getY() + 2.1, loc.getZ() + 0.7);
					try {
						if (online.hasPermission("customeffects.circle.water")) {
							ParticleEffect.DRIP_WATER.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						} else if (online.hasPermission("customeffects.circle.lava")) {
							ParticleEffect.DRIP_LAVA.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, 3);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = new Location(loc.getWorld(), loc.getX(), loc.getY() + 2.1, loc.getZ() + 1);
					try {
						if (online.hasPermission("customeffects.circle.water")) {
							ParticleEffect.DRIP_WATER.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						} else if (online.hasPermission("customeffects.circle.lava")) {
							ParticleEffect.DRIP_LAVA.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, 6);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = new Location(loc.getWorld(), loc.getX() - 0.7, loc.getY() + 2.1, loc.getZ() + 0.7);
					try {
						if (online.hasPermission("customeffects.circle.water")) {
							ParticleEffect.DRIP_WATER.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						} else if (online.hasPermission("customeffects.circle.lava")) {
							ParticleEffect.DRIP_LAVA.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, 9);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = new Location(loc.getWorld(), loc.getX() - 1, loc.getY() + 2.1, loc.getZ());
					try {
						if (online.hasPermission("customeffects.circle.water")) {
							ParticleEffect.DRIP_WATER.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						} else if (online.hasPermission("customeffects.circle.lava")) {
							ParticleEffect.DRIP_LAVA.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, 12);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = new Location(loc.getWorld(), loc.getX() - 0.7, loc.getY() + 2.1, loc.getZ() - 0.7);
					try {
						if (online.hasPermission("customeffects.circle.water")) {
							ParticleEffect.DRIP_WATER.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						} else if (online.hasPermission("customeffects.circle.lava")) {
							ParticleEffect.DRIP_LAVA.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, 15);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = new Location(loc.getWorld(), loc.getX(), loc.getY() + 2.1, loc.getZ() - 1);
					try {
						if (online.hasPermission("customeffects.circle.water")) {
							ParticleEffect.DRIP_WATER.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						} else if (online.hasPermission("customeffects.circle.lava")) {
							ParticleEffect.DRIP_LAVA.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, 18);
			Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
				public void run() {
					Location loca = new Location(loc.getWorld(), loc.getX() + 0.7, loc.getY() + 2.1, loc.getZ() - 0.7);
					try {
						if (online.hasPermission("customeffects.circle.water")) {
							ParticleEffect.DRIP_WATER.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						} else if (online.hasPermission("customeffects.circle.lava")) {
							ParticleEffect.DRIP_LAVA.sendToPlayers(Bukkit.getOnlinePlayers(), loca, (float) 0, (float) 0, (float) 0, (float) 0, 1);
						}
					} catch (Exception e) {
						e.printStackTrace();
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
							String power = "";
							String fire = "";
							String damage = "";
							List<String> lore = meta.getLore();
							if (lore.get(3) != null) {
								if (NumberUtils.isNumber(lore.get(3))) {
									power = lore.get(3);
								} else {
									power = "3";
									Bukkit.broadcastMessage("Power is not number");
								}
							} else {
								power = "3";
								Bukkit.broadcastMessage("Failed to get power");
							}
							if (lore.get(5) != null) {
								if (lore.get(5).equalsIgnoreCase("true") || lore.get(5).equalsIgnoreCase("false")) {
									fire = lore.get(5).toLowerCase();
								} else {
									fire = "false";
									Bukkit.broadcastMessage("Fire is not true/false");
								}
							} else {
								Bukkit.broadcastMessage("Failed to get fire");
								fire = "false";
							}
							if (lore.get(7) != null) {
								if (lore.get(7).equalsIgnoreCase("true") || lore.get(5).equalsIgnoreCase("false")) {
									damage = lore.get(7).toLowerCase();
								} else {
									damage = "false";
									Bukkit.broadcastMessage("Fire is not true/false");
								}
							} else {
								Bukkit.broadcastMessage("Failed to get damage");
								damage = "false";
							}
							Projectile shootarrow = e.getPlayer().launchProjectile(Arrow.class);
							arrowdata.put(shootarrow, power + ":" + fire + ":" + damage);
							Bukkit.broadcastMessage(power + ":" + fire + ":" + damage);
							arrows.add(shootarrow);
							e.setCancelled(true);
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
												Double power;
												List<String> lore = meta.getLore();
												if (lore.get(3) != null) {
													if (NumberUtils.isNumber(lore.get(3))) {
														power = Double.valueOf(lore.get(3));
													} else {
														power = 1.5;
													}
												} else {
													power = 1.5;
												}
												Vector direction = e.getPlayer().getLocation().getDirection();
												direction.multiply(power);
												e.getPlayer().setVelocity(new Vector(direction.getX(), direction.getY(), direction.getZ()));
												if (e.getPlayer().getGameMode() == GameMode.ADVENTURE || e.getPlayer().getGameMode() == GameMode.SURVIVAL) {
													dur = dur + 1;
												}
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
					if (arrowdata.containsValue(arrow)) {
						String data = arrowdata.get(arrow);
						String[] datas = data.split(":");
						Location loc = arrow.getLocation();
						Bukkit.broadcastMessage("CustomEffects Debug: X: " + loc.getX() + " Y: " + loc.getY() + " Z: " + loc.getZ() + " Power: " + Integer.valueOf(datas[0] + " Creates Fire: " + Boolean.valueOf(datas[1]) + " Damages Blocks: " + Boolean.valueOf(datas[2])));
						arrow.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), Integer.valueOf(datas[0]), Boolean.valueOf(datas[1]), Boolean.valueOf(datas[2]));
						if (arrow.isValid()) {
							arrow.remove();
							arrows.remove(arrow);
							arrowdata.remove(arrow);
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
					if (arrowdata.containsValue(arrow)) {
						String data = arrowdata.get(arrow);
						String[] datas = data.split(":");
						Location loc = arrow.getLocation();
						Bukkit.broadcastMessage("CustomEffects Debug: X: " + loc.getX() + " Y: " + loc.getY() + " Z: " + loc.getZ() + " Power: " + Integer.valueOf(datas[0] + " Creates Fire: " + Boolean.valueOf(datas[1]) + " Damages Blocks: " + Boolean.valueOf(datas[2])));
						arrow.getWorld().createExplosion(loc.getX(), loc.getY(), loc.getZ(), Integer.valueOf(datas[0]), Boolean.valueOf(datas[1]), Boolean.valueOf(datas[2]));
						if (arrow.isValid()) {
							arrow.remove();
							arrows.remove(arrow);
							arrowdata.remove(arrow);
						} else {
							arrows.remove(arrow);
						}
					}
				}
			}
		}
	}
}
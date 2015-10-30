package io.github.wolfleader116.playereffects.commands;

import io.github.wolfleader116.playereffects.PlayerEffects;
import io.github.wolfleader116.wolfapi.Errors;
import io.github.wolfleader116.wolfapi.WolfAPI;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerEffectsC implements CommandExecutor {

	private static final Logger log = Logger.getLogger("Minecraft");

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		File configFile = new File(PlayerEffects.plugin.getDataFolder(), "config.yml");
		if (cmd.getName().equalsIgnoreCase("playereffects")) {
			if (!(sender instanceof Player)) {
				if (args.length == 0) {
					log.info("Use /playereffects help for a list of commands.");
					log.info("PlayerEffects plugin created by WolfLeader116");
					log.info("===---PlayerEffects Info---===");
				} else if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("help")) {
						log.info("/playereffects reload Reloads the config.");
						log.info("/playereffects reset Resets the config.");
						log.info("/playereffects help Shows this message.");
						log.info("/playereffects Shows the info page.");
						log.info("===---PlayerEffects Help---===");
					} else if (args[0].equalsIgnoreCase("reset")) {
						configFile.delete();
						PlayerEffects.plugin.saveDefaultConfig();
						log.info("Reset the config!");
					} else if (args[0].equalsIgnoreCase("reload")) {
						PlayerEffects.plugin.reloadConfig();
						log.info("Reloaded the config!");
					}
				}
			} else {
				Player p = (Player) sender;
				if (args.length == 0) {
					sender.sendMessage(ChatColor.DARK_AQUA + "===---" + ChatColor.GOLD + "PlayerEffects Info" + ChatColor.DARK_AQUA + "---===");
					sender.sendMessage(ChatColor.AQUA + "PlayerEffects plugin created by WolfLeader116");
					sender.sendMessage(ChatColor.AQUA + "Use " + ChatColor.RED + "/playereffects help " + ChatColor.AQUA + "for a list of commands.");
				} else if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(ChatColor.DARK_AQUA + "===---" + ChatColor.GOLD + "PlayerEffects Help" + ChatColor.DARK_AQUA + "---===");
						sender.sendMessage(ChatColor.RED + "/playereffects " + ChatColor.AQUA + "Shows the info page.");
						sender.sendMessage(ChatColor.RED + "/playereffects help " + ChatColor.AQUA + "Shows this message.");
						if (sender.hasPermission("playereffects.reset")) {
							sender.sendMessage(ChatColor.RED + "/playereffects reset " + ChatColor.AQUA + "Resets the config.");
						}
						if (sender.hasPermission("playereffects.reload")) {
							sender.sendMessage(ChatColor.RED + "/playereffects reload " + ChatColor.AQUA + "Reloads the config.");
						}
					} else if (args[0].equalsIgnoreCase("reset")) {
						if (sender.hasPermission("playereffects.reset")) {
							configFile.delete();
							PlayerEffects.plugin.saveDefaultConfig();
							WolfAPI.message("Reset the config!", p, "PlayerEffects");
						} else {
							Errors.sendError(Errors.NO_PERMISSION, p, "PlayerEffects");
						}
					} else if (args[0].equalsIgnoreCase("reload")) {
						if (sender.hasPermission("playereffects.reload")) {
							PlayerEffects.plugin.reloadConfig();
							WolfAPI.message("Reloaded the config!", p, "PlayerEffects");
						} else {
							Errors.sendError(Errors.NO_PERMISSION, p, "PlayerEffects");
						}
					}
				}
			}
		}
		return false;
	}

}

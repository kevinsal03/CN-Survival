package me.kevsal.minecraft.cnsurvival;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModeController {

    public static void switchMode(CNSurvival plugin, Player p, PlayerMode mode) {
        CommandSender console = plugin.getServer().getConsoleSender();
        String playerUUID = p.getUniqueId().toString();
        String playerName = p.getName();

        if(mode == PlayerMode.PEACEFUL && !p.hasPermission("cn.allowmode.peaceful")) {
            p.sendMessage(ChatColor.RED + "You do not have permission to enter that mode!");
        } else {
            if(!getMode(plugin, p).equals(PlayerMode.NONE)) {
                String command = "lp user " + playerUUID + " permission unset cs.mode." + getMode(plugin, p).toString().toLowerCase() + " server=smp1";
                plugin.getServer().dispatchCommand(console, command);
            }
            String command = "lp user " + playerUUID + " permission set cs.mode." + mode.toString().toLowerCase() + " true server=smp1";
            plugin.getServer().dispatchCommand(console, command);
            p.sendMessage(ChatColor.GREEN + "Mode set to: " + mode.toString());

        }
    }

    public static PlayerMode getMode(CNSurvival plugin, Player p) {

        PlayerMode mode = PlayerMode.NONE; //Return none if unknown

        if (p.hasPermission("cs.mode.normal")) {
            mode = PlayerMode.NORMAL;
        } else if (p.hasPermission("cs.mode.nopvp")) {
            mode = PlayerMode.NOPVP;
        } else if (p.hasPermission("cs.mode.peaceful")) {
            mode = PlayerMode.PEACEFUL;
        }

        return mode;

    }
}
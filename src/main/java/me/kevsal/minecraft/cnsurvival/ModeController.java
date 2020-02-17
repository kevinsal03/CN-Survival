package me.kevsal.minecraft.cnsurvival;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ModeController {

    public static void switchMode(CNSurvival plugin, Player p, PlayerMode mode) {
        CommandSender console = plugin.getServer().getConsoleSender();
        String playerUUID = p.getUniqueId().toString();
        String playerName = p.getName();

        String command = "lp user " + playerUUID + " permission set cn.mode." + mode.toString().toLowerCase() + " true server=smp1";

        plugin.getServer().dispatchCommand(console, command);
    }

    public static PlayerMode getMode(CNSurvival plugin, Player p) {

        PlayerMode mode = PlayerMode.NONE; //Return none if unknown

        if (p.hasPermission("cn.mode.normal")) {
            mode = PlayerMode.NORMAL;
        } else if (p.hasPermission("cn.mode.nopvp")) {
            mode = PlayerMode.NOPVP;
        } else if (p.hasPermission("cn.mode.peaceful")) {
            mode = PlayerMode.PEACEFUL;
        }

        return mode;

    }
}
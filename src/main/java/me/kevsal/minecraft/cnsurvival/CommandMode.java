package me.kevsal.minecraft.cnsurvival;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMode implements CommandExecutor {

    private final CNSurvival plugin;

    public CommandMode (CNSurvival plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length != 1) {
                p.sendMessage(ChatColor.RED + "/mode <menu, PEACEFUL, NOPVP, NORMAL>");
            } else {
                if(args[0] == "menu") {
                    //TODO: Open menu
                } else {
                    if (args[0].equals("PEACEFUL") | args[0].equals("NOPVP") | args[0].equals("NORMAL")) {
                        ModeController.switchMode(plugin, p, PlayerMode.valueOf(args[0]));
                    } else {
                        p.sendMessage(ChatColor.RED + "/mode <menu, PEACEFUL, NOPVP, NORMAL>");
                    }
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Command can only be run by players!");
        }

        return true;
    }
}

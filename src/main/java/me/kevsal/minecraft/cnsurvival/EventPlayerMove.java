package me.kevsal.minecraft.cnsurvival;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class EventPlayerMove implements Listener {

    private final CNSurvival plugin;

    public EventPlayerMove (CNSurvival plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(ModeController.getMode(plugin, p) == PlayerMode.NONE) {
            p.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "You must select a mode to be able to move!");
            p.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Do /mode menu for help!");
            p.openInventory(ModeMenu.modeMenu);
            e.setCancelled(true);
        }
    }

}

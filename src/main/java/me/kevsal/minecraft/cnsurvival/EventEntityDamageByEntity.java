package me.kevsal.minecraft.cnsurvival;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventEntityDamageByEntity implements Listener {

    @EventHandler(ignoreCancelled = true , priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            if (p.hasPermission("cs.mode.peaceful")) {
                p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "ClubNetwork> " + ChatColor.RED + "You can not attack other entities while in peaceful mode!");
                e.setCancelled(true);
            } else if (p.hasPermission("cs.mode.nopvp")) {
                if (e.getEntity() instanceof Player) {
                    p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "ClubNetwork> " + ChatColor.RED + "You can not attack other players while you have PVP disabled!");
                    e.setCancelled(true);
                }
            }

            //check of other players damaging this player
            if (e.getEntity() instanceof Player) {
                Player targetPlayer = (Player) e.getEntity();
                if ((targetPlayer.hasPermission("cs.mode.peaceful") | targetPlayer.hasPermission("cs.mode.nopvp"))) {
                    p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "ClubNetwork> " + ChatColor.RED + "You can not attack that player because they are in peaceful/no pvp mode!");
                    e.setCancelled(true);
                }
            }
        }
        if (e.getEntity() instanceof Player) {
            Player targetPlayer = (Player) e.getEntity();
            if ((targetPlayer.hasPermission("cs.mode.peaceful"))) {
                e.setCancelled(true);
            }
        }

    }
}

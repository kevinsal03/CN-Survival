package me.kevsal.minecraft.cnsurvival;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventEntityDamageByEntity implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerAttack(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            if (p.hasPermission("cs.mode.peaceful")) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "ClubNetwork> " + ChatColor.RED + "You can not attack other entities while in peaceful mode!");
            } else if (p.hasPermission("cs.mode.nopvp")) {
                if (e.getEntity() instanceof Player) {
                    e.setCancelled(true);
                    p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD  + "ClubNetwork> " + ChatColor.RED + "You can not attack other players while you have PVP disabled!");
                }
            }
        }
    }
}

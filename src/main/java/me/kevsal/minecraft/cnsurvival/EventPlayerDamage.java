package me.kevsal.minecraft.cnsurvival;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EventPlayerDamage implements Listener {

    @EventHandler
    public void onPlayerDamageEvent(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (!p.hasPermission("cs.mode.peaceful")) {
                if (p.getAllowFlight()) {
                    if(p.isFlying()) {
                        Location safePlayerLoc = p.getLocation();
                        safePlayerLoc.setY(p.getWorld().getHighestBlockAt(p.getLocation()).getY());
                        p.teleport(safePlayerLoc);
                    }
                    p.setFlying(false);
                    p.setAllowFlight(false);
                    p.sendMessage("" + ChatColor.DARK_RED + ChatColor.BOLD + "ClubSurvival> " + ChatColor.RED + "Your fly was automatically disabled because you took damage!");
                }
            }
        }
    }

}

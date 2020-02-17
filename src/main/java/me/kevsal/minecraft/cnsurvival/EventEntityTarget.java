package me.kevsal.minecraft.cnsurvival;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class EventEntityTarget implements Listener {


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityTarget(EntityTargetEvent e) {
        if (e.getTarget() instanceof Player) {
            Player p = (Player) e.getTarget();
            if (p.hasPermission("cs.mode.peaceful")) {
                e.setCancelled(true);
            }
        }

    }


}

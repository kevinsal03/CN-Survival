package me.kevsal.minecraft.cnsurvival;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class EventEntityTarget implements Listener {


    @EventHandler(ignoreCancelled = true , priority = EventPriority.HIGHEST)
    public void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent e) {
        if (e.getTarget() instanceof Player) {
            Player p = (Player) e.getTarget();
            if (p.hasPermission("cs.mode.peaceful")) {
                e.setTarget(null);
                //e.getEntity().setCustomNameVisible(true);
                //e.getEntity().setCustomName("TARGETED PLAYER");
            }
        }

    }


}

package me.kevsal.minecraft.cnsurvival;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CNSurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Registering Events");
        Bukkit.getPluginManager().registerEvents(new EventPlayerDamage(), this);
        Bukkit.getPluginManager().registerEvents(new EventEntityTarget(), this);
    }

    @Override
    public void onDisable() {

    }


}

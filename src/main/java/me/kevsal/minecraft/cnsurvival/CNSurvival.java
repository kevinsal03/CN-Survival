package me.kevsal.minecraft.cnsurvival;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class CNSurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EventPlayerDamage(), this);
    }

    @Override
    public void onDisable() {

    }


}

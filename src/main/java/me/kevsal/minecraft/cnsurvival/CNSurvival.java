package me.kevsal.minecraft.cnsurvival;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class CNSurvival extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Registering Events");
        Bukkit.getPluginManager().registerEvents(new EventPlayerDamage(), this);
        Bukkit.getPluginManager().registerEvents(new EventEntityTarget(), this);
        Bukkit.getPluginManager().registerEvents(new EventEntityDamageByEntity(), this);
        Bukkit.getPluginManager().registerEvents(new EventPlayerMove(this), this);
        Bukkit.getPluginManager().registerEvents(new ModeMenu(this), this);

        Objects.requireNonNull(this.getCommand("mode")).setExecutor(new CommandMode(this));
    }

    @Override
    public void onDisable() {

    }


}

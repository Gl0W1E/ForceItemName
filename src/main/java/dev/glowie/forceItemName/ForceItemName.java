package dev.glowie.forceItemName;

import dev.glowie.forceItemName.listener.ContainerListener;
import dev.glowie.forceItemName.listener.CraftListener;
import dev.glowie.forceItemName.listener.JoinListener;
import dev.glowie.forceItemName.listener.PickupListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForceItemName extends JavaPlugin {
    static ForceItemName instance;

    @Override
    public void onEnable() {
        instance = this;
        loadConfig();
        registerListeners();
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public void registerListeners() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PickupListener(), this);
        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new ContainerListener(), this);
        pm.registerEvents(new CraftListener(), this);
    }

    public static ForceItemName getInstance() {
        return instance;
    }

    public void loadConfig(){
        instance.getConfig().options().copyDefaults(false);
        instance.saveDefaultConfig();
    }
}

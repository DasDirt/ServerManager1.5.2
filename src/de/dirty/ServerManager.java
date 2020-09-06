package de.dirty;

import de.dirty.commands.MenuCommand;
import de.dirty.listener.DeathListener;
import de.dirty.listener.InventoryListener;
import de.dirty.util.GlobalInstances;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerManager extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Loading ServerManager1.5.2");
        GlobalInstances.createInvs();
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(), this);
        System.out.println("Enabling keepInventory for every world");
        for (World world : Bukkit.getWorlds()) {
            world.setGameRuleValue("keepInventory", "true");
        }
        getCommand("menu").setExecutor(new MenuCommand());
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

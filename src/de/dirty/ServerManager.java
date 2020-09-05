package de.dirty;

import de.dirty.commands.DeathItemsCommand;
import de.dirty.listener.DeathListener;
import de.dirty.util.ContentLocationData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerManager extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Loading ServerManager1.5.2");
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        getCommand("deathItems").setExecutor(new DeathItemsCommand());
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

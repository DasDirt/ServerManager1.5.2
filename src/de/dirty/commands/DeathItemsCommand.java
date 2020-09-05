package de.dirty.commands;

import de.dirty.listener.DeathListener;
import de.dirty.util.ContentLocationData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DeathItemsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            ContentLocationData toRemove = null;
            for (ContentLocationData contentLocationData : DeathListener.contentLocationDataList) {
                if (p == contentLocationData.getPlayer() && p.getLocation().getBlockX() == contentLocationData.getLocation().getBlockX() && p.getLocation().getBlockZ() == contentLocationData.getLocation().getBlockZ()) {
                    for (ItemStack itemStack : contentLocationData.getItemStacks()) {
                        if (itemStack != null) {
                            p.getInventory().addItem(itemStack);
                        }
                    }
                    toRemove = contentLocationData;
                    p.sendMessage("Du hast deine Items bekommen.");
                }
            }
            if (toRemove != null) {
                DeathListener.contentLocationDataList.remove(toRemove);
            }
        }
        return false;
    }
}

package de.dirty.listener;

import de.dirty.util.ContentLocationData;
import de.dirty.util.GlobalInstances;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onDead(PlayerDeathEvent e) {
        Player player = e.getEntity();
        ContentLocationData contentLocationData = new ContentLocationData(player.getUniqueId().toString(), player.getLocation(), player.getInventory().getContents());
        player.sendMessage("Du bist bei " + contentLocationData.getLocation().getBlockX() + " " + contentLocationData.getLocation().getBlockY() + " " + contentLocationData.getLocation().getBlockZ() + " gestorben.");
        GlobalInstances.contentLocationDataList.add(contentLocationData);
        player.getInventory().clear();
    }
}

package de.dirty.listener;

import de.dirty.util.ContentLocationData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeathListener implements Listener {

    public static List<ContentLocationData> contentLocationDataList = new ArrayList<>();

    @EventHandler
    public void onDead(PlayerDeathEvent e) {
        Player player = e.getEntity();
        ContentLocationData contentLocationData = new ContentLocationData(player, player.getLocation(), player.getInventory().getContents());
        player.sendMessage("Du bist bei " + contentLocationData.getLocation().getBlockX() + " " + contentLocationData.getLocation().getBlockY() + " " + contentLocationData.getLocation().getBlockZ() + " gestorben.");
        contentLocationDataList.add(contentLocationData);
        player.getInventory().clear();
    }
}

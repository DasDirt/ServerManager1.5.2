package de.dirty.listener;

import de.dirty.util.ContentLocationData;
import de.dirty.util.GlobalInstances;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {

    @EventHandler
    public void on(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        switch (e.getInventory().getName()) {
            case "§r§2§lMenu":
                e.setCancelled(true);
                if (e.getCurrentItem() != null) {
                    ItemStack stack = e.getCurrentItem();
                    if (stack.getItemMeta() != null && stack.getItemMeta().getDisplayName() != null) {
                        switch (stack.getItemMeta().getDisplayName()) {
                            case "Shop":
                                player.closeInventory();
                                player.openInventory(GlobalInstances.shop);
                                break;
                            case "Team Items":

                                break;
                            case "Trade/Present":

                                break;
                            case "Pickup Death Items":
                                ContentLocationData toRemove = null;
                                for (ContentLocationData contentLocationData : GlobalInstances.contentLocationDataList) {
                                    if (player.getLocation().getBlockX() == contentLocationData.getLocation().getBlockX() && player.getLocation().getBlockZ() == contentLocationData.getLocation().getBlockZ()) {
                                        for (ItemStack itemStack : contentLocationData.getItemStacks()) {
                                            if (itemStack != null) {
//                                        player.getInventory().addItem(itemStack);
                                                player.getWorld().dropItem(player.getLocation(), itemStack);
                                            }
                                        }
                                        toRemove = contentLocationData;
                                        player.sendMessage("Die Items sind gedropt.");
                                    }
                                }
                                if (toRemove != null) {
                                    GlobalInstances.contentLocationDataList.remove(toRemove);
                                } else {
                                    player.sendMessage("An deiner aktuellen Position ist kein Spieler gestorben.");
                                }
                                break;
                            default:
                                //do nothing
                                break;
                        }
                    }
                }
                break;
            case "§r§2§lShop":
                e.setCancelled(true);

                break;
        }
//        if (e.getInventory().getName().equals("§aMenu")) {
//            e.setCancelled(true);
//            if (e.getCurrentItem() != null) {
//                ItemStack stack = e.getCurrentItem();
//                Player player = (Player) e.getWhoClicked();
//                switch (stack.getItemMeta().getDisplayName()) {
//                    case "Shop":
//
//                        break;
//                    case "Team Items":
//
//                        break;
//                    case "Trade/Present":
//
//                        break;
//                    case "Pickup Death Items":
//                        ContentLocationData toRemove = null;
//                        for (ContentLocationData contentLocationData : GlobalInstances.contentLocationDataList) {
//                            if (player.getLocation().getBlockX() == contentLocationData.getLocation().getBlockX() && player.getLocation().getBlockZ() == contentLocationData.getLocation().getBlockZ()) {
//                                for (ItemStack itemStack : contentLocationData.getItemStacks()) {
//                                    if (itemStack != null) {
////                                        player.getInventory().addItem(itemStack);
//                                        player.getWorld().dropItem(player.getLocation(), itemStack);
//                                    }
//                                }
//                                toRemove = contentLocationData;
//                                player.sendMessage("Die Items sind gedropt.");
//                            }
//                        }
//                        if (toRemove != null) {
//                            GlobalInstances.contentLocationDataList.remove(toRemove);
//                        }else{
//                            player.sendMessage("An deiner aktuellen Position ist kein Spieler gestorben.");
//                        }
//                        break;
//                    default:
//                        //do nothing
//                        break;
//                }
//            }
//        }
    }

}

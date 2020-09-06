package de.dirty.util;

import de.dirty.shop.ShopItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GlobalInstances implements Serializable {
    public static List<ContentLocationData> contentLocationDataList = new ArrayList<>();
    public static List<Team> teamList = new ArrayList<>();
    public static Inventory menu = Bukkit.createInventory(null, 9 * 3, "§r§2§lMenu");
    public static Inventory shop = Bukkit.createInventory(null, 9 * 3, "§r§2§lShop");

    public static void createInvs() {
        ItemStack fillItem = ItemStackBuilder.createNewItemStack(Material.THIN_GLASS, 1, (short) 0).setName("").build();
        //---
        for (int i = 0; i < menu.getSize(); i++) {
            menu.setItem(i, fillItem);
        }
        menu.setItem(10, ItemStackBuilder.createNewItemStack(Material.EMERALD, 1, (short) 0).setName("Shop").build());
        menu.setItem(12, ItemStackBuilder.createNewItemStack(Material.CHEST, 1, (short) 0).setName("Team Items").build());
        menu.setItem(14, ItemStackBuilder.createNewItemStack(Material.FEATHER, 1, (short) 0).setName("Trade/Present").build());
        menu.setItem(16, ItemStackBuilder.createNewItemStack(Material.SKULL_ITEM, 1, (short) 1).setName("Pickup Death Items").build());
        //---
        for (int i = 0; i < shop.getSize(); i++) {
            shop.setItem(i, fillItem);
        }
        int currentShopIndex = 10;
        for (ShopItems value : ShopItems.values()) {
            shop.setItem(currentShopIndex, ItemStackBuilder.createNewItemStack(value.getMaterial(), 1, value.getDamage()).setName(value.getDisplayName()).setLore("Price: " + value.getPrice() + "$").build());
            currentShopIndex += 2;
        }
        //---
    }
}

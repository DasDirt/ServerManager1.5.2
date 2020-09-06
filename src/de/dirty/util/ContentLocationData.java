package de.dirty.util;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;

public class ContentLocationData implements Serializable {
    private String playerUUID;
    private Location location;
    private ItemStack[] itemStacks;

    public ContentLocationData(String playerUUID, Location location, ItemStack[] itemStacks) {
        this.playerUUID = playerUUID;
        this.location = location;
        this.itemStacks = itemStacks;
    }

    public String getPlayerUUID() {
        return playerUUID;
    }

    public void setPlayerUUID(String playerUUID) {
        this.playerUUID = playerUUID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ItemStack[] getItemStacks() {
        return itemStacks;
    }

    public void setItemStacks(ItemStack[] itemStacks) {
        this.itemStacks = itemStacks;
    }
}

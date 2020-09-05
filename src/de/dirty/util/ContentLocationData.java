package de.dirty.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ContentLocationData {
    private Player player;
    private Location location;
    private ItemStack[] itemStacks;

    public ContentLocationData(Player player, Location location, ItemStack[] itemStacks) {
        this.player = player;
        this.location = location;
        this.itemStacks = itemStacks;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

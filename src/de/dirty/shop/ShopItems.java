package de.dirty.shop;

import org.bukkit.Material;

public enum ShopItems {
    TELEPORT_BASE(75, Material.BED, (short) 0, "Base TP"),
    TELEPORT_TO_PLAYER(150, Material.ENDER_PEARL, (short) 0, "Player TP"),
    TELEPORT_DEATH(200, Material.SKULL_ITEM, (short) 3, "Death TP"),
    TELEPORT_TO_PLAYER_FORCE(20000, Material.EYE_OF_ENDER, (short) 0, "Erz. Player TP");

    private final int price;
    private final Material material;
    private final short damage;
    private final String displayName;

    ShopItems(int price, Material material, short damage, String displayName) {
        this.price = price;
        this.material = material;
        this.damage = damage;
        this.displayName = displayName;
    }

    public int getPrice() {
        return price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Material getMaterial() {
        return material;
    }

    public short getDamage() {
        return damage;
    }
}

package de.dirty.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder {
    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public static ItemStackBuilder createNewItemStack(Material material, int amount, short damage) {
        ItemStack stack = new ItemStack(material, amount, damage);
        return new ItemStackBuilder(stack, stack.getItemMeta());
    }

    public ItemStackBuilder(ItemStack itemStack, ItemMeta itemMeta) {
        this.itemStack = itemStack;
        this.itemMeta = itemMeta;
    }

    public ItemStackBuilder setName(String name) {
        itemMeta.setDisplayName(name);
        return this;
    }

    public ItemStackBuilder setLore(String... loren) {
        List<String> lore = new ArrayList<>();
        for (String s : loren) {
            if (s != null) {
                lore.add(s);
            }
        }
        itemMeta.setLore(lore);
        return this;
    }

    public ItemStack build() {
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}

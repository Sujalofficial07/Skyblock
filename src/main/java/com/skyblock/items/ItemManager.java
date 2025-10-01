package com.skyblock.items;

import com.skyblock.SkyBlockPlugin;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemManager {
    private final SkyBlockPlugin plugin;

    public ItemManager(SkyBlockPlugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack createSkySword() {
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = sword.getItemMeta();
        meta.setDisplayName("§6SkySword");
        meta.setLore(Arrays.asList("§7A custom sword", "§7Damage: +50"));
        sword.setItemMeta(meta);
        return sword;
    }
}

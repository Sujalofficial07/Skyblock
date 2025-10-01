package com.skyblock.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIManager implements Listener {
    private final String MENU_NAME = "§aSkyBlock Menu";

    public GUIManager(com.skyblock.SkyBlockPlugin plugin) {
        // Register in main plugin
    }

    public void openMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 9, MENU_NAME);
        inv.setItem(4, new ItemStack(Material.EMERALD));
        player.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(MENU_NAME)) {
            e.setCancelled(true);
            if (e.getSlot() == 4) {
                e.getWhoClicked().sendMessage("§aYou clicked the emerald!");
            }
        }
    }
}

package com.skyblock;

import org.bukkit.plugin.java.JavaPlugin;
import com.skyblock.core.DBManager;
import com.skyblock.economy.EconomyManager;
import com.skyblock.islands.IslandManager;
import com.skyblock.gui.GUIManager;
import com.skyblock.items.ItemManager;

public class SkyBlockPlugin extends JavaPlugin {
    private static SkyBlockPlugin instance;
    private DBManager db;
    private EconomyManager economy;
    private IslandManager islands;
    private GUIManager gui;
    private ItemManager items;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        db = new DBManager(this, getConfig());
        db.connect();

        economy = new EconomyManager(this);
        islands = new IslandManager(this);
        gui = new GUIManager(this);
        items = new ItemManager(this);

        getCommand("island").setExecutor(islands.getCommand());
        getServer().getPluginManager().registerEvents(gui, this);

        getLogger().info("SkyBlock plugin enabled!");
    }

    @Override
    public void onDisable() {
        if (db != null) db.close();
        getLogger().info("SkyBlock plugin disabled!");
    }

    public static SkyBlockPlugin get() { return instance; }
    public DBManager getDb() { return db; }
    public EconomyManager getEconomy() { return economy; }
    public IslandManager getIslands() { return islands; }
    public GUIManager getGui() { return gui; }
    public ItemManager getItems() { return items; }
}

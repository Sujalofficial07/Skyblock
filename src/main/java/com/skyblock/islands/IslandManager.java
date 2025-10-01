package com.skyblock.islands;

import com.skyblock.SkyBlockPlugin;

public class IslandManager {
    private final SkyBlockPlugin plugin;
    private final IslandCommand command;

    public IslandManager(SkyBlockPlugin plugin) {
        this.plugin = plugin;
        this.command = new IslandCommand(this);
    }

    public IslandCommand getCommand() {
        return command;
    }

    public void createIsland(org.bukkit.entity.Player player) {
        player.sendMessage("§aIsland created!");
        // TODO: implement island logic
    }

    public void teleportHome(org.bukkit.entity.Player player) {
        player.sendMessage("§aTeleported to your island!");
        // TODO: teleport player
    }

    public void resetIsland(org.bukkit.entity.Player player) {
        player.sendMessage("§cIsland reset!");
        // TODO: reset logic
    }
}

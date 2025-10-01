package com.skyblock.islands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IslandCommand implements CommandExecutor {
    private final IslandManager islands;

    public IslandCommand(IslandManager islands) {
        this.islands = islands;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("§eUse /island create | home | reset");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "create": islands.createIsland(player); break;
            case "home": islands.teleportHome(player); break;
            case "reset": islands.resetIsland(player); break;
            default: player.sendMessage("§cUnknown subcommand!");
        }
        return true;
    }
}

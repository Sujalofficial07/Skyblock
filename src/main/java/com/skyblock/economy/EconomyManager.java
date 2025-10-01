package com.skyblock.economy;

import com.skyblock.SkyBlockPlugin;

import java.util.HashMap;
import java.util.UUID;

public class EconomyManager {
    private final SkyBlockPlugin plugin;
    private final HashMap<UUID, Double> balances = new HashMap<>();

    public EconomyManager(SkyBlockPlugin plugin) {
        this.plugin = plugin;
    }

    public double getBalance(UUID uuid) {
        return balances.getOrDefault(uuid, 0.0);
    }

    public void deposit(UUID uuid, double amount) {
        balances.put(uuid, getBalance(uuid) + amount);
    }

    public boolean withdraw(UUID uuid, double amount) {
        if (getBalance(uuid) >= amount) {
            balances.put(uuid, getBalance(uuid) - amount);
            return true;
        }
        return false;
    }
}

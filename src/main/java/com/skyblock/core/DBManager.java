package com.skyblock.core;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    private final HikariDataSource ds;

    public DBManager(JavaPlugin plugin, FileConfiguration cfg) {
        HikariConfig hc = new HikariConfig();
        hc.setJdbcUrl(cfg.getString("database.url", "jdbc:mysql://localhost:3306/skyblock"));
        hc.setUsername(cfg.getString("database.user", "root"));
        hc.setPassword(cfg.getString("database.pass", ""));
        hc.setMaximumPoolSize(cfg.getInt("database.pool", 5));
        ds = new HikariDataSource(hc);
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public void close() {
        ds.close();
    }

    public void connect() {
        try (Connection c = getConnection()) {
            // test connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

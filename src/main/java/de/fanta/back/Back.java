package de.fanta.back;

import de.iani.cubesideutils.bukkit.commands.CommandRouter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Back extends JavaPlugin {

    private static Back plugin;
    private static Map<Player, Location> lastLocation = new HashMap<>();

    @Override
    public void onEnable() {
        plugin = this;

        CommandRouter commandRouter = new CommandRouter(plugin.getCommand("back"));
        commandRouter.addCommandMapping(new BackCommand(this));

        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    public static Back getPlugin() {
        return plugin;
    }

    public Map<Player, Location> getLastLocationMap() {
        return lastLocation;
    }
}

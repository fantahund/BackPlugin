package de.fanta.back;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerListener implements Listener {

    private final Back plugin = Back.getPlugin();

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e) {
        if (plugin.getLastLocationMap().get(e.getPlayer()) != null) {
            plugin.getLastLocationMap().remove(e.getPlayer());
        }
        plugin.getLastLocationMap().put(e.getPlayer(), e.getFrom());
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (plugin.getLastLocationMap().get(e.getPlayer()) != null) {
            plugin.getLastLocationMap().remove(e.getPlayer());
        }
        plugin.getLastLocationMap().put(e.getPlayer(), e.getEntity().getLocation());

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (plugin.getLastLocationMap().get(e.getPlayer()) != null) {
            plugin.getLastLocationMap().remove(e.getPlayer());
        }
    }
}

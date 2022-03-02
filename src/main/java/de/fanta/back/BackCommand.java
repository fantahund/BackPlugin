package de.fanta.back;

import de.iani.cubesideutils.bukkit.commands.SubCommand;
import de.iani.cubesideutils.commands.ArgsParser;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BackCommand extends SubCommand {

    private final Back plugin;

    public BackCommand(Back plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String s1, ArgsParser argsParser) {
        if (!(commandSender instanceof Player player)) {
            commandSender.sendMessage("You are not a Player :>");
            return true;
        }

        if (!player.hasPermission("back.back")) {
            player.sendMessage(ChatColor.RED + "Keine Rechte!");
            return true;
        }

        Location lastlocation = plugin.getLastLocationMap().get(player);
        if (lastlocation == null) {
            player.sendMessage(ChatColor.RED + "Es gibt keine Letzte Position!");
            return true;
        }

        player.teleport(lastlocation);
        player.sendMessage(ChatColor.GREEN + "Du wurdest, an die letzte Position teleportieret.");

        return true;
    }
}

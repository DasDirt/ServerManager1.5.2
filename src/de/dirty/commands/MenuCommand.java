package de.dirty.commands;

import de.dirty.util.ContentLocationData;
import de.dirty.util.GlobalInstances;
import de.dirty.util.ItemStackBuilder;
import de.dirty.util.Team;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            Team playerTeam = null;
            for (Team team : GlobalInstances.teamList) {
                if (team.getMember().contains(player.getUniqueId().toString())) {
                    playerTeam = team;
                    break;
                }
            }
            ContentLocationData firstContentLocationData = null;
            for (ContentLocationData contentLocationData : GlobalInstances.contentLocationDataList) {
                if (contentLocationData.getPlayerUUID().equals(player.getUniqueId().toString())) {
                    firstContentLocationData = contentLocationData;
                }
            }
            GlobalInstances.menu.setItem(4, ItemStackBuilder.createNewItemStack(Material.BOOK_AND_QUILL, 1, (short) 0).setName("Information's").setLore(playerTeam != null ? "Team: " + playerTeam.getName() : "Du bist in keinen Team", playerTeam != null ? "Team Balance: " + playerTeam.getBalance() : null, firstContentLocationData != null ? "First Death: " + firstContentLocationData.getLocation().getBlockX() + " " + firstContentLocationData.getLocation().getBlockY() + " " + firstContentLocationData.getLocation().getBlockZ() : null).build());
            player.openInventory(GlobalInstances.menu);
            //player.sendMessage("Menu Opened");
        } else {
            commandSender.sendMessage("This command can only be executed as Player");
        }
        return false;
    }
}

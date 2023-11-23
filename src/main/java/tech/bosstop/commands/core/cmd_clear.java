package tech.bosstop.commands.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import tech.bosstop.commands.MKECommand;

public class cmd_clear extends MKECommand {

    public cmd_clear() {
        super("clear");
    }

    @Override
    public String getDescription() {
        return "Clears all potion effects from the player.";
    }

    @Override
    public String getUsage() {
        return "/mke clear <player>";
    }

    @Override
    public String getPermission() {
        return "mke.command.clear";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!isPlayer(sender)) return true;

        Player target = null;

        if(args.length == 0) {
            target = (Player) sender;
        } else {
            target = instance.getServer().getPlayer(args[0]);
        }

        if(target == null) {
            chat.send(sender, "&4Player not found.");
            return true;
        }

        Collection<PotionEffect> effects = target.getActivePotionEffects();

        if(effects.isEmpty()) {
            chat.send(sender, "&7" + target.getName() + " &adoes not have any potion effects.");
            return true;
        }

        for(PotionEffect effect : effects) {
            target.removePotionEffect(effect.getType());
        }

        chat.send(sender, "&aCleared all potion effects from &7" + target.getName() + "&a.");
        return true;
    }

    @Override
    public List<String> onTab(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 1) {
            List<String> tabList = new ArrayList<String>();

            instance.getServer().getOnlinePlayers().forEach((player) -> {
                tabList.add(player.getName());
            });
            
            return tabList;
        }

        return new ArrayList<String>();
    }
    
    
}

package tech.bosstop.commands.core;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tech.bosstop.commands.MKECommand;

public class cmd_info extends MKECommand {
    
    public cmd_info() {
        super("info");
    }

    @Override
    public String getDescription() {
        return "Displays a plugin info.";
    }

    @Override
    public String getUsage() {
        return "/mke info";
    }

    @Override
    public String getPermission() {
        return "mke.command.info";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String[] info = {
            "&aMobKillEffects &7v" + instance.getDescription().getVersion(),
            "&7Developed by Sir Blob",
            "&7Source code: &ahttps://github.com/Bosstop-Studios/MobKillEffects"
        };

        for (String line : info) {
            chat.send(sender, line);
        }

        return true;
    }

    @Override
    public List<String> onTab(CommandSender sender, Command command, String label, String[] args) {
        return new ArrayList<String>();
    }
}

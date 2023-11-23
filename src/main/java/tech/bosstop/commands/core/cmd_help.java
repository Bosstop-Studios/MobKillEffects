package tech.bosstop.commands.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import tech.bosstop.commands.MKECommand;

public class cmd_help extends MKECommand {

    public cmd_help() {
        super("help");
    }

    @Override
    public String getDescription() {
        return "Displays a list of commands.";
    }

    @Override
    public String getUsage() {
        return "/mke help";
    }

    @Override
    public String getPermission() {
        return "mke.command.help";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        HashMap<String, MKECommand> commands = instance.getCommandHandler().getMkeCommands();

        chat.send(sender, "&aMobKillEffects Commands:");

        for (String cmd : commands.keySet()) {
            chat.send(sender, "&a/mke " + cmd + " &7- " + commands.get(cmd).getDescription());
        }

        return true;
    }

    @Override
    public List<String> onTab(CommandSender sender, Command command, String label, String[] args) {
        return new ArrayList<String>();
    }
}

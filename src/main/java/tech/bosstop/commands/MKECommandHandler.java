package tech.bosstop.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import tech.bosstop.MobKillEffects;
import tech.bosstop.commands.core.cmd_clear;
import tech.bosstop.commands.core.cmd_help;
import tech.bosstop.commands.core.cmd_info;


public class MKECommandHandler implements CommandExecutor, TabCompleter {

    private final MobKillEffects instance = MobKillEffects.getInstance();
    
    private HashMap<String, MKECommand> mkeCommands = new HashMap<>();

    public MKECommandHandler() {
        instance.getCommand("mobkilleffects").setExecutor(this::onCommand);
        instance.getCommand("mobkilleffects").setTabCompleter(this::onTabComplete);
    }

    private String[] removeFirst(String[] args) {
        String[] newArgs = new String[args.length - 1];
        System.arraycopy(args, 1, newArgs, 0, args.length - 1);
        return newArgs;
    }

    public void registerCommand(String command, MKECommand mkeCommands) {
        this.mkeCommands.put(command, mkeCommands);
    }

    public void register() {

        new cmd_clear();
        new cmd_help();
        new cmd_info();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length == 0) return true;
        if(this.mkeCommands.containsKey(args[0])) {
            if (this.mkeCommands.get(args[0]).getPermission() != null) {
                if (!commandSender.hasPermission(this.mkeCommands.get(args[0]).getPermission())) {
                    instance.getChat().send(commandSender, "&4You don't have permission to use this command.");
                    return true;
                }
            }
            return this.mkeCommands.get(args[0]).onCommand(commandSender, command, s, this.removeFirst(args));
        } else {
            instance.getChat().send(commandSender, "&4Unknown command. Type &6/bw help &4for help.");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> tabList = new ArrayList<>();
        if(args.length == 1) {
            tabList.addAll(this.mkeCommands.keySet());
        } else {
            if(this.mkeCommands.containsKey(args[0])) {
                tabList = this.mkeCommands.get(args[0]).onTab(commandSender, command, s, this.removeFirst(args));
            }
        }
        if(tabList.size() == 0) return null;
        return tabList;
    }

    public HashMap<String, MKECommand> getMkeCommands() {
        return this.mkeCommands;
    }
}
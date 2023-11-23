package tech.bosstop;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import tech.bosstop.commands.MKECommandHandler;
import tech.bosstop.event.onKill;
import tech.bosstop.util.Chat;

public class MobKillEffects extends JavaPlugin {

    private static MobKillEffects instance;
    
    private YamlConfiguration config;

    private Chat chat;

    private MKECommandHandler commandHandler;

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        instance = this;
        chat = new Chat();
        commandHandler = new MKECommandHandler();

        try {
            config = YamlConfiguration.loadConfiguration(new File(this.getDataFolder(), "config.yml"));
            commandHandler.register();
            registerEvents();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.chat.console("&aMobKillEffects has been enabled.");
        }
    }

    private void registerEvents() {
        new onKill();
    }

    public YamlConfiguration getConfig() {
        return config;
    }

    public Chat getChat() {
        return chat;
    }

    public MKECommandHandler getCommandHandler() {
        return commandHandler;
    }

    public static MobKillEffects getInstance() {
        return instance;
    }
}

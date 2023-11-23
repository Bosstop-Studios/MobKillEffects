package tech.bosstop.event;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import tech.bosstop.MobKillEffects;

public class MKEEvent implements Listener {
    
    protected MobKillEffects instance;

    public MKEEvent() {
        super();
        this.instance = MobKillEffects.getInstance();
        Bukkit.getPluginManager().registerEvents(this, instance);
    }
}

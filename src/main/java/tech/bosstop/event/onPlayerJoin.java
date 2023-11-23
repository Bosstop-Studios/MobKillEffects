package tech.bosstop.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoin extends MKEEvent {

    public onPlayerJoin() {
        super();
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        instance.getChat().send(event.getPlayer(), "&6Mob Kill Effects Enabled!");
        instance.getChat().send(event.getPlayer(), "&aUse /mke to view commands!");
        instance.getChat().send(event.getPlayer(), "&5Killing a mob will give you a random effect!");
    }
    
}

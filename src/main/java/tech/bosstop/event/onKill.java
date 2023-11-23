package tech.bosstop.event;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class onKill extends MKEEvent {
 
    public onKill() {
        super();
    }
    
    @EventHandler
    public void onEntityDeathEvent(EntityDeathEvent event) {

        LivingEntity entity = event.getEntity();
        Player killer = event.getEntity().getKiller();

        if (killer instanceof Player && entity instanceof Mob) {
            int random = (int) (Math.random() * 33);
            PotionEffect effect = new PotionEffect(PotionEffectType.values()[random], instance.getConfig().getInt("potionEffect_time") * 20, 1);

            killer.addPotionEffect(effect);
        }
    }

}

package sandtechnology.antianything.listener.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SpawnerSpawnEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.util.ConfigUtil.isPresent;

public class SpawnerSpawnListener implements Listener {
    @EventHandler
    public void onSpawnerSpawn(SpawnerSpawnEvent event){
        if (isPresent(getPlugin(), event.getSpawner().getWorld().getName(), "nospawnerspawn")) {
            event.setCancelled(true);
        }
    }
}

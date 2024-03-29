package sandtechnology.antianything.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.util.ConfigUtil.isPresent;
import static sandtechnology.antianything.util.MessageUtil.sendIfPresent;

public class PlayerDropListener implements Listener {
    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        if (isPresent(getPlugin(), event.getPlayer().getWorld().getName(), "nodrop")) {
            if(!event.getPlayer().hasPermission("antianything.drop")) {
                sendIfPresent(event.getPlayer(), "nodrop");
                event.setCancelled(true);
            }
        }
    }
}



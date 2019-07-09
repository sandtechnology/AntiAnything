package sandtechnology.antianything.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.until.ConfigUtil.Present;
import static sandtechnology.antianything.until.MessageUtil.sendIfPresent;

public class PlayerThrowListener implements Listener {

    @EventHandler
    public void onPlayerThrow(ProjectileLaunchEvent event) {
        if (event.getEntity().getShooter() instanceof Player && Present(getPlugin(), event.getEntity().getWorld().getName(), "nothrow")) {
            if (!((Player) event.getEntity().getShooter()).hasPermission("antianything.throw")) {
                sendIfPresent((Player) event.getEntity().getShooter(), "nothrow");
                event.setCancelled(true);
            }
        }
    }
}

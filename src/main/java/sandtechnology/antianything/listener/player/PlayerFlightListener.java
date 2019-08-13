package sandtechnology.antianything.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.util.ConfigUtil.isPresent;
import static sandtechnology.antianything.util.MessageUtil.sendIfPresent;

public class PlayerFlightListener  implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (event.getPlayer().isFlying() && isPresent(getPlugin(), event.getPlayer().getWorld().getName(), "nofly")) {
            if (!event.getPlayer().hasPermission("antianything.fly")) {
                sendIfPresent(event.getPlayer(), "nofly");
                event.getPlayer().setFlying(false);
            }
        }
    }

    @EventHandler
    public void onPlayerFlight(PlayerToggleFlightEvent event) {
        if (event.isFlying() && isPresent(getPlugin(), event.getPlayer().getWorld().getName(), "nofly")) {
            if (!event.getPlayer().hasPermission("antianything.fly")) {
                sendIfPresent(event.getPlayer(), "nofly");
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent event) {
        if (event.getPlayer().isFlying() && isPresent(getPlugin(), event.getPlayer().getWorld().getName(), "nofly")) {
            if (!event.getPlayer().hasPermission("antianything.fly")) {
                sendIfPresent(event.getPlayer(), "nofly");
                event.getPlayer().setFlying(false);
            }
        }
    }
}

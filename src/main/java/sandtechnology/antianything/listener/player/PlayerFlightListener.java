package sandtechnology.antianything.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.until.ConfigUtil.Present;
import static sandtechnology.antianything.until.MessageUtil.sendIfPresent;

public class PlayerFlightListener  implements Listener {
    @EventHandler
    public void onPlayerFlight(PlayerToggleFlightEvent event) {
        if (event.isFlying() && Present(getPlugin(), event.getPlayer().getWorld().getName(), "nofly")) {
            if (!event.getPlayer().hasPermission("antianything.fly")) {
                sendIfPresent(event.getPlayer(), "nofly");
                event.setCancelled(true);
            }
        }
    }
}

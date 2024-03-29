package sandtechnology.antianything.listener.weather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.WorldLoadEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.util.ConfigUtil.isPresent;

public class WeatherListener implements Listener {

    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event){
        if (event.toWeatherState() && isPresent(getPlugin(), event.getWorld().getName(), "norain")) {
            event.setCancelled(true);
        }
    }
    @EventHandler
    public void onWorldLoad(WorldLoadEvent event){
        if (event.getWorld().hasStorm() && isPresent(getPlugin(), event.getWorld().getName(), "norain")) {
            event.getWorld().setStorm(false);
        }
        if (event.getWorld().isThundering() && isPresent(getPlugin(), event.getWorld().getName(), "norain")) {
            event.getWorld().setThundering(false);
        }
    }
}

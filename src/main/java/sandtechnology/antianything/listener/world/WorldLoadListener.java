package sandtechnology.antianything.listener.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.util.ConfigUtil.Present;

public class WorldLoadListener  implements Listener {
    @EventHandler
    public void onWorldLoad(WorldLoadEvent event){
        if(event.getWorld().getPVP()&&Present(getPlugin(),event.getWorld().getName(),"nopvp")){
            event.getWorld().setPVP(false);
        }
    }
}

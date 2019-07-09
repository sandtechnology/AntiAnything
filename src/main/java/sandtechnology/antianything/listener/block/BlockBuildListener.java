package sandtechnology.antianything.listener.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.until.ConfigUtil.Present;
import static sandtechnology.antianything.until.MessageUtil.sendIfPresent;

public class BlockBuildListener implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(Present(getPlugin(),event.getPlayer().getWorld().getName(),"nobuild")){
            if(!event.getPlayer().hasPermission("antianything.build")) {
                sendIfPresent(event.getPlayer(), "nobuild");
                event.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if(Present(getPlugin(),event.getPlayer().getWorld().getName(),"nobuild")){
            if(!event.getPlayer().hasPermission("antianything.build")) {
                sendIfPresent(event.getPlayer(), "nobuild");
                event.setCancelled(true);
            }
        }
    }

}

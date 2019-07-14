package sandtechnology.antianything.listener.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.util.ConfigUtil.Present;

public class BlockFadeListener implements Listener {
    @EventHandler
    public void onBlockFade(BlockFadeEvent event){
        if(Present(getPlugin(),event.getBlock().getWorld().getName(),"nofade")){
            event.setCancelled(true);
        }
    }
}

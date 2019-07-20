package sandtechnology.antianything.listener.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.LeavesDecayEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.util.ConfigUtil.isPresent;

public class BlockFadeListener implements Listener {
    @EventHandler
    public void onBlockFade(BlockFadeEvent event){
        if (isPresent(getPlugin(), event.getBlock().getWorld().getName(), "nofade")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onLeaveDecay(LeavesDecayEvent event) {
        if (isPresent(getPlugin(), event.getBlock().getWorld().getName(), "nofade")) {
            event.setCancelled(true);
        }
    }
}

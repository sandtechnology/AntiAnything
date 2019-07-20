package sandtechnology.antianything.listener.block;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;

import static sandtechnology.antianything.AntiAnything.getPlugin;
import static sandtechnology.antianything.util.ConfigUtil.isPresent;
import static sandtechnology.antianything.util.MessageUtil.sendIfPresent;

public class BlockBuildListener implements Listener {


    private boolean canBuild(Player player) {
        if (player.hasPermission("antianything.build")) {
            return true;
        }
        else {
            sendIfPresent(player, "nobuild");
            return false;
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if (isPresent(getPlugin(), event.getPlayer().getWorld().getName(), "nobuild")
                && !canBuild(event.getPlayer())) {
                event.setCancelled(true);
            }
        }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
        if (isPresent(getPlugin(), event.getPlayer().getWorld().getName(), "nobuild")
                && !canBuild(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFillBucket(PlayerBucketFillEvent event) {
        if (isPresent(getPlugin(), event.getPlayer().getWorld().getName(), "nobuild")
                && !canBuild(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onEmptyBucket(PlayerBucketEmptyEvent event) {
        if (isPresent(getPlugin(), event.getPlayer().getWorld().getName(), "nobuild")
                && !canBuild(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

}

package sandtechnology.antianything;

import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import sandtechnology.antianything.listener.block.BlockBuildListener;
import sandtechnology.antianything.listener.block.BlockFadeListener;
import sandtechnology.antianything.listener.entity.SpawnerSpawnListener;
import sandtechnology.antianything.listener.player.PlayerDropListener;
import sandtechnology.antianything.listener.player.PlayerFlightListener;
import sandtechnology.antianything.listener.player.PlayerThrowListener;
import sandtechnology.antianything.listener.weather.WeatherListener;
import sandtechnology.antianything.listener.world.WorldLoadListener;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

import static sandtechnology.antianything.command.CommandHandler.getCommandHandler;
import static sandtechnology.antianything.util.ConfigUtil.getStringOrElse;

public class AntiAnything extends JavaPlugin {

    private HashMap<String, String> messageMap = new HashMap<>();
    private HashMap<String, Listener> listenerMap = new HashMap<>();
    private static AntiAnything plugin;


    public HashMap<String, String> getMessageMap() {
        return messageMap;
    }

    public static AntiAnything getPlugin() {
        if (plugin != null) {
            return plugin;
        }
        else throw new IllegalStateException("插件尚未加载成功！");
    }

    public static void reload() {
        HandlerList.unregisterAll(getPlugin());
        getPlugin().listenerMap.clear();
        getPlugin().reloadConfig();
        getPlugin().load();
    }


    private void load() {
        listenerMap.put("nobuild", new BlockBuildListener());
        listenerMap.put("nofade", new BlockFadeListener());
        listenerMap.put("nospawnerspawn", new SpawnerSpawnListener());
        listenerMap.put("nodrop", new PlayerDropListener());
        listenerMap.put("nofly", new PlayerFlightListener());
        listenerMap.put("nothrow", new PlayerThrowListener());
        listenerMap.put("norain", new WeatherListener());
        listenerMap.put("nopvp", new WorldLoadListener());
        messageMap = getConfig().getConfigurationSection("Messages").getKeys(false).stream()
                .collect(Collectors.toMap(
                        x -> x,
                        x -> getStringOrElse(String.join(".", "Messages", x), ""),
                        (x, y) -> x,
                        HashMap::new));
        HashSet<String> enableList=getConfig().getConfigurationSection("Worlds").getKeys(false).stream().flatMap(x->getConfig().getStringList(String.join(".", "Worlds", x)).stream()).collect(Collectors.toCollection(HashSet::new));
        listenerMap.keySet().retainAll(enableList);
        listenerMap.forEach((x, listener) -> getServer().getPluginManager().registerEvents(listener, this));
    }

    @Override
    public void onEnable() {
        try {
            plugin = this;
            saveDefaultConfig();
        getLogger().info("正在注册监听器...");
        load();
        getLogger().info("正在注册命令...");
            getCommand("AntiAnything").setExecutor(getCommandHandler());
            getCommand("AntiAnything").setTabCompleter(getCommandHandler());
            getLogger().info("命令注册成功！");
            getLogger().info("插件已启用！");
        }
        catch (Exception ex) {
            setEnabled(false);
            throw new RuntimeException("插件加载失败！");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("插件正在卸载...");
    }
}

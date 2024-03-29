package sandtechnology.antianything.util;

import sandtechnology.antianything.AntiAnything;

import static sandtechnology.antianything.AntiAnything.getPlugin;

public class ConfigUtil {
    private ConfigUtil(){}

    public static boolean isPresent(AntiAnything plugin, String world, String type) {
        return plugin.getConfig().getStringList(String.join(".","Worlds",world)).contains(type);
    }
    public static String getStringOrElse(String path,String defaults){
        return getPlugin().getConfig().isSet(path) ? getPlugin().getConfig().getString(path) : defaults;
    }
}

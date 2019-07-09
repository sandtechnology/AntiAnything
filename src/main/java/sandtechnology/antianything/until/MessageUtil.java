package sandtechnology.antianything.until;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

import static sandtechnology.antianything.AntiAnything.getPlugin;

public class MessageUtil {
    private MessageUtil(){}


    public static void sendMessage(CommandSender sender, ChatColor color, String message, Object... format) {
        sender.sendMessage(ChatColor.GREEN+"[AntiEverything] " + color + String.format(message, format));
    }

    public static void sendIfPresent(CommandSender sender,String langKey){
        HashMap<String,String> mapping=getPlugin().getMessageMap();
       if(mapping.keySet().contains(langKey)&&!mapping.get(langKey).equals("")){
           sendMessage(sender,ChatColor.RED,mapping.get(langKey));
       }
    }

}

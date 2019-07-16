package sandtechnology.antianything.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import static sandtechnology.antianything.util.MessageUtil.sendMessage;

public class PermissionUtil {
    private PermissionUtil() {
    }

    public static boolean hasPermission(CommandSender sender, String permission) {
        if (sender.hasPermission(permission)) {
            return true;
        }
        else {
            sendMessage(sender, ChatColor.RED, "你没有使用此命令的权限");
            return false;
        }
    }
}

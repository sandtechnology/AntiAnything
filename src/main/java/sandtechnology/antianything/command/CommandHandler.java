package sandtechnology.antianything.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

import static sandtechnology.antianything.AntiAnything.reload;
import static sandtechnology.antianything.util.MessageUtil.sendMessage;
import static sandtechnology.antianything.util.PermissionUtil.hasPermission;

public class CommandHandler implements TabCompleter, CommandExecutor {
    private static CommandHandler commandHandler = new CommandHandler();

    private CommandHandler() {
    }

    public static CommandHandler getCommandHandler() {
        return commandHandler;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1)
            return Arrays.asList("reload", "help");
        return null;

    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            switch (args[0]) {
                case "reload":
                    if (hasPermission(sender, "antianything.command.reload")) {
                        sendMessage(sender, ChatColor.GREEN, "插件配置重载中...");
                        reload();
                        sendMessage(sender, ChatColor.GREEN, "重载成功！");
                        return true;
                    }
                    break;
                case "help":
                    if (hasPermission(sender, "antianything.command.help")) {
                        sendMessage(sender, ChatColor.YELLOW, "插件帮助：");
                        sendMessage(sender, ChatColor.YELLOW, "/aa reload——重载插件配置");
                        sendMessage(sender, ChatColor.YELLOW, "/aa help——查看帮助");
                        return true;
                    }
                    break;
                default:
                    //无匹配命令
                    sendMessage(sender, ChatColor.RED, "命令无效，输入/aa help查看帮助");
                    return true;
            }
        }
        else {
            //命令格式不对
            sendMessage(sender, ChatColor.RED, "命令无效，输入/aa help查看帮助");
        }
        return true;
    }
}

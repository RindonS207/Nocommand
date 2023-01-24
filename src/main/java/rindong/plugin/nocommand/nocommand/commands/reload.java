package rindong.plugin.nocommand.nocommand.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import rindong.plugin.nocommand.nocommand.NoCommand;

import java.util.ArrayList;
import java.util.List;

public class reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (!sender.hasPermission("nocommand.admin"))
        {
            sender.sendMessage("你没有权限那样做");
            return false;
        }
        if (args.length == 1)
        {
            if (args[0].equals("reload"))
            {
                System.out.println(NoCommand.pluginName + "插件已重载。");
                sender.sendMessage("插件已重载。");
                importsettings();
            }
            else
            {
                sender.sendMessage("参数错误");
            }
        }
        else
        {
            sender.sendMessage("参数错误。");
        }
        return false;
    }

    public  static  void  importsettings()
    {
        NoCommand.nocommands.clear();
        NoCommand.nocommands_world.clear();
        Plugin file= NoCommand.getProvidingPlugin(NoCommand.class);
        file.reloadConfig();
        FileConfiguration config=file.getConfig();
        NoCommand.nocommands = config.getStringList("commands");
        for (String x : NoCommand.nocommands)
        {
            List<String> world_name=new ArrayList<>();
            for (String i : config.getStringList(x))
            {
                world_name.add(i.toUpperCase());
            }
            NoCommand.nocommands_world.put(x.toUpperCase(),world_name);
        }
    }
}

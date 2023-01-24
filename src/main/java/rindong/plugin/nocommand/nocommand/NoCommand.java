package rindong.plugin.nocommand.nocommand;

import org.bukkit.plugin.java.JavaPlugin;
import rindong.plugin.nocommand.nocommand.Listener.listener;
import rindong.plugin.nocommand.nocommand.commands.reload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class NoCommand extends JavaPlugin {

    public static String pluginName = "[禁用指令]";
    public static List<String> nocommands=new ArrayList<>();
    //key：指令 value：禁止的世界名
    public static Map<String,List<String>> nocommands_world=new HashMap<>();

    @Override
    public void onEnable() {

        saveDefaultConfig();

        System.out.println(pluginName + "插件已启用");

        getServer().getPluginManager().registerEvents(new listener(),this);

        getCommand("nocommand").setExecutor(new reload());

        reload.importsettings();
    }

    @Override
    public void onDisable() {

        System.out.println(pluginName + "插件已卸载");

    }


}

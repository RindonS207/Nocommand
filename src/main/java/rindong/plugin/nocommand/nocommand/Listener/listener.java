package rindong.plugin.nocommand.nocommand.Listener;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import rindong.plugin.nocommand.nocommand.NoCommand;

public class listener implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void chatE(PlayerCommandPreprocessEvent event)
    {
        if (NoCommand.nocommands.size() != 0)
        {
            if (event.getPlayer().hasPermission("nocommand.bypass"))
            {
                return;
            }
            for (String x : NoCommand.nocommands)
            {
                if (event.getMessage().toUpperCase().contains(x.toUpperCase()))
                {
                    if (NoCommand.nocommands_world.get(x.toUpperCase()).get(0).equals("*"))
                    {
                        event.setCancelled(true);
                        event.getPlayer().sendMessage(ChatColor.RED + "你不能那样做。");
                        return;
                    }
                    else
                    {
                        for (String worldName : NoCommand.nocommands_world.get(x.toUpperCase()))
                        {
                            if (event.getPlayer().getWorld().getName().toUpperCase().equals(worldName))
                            {
                                event.setCancelled(true);
                                event.getPlayer().sendMessage(ChatColor.RED + "你不能那样做。");
                                break;
                            }
                        }
                        return;
                    }
                }
            }
        }
    }
}

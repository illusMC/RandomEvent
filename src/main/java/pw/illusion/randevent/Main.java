package pw.illusion.randevent;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import pw.illusion.randevent.events.EventStart;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().addDefault("tickRate","30");
        getConfig().options().copyDefaults(true);
        getDataFolder().mkdir();
        saveDefaultConfig();
        reloadConfig();;
        getLogger().info("Starting!!");
        EventManager.getInstance().getDefaultRunner().runTaskTimerAsynchronously(this,0,getConfig().getInt("tickRate")*20);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            return false;
        }
        Bukkit.getPluginManager().callEvent(new EventStart(args[0]));
        return true;
    }
}

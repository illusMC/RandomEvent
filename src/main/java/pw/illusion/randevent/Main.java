package pw.illusion.randevent;

import org.bukkit.plugin.java.JavaPlugin;

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
}

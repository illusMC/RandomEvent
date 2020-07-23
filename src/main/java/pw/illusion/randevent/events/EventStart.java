package pw.illusion.randevent.events;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import pw.illusion.randevent.Main;
import sun.misc.Unsafe;
import sun.reflect.Reflection;

public class EventStart extends Event implements Cancellable {
    @Getter
    private String eventName;
    private boolean cancelled=false;
    private final HandlerList handlers=new HandlerList();
    public EventStart(String name){
        super(true);
        if(!Reflection.getCallerClass().getCanonicalName().equals("pw.illusion.randevent.Runner")){
            Main.getPlugin(Main.class).getLogger().warning("EventStart called by a firer which isn't Runner!");
        }
        eventName=name;
    }
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled=cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}

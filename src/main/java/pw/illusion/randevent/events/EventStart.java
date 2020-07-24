package pw.illusion.randevent.events;

import lombok.Getter;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EventStart extends Event implements Cancellable {
    @Getter
    private String eventName;
    private boolean cancelled=false;
    private final HandlerList handlers=new HandlerList();
    public EventStart(String name){
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

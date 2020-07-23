package pw.illusion.randevent;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class EventManager {
    @Getter
    private static final EventManager instance=new EventManager();
    private final Map<Integer,Runner> specialTickRates=new HashMap<>();
    @Getter(AccessLevel.PROTECTED)
    private final Runner defaultRunner=new Runner();
    private EventManager(){

    }
    public void registerRandEvent(String name, Callable<Boolean> condition){
        defaultRunner.getEvents().put(name,condition);
    }
    public void unregisterRandEvent(String name){
        defaultRunner.getEvents().remove(name);
    }

    public void registerRandEvent(String name, Callable<Boolean> condition, int tickRate){
        if(!specialTickRates.containsKey(tickRate)){
              specialTickRates.put(tickRate,new Runner());
              specialTickRates.get(tickRate).runTaskTimerAsynchronously(Main.getPlugin(Main.class),0L,tickRate);
        }
        specialTickRates.get(tickRate).getEvents().put(name,condition);
    }
    public void unregisterRandEvent(String name,int tickRate){
        if(!specialTickRates.containsKey(tickRate)){
            return;
        }
        specialTickRates.remove(tickRate);
    }
}

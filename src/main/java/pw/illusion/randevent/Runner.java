package pw.illusion.randevent;

import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import pw.illusion.randevent.events.EventStart;

import java.util.*;
import java.util.concurrent.Callable;

public class Runner extends BukkitRunnable {
    @Getter
    private Map<String, Callable<Boolean>> events=new HashMap<>();
    private final static Random random=new Random();

    @SneakyThrows
    @Override
    public void run() {
        List<String> names=new ArrayList<>(events.keySet());
        String name=names.get(random.nextInt(names.size()));
        if(events.get(name).call()){
            Bukkit.getPluginManager().callEvent(new EventStart(name));
        }
    }
}

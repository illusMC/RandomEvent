# Basic usage
```java
import pw.illusion.randomevent.EventManager;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;

public class Example extends JavaPlugin implements Listener{
    @Override
    public void onEnable(){
        EventManager.registerRandEvent("EventName",()->{
            if(new Random().nextInt(10)>5)return true;
            return false;
        });
    }
    @EventHandler
    public void onRandEvent(EventStart evt){
        if(evt.getEventName().equals("EventName")){
            getLogger().info("OMG IT FIRED!");
        }
    }
}
```
..or custom tickRate
```java
EventManager.registerRandEvent("EventName",()->{
            if(new Random().nextInt(10)>5)return true;
            return false;
        },20);
```
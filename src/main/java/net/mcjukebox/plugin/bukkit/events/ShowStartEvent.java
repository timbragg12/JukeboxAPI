package net.mcjukebox.plugin.bukkit.events;

import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by Daniel on 18/10/2016.
 */
public class ShowStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    private String name;

    public ShowStartEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}

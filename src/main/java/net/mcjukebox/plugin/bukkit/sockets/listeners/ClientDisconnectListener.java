package net.mcjukebox.plugin.bukkit.sockets.listeners;

import io.socket.emitter.Emitter;
import net.mcjukebox.plugin.bukkit.MCJukebox;
import net.mcjukebox.plugin.bukkit.api.JukeboxAPI;
import net.mcjukebox.plugin.bukkit.events.ClientConnectEvent;
import net.mcjukebox.plugin.bukkit.events.ClientDisconnectEvent;
import net.mcjukebox.plugin.bukkit.managers.shows.Show;
import net.mcjukebox.plugin.bukkit.managers.shows.ShowManager;
import net.mcjukebox.plugin.bukkit.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientDisconnectListener implements Emitter.Listener {

	@Override
	public void call(Object... objects) {
			JSONObject data = (JSONObject) objects[0];
		try {
			ClientDisconnectEvent event = new ClientDisconnectEvent(
					data.getString("username"), data.getLong("timestamp"));
			MCJukebox.getInstance().getServer().getPluginManager().callEvent(event);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		try {
            if (Bukkit.getPlayer(data.getString("username")) == null) return;
            MessageUtils.sendMessage(Bukkit.getPlayer(data.getString("username")), "event.clientDisconnect");
        } catch (JSONException e) {
            e.printStackTrace();
        }
	}

}

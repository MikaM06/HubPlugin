package mika.olicube.hub.Listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import mika.olicube.hub.Main;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player player = e.getPlayer();
        Main.getInstance().getScoreboardManager().onLogout(player);

        User user = LuckPermsProvider.get().getUserManager().getUser(player.getName());
        if (user != null) {
            String prefix = user.getCachedData().getMetaData().getPrefix();

            assert prefix != null;

            e.setQuitMessage("§7[ §4✖ §7] " + prefix.replace('&', '§') + player.getName());
        }
    }
}

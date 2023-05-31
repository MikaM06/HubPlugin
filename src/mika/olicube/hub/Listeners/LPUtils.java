package mika.olicube.hub.Listeners;

import org.bukkit.entity.Player;

public class LPUtils {
    public static boolean isPlayerInGroup(Player p, String group) {
        return p.hasPermission("group." + group);
    }
}

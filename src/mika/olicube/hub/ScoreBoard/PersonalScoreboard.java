package mika.olicube.hub.ScoreBoard;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;


public class PersonalScoreboard {
    private Player player;
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;

    PersonalScoreboard(Player player){
        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "Hub");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData(){}

    public void setLines(String ip){
        objectiveSign.setDisplayName("§3§lHub");

        objectiveSign.setLine(0, "§e» §7" + player.getName());
        objectiveSign.setLine(1, "§r");
        objectiveSign.setLine(2, PlaceholderAPI.setPlaceholders(player," §7Grade: %luckperms_groups%"));
        objectiveSign.setLine(3, " §7Argent :" + " §c§l§osoon...");
        objectiveSign.setLine(4, "§r");
        objectiveSign.setLine(6, "§e» §7Joueur » "  + Bukkit.getOnlinePlayers().size() );
        objectiveSign.setLine(7, ip);

        objectiveSign.updateLines();
    }

    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}
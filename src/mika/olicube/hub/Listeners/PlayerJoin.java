package mika.olicube.hub.Listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import mika.olicube.hub.ItemBuilder.ItemBuilder;
import mika.olicube.hub.Main;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        //Action action = event.getAction();
        Main.getInstance().getScoreboardManager().onLogin(player);
        player.getInventory().clear();

        // Item Menu

        // ---------------------------
        // CHOIX DE JEUX
        // ---------------------------

        ItemBuilder JEUX = new ItemBuilder(Material.NETHER_STAR, 1).setName("§f§l» §b§lMenu Principal");
        player.getInventory().setItem(4, JEUX.toItemStack());

        // ---------------------------
        // PROFILE
        // ---------------------------

        ItemBuilder PROFIL = new ItemBuilder(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal()).setSkullOwner(player.getName()).setName("§f§l» §aProfil").setLore("§7§m---------------------", "", "§a⚫ §7Pseudo: §e" + player.getName(), "§a⚫" + PlaceholderAPI.setPlaceholders(player," §7Grade: %luckperms_groups%"), "§a⚫ §7Crystal: §cSoon...", "", "§7§m---------------------");
        player.getInventory().setItem(0, PROFIL.toItemStack());

        // ---------------------------
        // BOUTIQUE
        // ---------------------------

        ItemBuilder BOUTIQUE = new ItemBuilder(Material.EMERALD, 1).setName("§f§l» §e§lBoutique");
        player.getInventory().setItem(8, BOUTIQUE.toItemStack());

        // ---------------------------
        // COSMETIQUE
        // ---------------------------

        //ItemBuilder COSMETIQUE = new ItemBuilder(Material.CHEST, 1).setName("§f§l» §lCosmétiques");
        //player.getInventory().setItem(7, COSMETIQUE.toItemStack());

        // ---------------------------
        // JOUEUR
        // ---------------------------

        // ItemBuilder PLAYER_NOT_VISIBLE = new ItemBuilder(Material.INK_SACK, 1, (byte)1).setName("§f§l» §e§lJoueurs §7- §c§lCaché");
        ItemBuilder PLAYER_VISIBLE = new ItemBuilder(Material.INK_SACK, 1, (byte)10).setName("§f§l» §e§lJoueurs §7- §a§lVisible"); //PAR DEFAUT JOUEURS VISIBLES
        player.getInventory().setItem(1, PLAYER_VISIBLE.toItemStack());

        // Message/Event de Join

        User user = LuckPermsProvider.get().getUserManager().getUser(player.getName());
        if (user != null) {
            String prefix = user.getCachedData().getMetaData().getPrefix();

            assert prefix != null;

            e.setJoinMessage("§7[ §a✔ §7] " + prefix.replace('&', '§') + player.getName());
            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1f, 1f);
        }
    }
}

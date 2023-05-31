package mika.olicube.hub.InvManager;

// CLASS GUI

import me.clip.placeholderapi.PlaceholderAPI;
import mika.olicube.hub.ItemBuilder.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InvManager {

    public Inventory GAME(Player p){
        Inventory inv = Bukkit.createInventory(null, 27, "§f§l» §6Jeux");

        ItemBuilder STAINED = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)0).setName(" ");

        ItemBuilder PROFIL = new ItemBuilder(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal()).setSkullOwner(p.getName()).setName("§f§l» §aProfil").setLore("§7§m---------------------", "", "§a⚫ §7Pseudo: §e" + p.getName(), "§a⚫" + PlaceholderAPI.setPlaceholders(p," §7Grade: %luckperms_groups%"), "§a⚫ §7Crystal: §cSoon...", "", "§7§m---------------------");

        ItemBuilder HUNGER = new ItemBuilder(Material.DIAMOND_SWORD, 1).setName("§f§l» §bHungerSwap").setLore("§7§m----------------------------", "", "§7» §rCréateur: §3§lMikaM06", "§7» §rDescriptions: Ce mini jeux est repris", "§rdu mode jeux célébre du Hungergames/Pvp Swap", "§rMais il y a une grosse différence.", "§rVous changez d'arêne tout les 5 minutes avec des gadgets ajouté.", "", "§7§m----------------------------");
        ItemBuilder OPIWATER = new ItemBuilder(Material.GRASS, 1).setName("§f§l» §eOneWater").setLore("§7§m----------------------------", "", "§7» §fCréateur: §3§lIglée42", "§7» §fVersion: §c§l1.19.2", "", "§7§m----------------------------");
        ItemBuilder LOBBY = new ItemBuilder(Material.NETHER_STAR, 1).setName("§f§l» §e§lHub");

        ItemBuilder CLOSE = new ItemBuilder(Material.BARRIER, 1).setName("§f§l» §cFermer");

        inv.setItem(0, STAINED.toItemStack());
        inv.setItem(1, STAINED.toItemStack());
        inv.setItem(2, STAINED.toItemStack());
        inv.setItem(3, STAINED.toItemStack());

        inv.setItem(4, PROFIL.toItemStack());

        inv.setItem(5, STAINED.toItemStack());

        inv.setItem(6, STAINED.toItemStack());
        inv.setItem(7, STAINED.toItemStack());
        inv.setItem(8, STAINED.toItemStack());
        inv.setItem(9, STAINED.toItemStack());

        inv.setItem(10, HUNGER.toItemStack());

        inv.setItem(11, STAINED.toItemStack());

        inv.setItem(12, OPIWATER.toItemStack());

        inv.setItem(13, STAINED.toItemStack());
        inv.setItem(14, STAINED.toItemStack());
        inv.setItem(15, STAINED.toItemStack());
        inv.setItem(16, STAINED.toItemStack());
        inv.setItem(17, STAINED.toItemStack());
        inv.setItem(18, STAINED.toItemStack());
        inv.setItem(19, STAINED.toItemStack());
        inv.setItem(20, STAINED.toItemStack());
        inv.setItem(21, STAINED.toItemStack());
        inv.setItem(22, LOBBY.toItemStack());
        inv.setItem(23, STAINED.toItemStack());
        inv.setItem(24, STAINED.toItemStack());
        inv.setItem(25, STAINED.toItemStack());

        inv.setItem(26, CLOSE.toItemStack());
        return inv;
    }
    public Inventory BOUTIQUE(Player p){
        Inventory inv_boutique = Bukkit.createInventory(null, 27, "§f§l» §e§lBoutique");

        // ItemBuilder STAINED = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)0).setName(" ");

        ItemBuilder PROFIL = new ItemBuilder(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal()).setSkullOwner(p.getName()).setName("§f§l» §aProfil").setLore("§7§m---------------------", "", "§a⚫ §7Pseudo: §e" + p.getName(), "§a⚫" + PlaceholderAPI.setPlaceholders(p," §7Grade: %luckperms_groups%"), "§a⚫ §7Crystal: §cSoon...", "", "§7§m---------------------");

        ItemBuilder CLOSE = new ItemBuilder(Material.BARRIER, 1).setName("§f§l» §cFermer");

        inv_boutique.setItem(4, PROFIL.toItemStack());

        inv_boutique.setItem(22, CLOSE.toItemStack());

        return inv_boutique;
    }
    public Inventory PROFILE(Player p){
        Inventory inv_profil = Bukkit.createInventory(null, 27, "§f§l» §a§lProfil");

        // ItemBuilder STAINED = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)0).setName(" ");

        ItemBuilder PROFILE = new ItemBuilder(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal()).setSkullOwner(p.getName()).setName("§f§l» §aProfil").setLore("§7§m---------------------", "", "§a⚫ §7Pseudo: §e" + p.getName(), "§a⚫" + PlaceholderAPI.setPlaceholders(p," §7Grade: %luckperms_groups%"), "§a⚫ §7Crystal: §cSoon...", "", "§7§m---------------------");

        ItemBuilder CLOSE = new ItemBuilder(Material.BARRIER, 1).setName("§f§l» §cFermer");

        inv_profil.setItem(4, PROFILE.toItemStack());

        inv_profil.setItem(22, CLOSE.toItemStack());

        return inv_profil;
    }
    public Inventory HUB(Player p){
        Inventory inv_hub = Bukkit.createInventory(null, 27, "§f§l» §c§lHub");

        // ItemBuilder STAINED = new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (byte)0).setName(" ");

        ItemBuilder RETOUR = new ItemBuilder(Material.BARRIER, 1).setName("§f§l» §cRetour");

        inv_hub.setItem(22, RETOUR.toItemStack());

        return inv_hub;
    }
}

package mika.olicube.hub.Listeners.EventManager;

import mika.olicube.hub.InvManager.InvManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIJeuxManager implements Listener {

    InvManager invManager = new InvManager();

    @EventHandler
    public void GUIJeux(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        Inventory inventory = e.getInventory();
        ItemStack it = e.getCurrentItem();

        if (it == null) return;

        if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && inventory.getTitle().equalsIgnoreCase("§f§l» §6Jeux")) {
            switch (it.getType()){
                case SKULL_ITEM:
                   if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §aProfil")){
                       e.setCancelled(true);
                   }
                case NETHER_STAR:
                    if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §e§lHub")){
                        e.setCancelled(true);
                        p.openInventory(invManager.HUB(p));
                    }
                case DIAMOND_SWORD:
                    if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §bHungerSwap")){
                        e.setCancelled(true);
                    }
                case GRASS:
                    if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §eOneWater")){
                        e.setCancelled(true);
                    }
                case BARRIER:
                    if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §cFermer")){
                        e.setCancelled(true);
                        p.closeInventory();
                    }
                case STAINED_GLASS_PANE:
                    if(it.getItemMeta().getDisplayName().equalsIgnoreCase(" ")){
                        e.setCancelled(true);
                    }
            }
        }
    }
}

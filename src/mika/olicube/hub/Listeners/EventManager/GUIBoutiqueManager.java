package mika.olicube.hub.Listeners.EventManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIBoutiqueManager implements Listener {
    @EventHandler
    public void GUIBoutique(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        Inventory inventory = e.getInventory();
        ItemStack it = e.getCurrentItem();

        if (it == null) return;

        if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && inventory.getTitle().equalsIgnoreCase("§f§l» §e§lBoutique")) {
            switch (it.getType()) {
                case SKULL_ITEM:
                    if (it.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §aProfil")) {
                        e.setCancelled(true);
                    }
                case BARRIER:
                    if(it.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §cFermer")){
                        e.setCancelled(true);
                        p.closeInventory();
                    }
            }
        }
    }
}
package mika.olicube.hub.Listeners.EventManager;

import mika.olicube.hub.InvManager.InvManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUIHubManager implements Listener {

    InvManager invManager = new InvManager();

    @EventHandler
    public void GUIHubManager(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inventory = e.getInventory();
        ItemStack it = e.getCurrentItem();

        if (it == null) return;

        if (e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && inventory.getTitle().equalsIgnoreCase("§f§l» §c§lHub")) {
            switch (it.getType()) {
                case BARRIER:
                    if (it.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §cRetour")) {
                        e.setCancelled(true);
                        p.openInventory(invManager.GAME(p));
                    }
            }
        }
    }
}

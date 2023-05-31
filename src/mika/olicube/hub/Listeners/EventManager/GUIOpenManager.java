package mika.olicube.hub.Listeners.EventManager;

import mika.olicube.hub.InvManager.InvManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class GUIOpenManager implements Listener {

    InvManager invManager = new InvManager();

    @EventHandler
    public void onInteractJeux(PlayerInteractEvent e){
        final Player p = e.getPlayer();
        final ItemStack itemStack = e.getItem();
        final Action action = e.getAction();

        if(itemStack.getItemMeta() == null) return;

        if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §b§lMenu principal")) {
                p.openInventory(invManager.GAME(p));
            }
            if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §aProfil")) {
                e.setCancelled(true);
                p.openInventory(invManager.PROFILE(p));
            }
            if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §e§lBoutique")) {
                e.setCancelled(true);
                p.openInventory(invManager.BOUTIQUE(p));
            }
            if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase("§f§l» §e§lJoueurs §7- §a§lVisible")) {
                e.setCancelled(true);
                p.sendMessage("§cLa vision des joueurs sont actuellement en développement !");
            }
        }
    }
}

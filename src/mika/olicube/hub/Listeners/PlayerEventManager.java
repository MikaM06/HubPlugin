package mika.olicube.hub.Listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerEventManager implements Listener {

    @EventHandler
    public void onClickInventory(InventoryClickEvent e){
        if(!e.getWhoClicked().isOp()) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        if(!e.getPlayer().isOp()) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(!e.getPlayer().isOp()) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity().getType() == EntityType.PLAYER) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        final Player p = e.getPlayer();
        if(!p.isOp()) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e){
        final Player p = e.getPlayer();
        if(!p.isOp()) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onFood(FoodLevelChangeEvent e){
        final Player p = (Player) e.getEntity();

        e.setFoodLevel(20);
        e.setCancelled(true);
    }
}

package dev.glowie.forceItemName.listener;

import dev.glowie.forceItemName.util.NamerUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class PickupListener implements Listener {

    @EventHandler (ignoreCancelled = true)
    public void onPickup(PlayerPickupItemEvent e) {
        ItemStack i = e.getItem().getItemStack();
        if (NamerUtil.isItemUnnamed(i)) {
            return;
        }
        if (!NamerUtil.isMaterialNamable(i.getType())) {
            return;
        }
        NamerUtil.renameItem(i);
    }

}

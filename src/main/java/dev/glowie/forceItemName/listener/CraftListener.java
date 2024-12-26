package dev.glowie.forceItemName.listener;

import dev.glowie.forceItemName.util.NamerUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class CraftListener implements Listener {

    @EventHandler (ignoreCancelled = true)
    public void onCraftPrepare(PrepareItemCraftEvent e) {
        ItemStack i = e.getInventory().getResult();

        if (i == null) {
            return;
        }

        if (NamerUtil.isItemUnnamed(i)) {
            return;
        }
        if (!NamerUtil.isMaterialNamable(i.getType())) {
            return;
        }
        NamerUtil.renameItem(i);
    }

}

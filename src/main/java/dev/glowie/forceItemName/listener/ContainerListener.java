package dev.glowie.forceItemName.listener;

import dev.glowie.forceItemName.util.NamerUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ContainerListener implements Listener {

    @EventHandler (ignoreCancelled = true)
    public void onChest(InventoryOpenEvent e) {
        for (@Nullable ItemStack i : e.getInventory().getContents()) {
            if (i != null && i.getType() != Material.AIR) {
                if (NamerUtil.isItemUnnamed(i)) {
                    return;
                }
                if (!NamerUtil.isMaterialNamable(i.getType())) {
                    return;
                }
                NamerUtil.renameItem(i);
            }

        }
    }

}

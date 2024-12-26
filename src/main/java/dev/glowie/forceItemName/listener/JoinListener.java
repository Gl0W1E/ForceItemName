package dev.glowie.forceItemName.listener;

import dev.glowie.forceItemName.util.NamerUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class JoinListener implements Listener {

    @EventHandler (ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent e) {
        for (int slot = 0; slot<=35; slot++) {
            ItemStack i = e.getPlayer().getInventory().getItem(slot);
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

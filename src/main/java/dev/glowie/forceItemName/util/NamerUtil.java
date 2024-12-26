package dev.glowie.forceItemName.util;

import dev.glowie.forceItemName.ForceItemName;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NamerUtil {

    public static FileConfiguration getConfig() {
        return ForceItemName.getInstance().getConfig();
    }

    public static boolean isItemUnnamed(ItemStack i) {
        return i.getItemMeta().hasDisplayName();
    }

    public static boolean isMaterialNamable(Material m) {
        return getConfig().contains(m.toString().toLowerCase());
    }

    public static String getSupposedName(Material m) {
        return getConfig().getString(m.toString().toLowerCase());
    }

    public static void renameItem(ItemStack i) {
        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName("§r" + getSupposedName(i.getType()));
        i.setItemMeta(meta);
    }

}

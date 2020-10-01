package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.ArsUtils;

public class ArsItems {

    public static final Item COOKED_CLAY_TABLET = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item CLAY_TABLET = new Item(new FabricItemSettings().group(ItemGroup.MISC));

    public static void registerAll() {
        registerItem(COOKED_CLAY_TABLET, "cooked_clay_tablet");
        registerItem(CLAY_TABLET, "clay_tablet");
    }

    public static Item registerItem(Item item, String name) {
        return Registry.register(Registry.ITEM, ArsUtils.getIdentifier(name), item);
    }

}
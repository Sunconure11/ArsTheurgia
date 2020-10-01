package team.comofas.arstheurgia.events;

import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import team.comofas.arstheurgia.registry.ArsItems;

public class LootTableEvent {

    private static final Identifier DESERT_PYRAMID_ID = new Identifier("minecraft", "chests/desert_pyramid");

    public static void register() {
        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            System.out.println(id.getPath());
            if (DESERT_PYRAMID_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootTableRange.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25F))
                        .withEntry(ItemEntry.builder(ArsItems.COOKED_CLAY_TABLET).build());

                supplier.pool(poolBuilder);
            }
        });
    }
}
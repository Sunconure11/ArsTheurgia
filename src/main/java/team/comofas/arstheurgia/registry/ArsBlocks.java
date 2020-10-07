package team.comofas.arstheurgia.registry;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.util.registry.Registry;
import team.comofas.arstheurgia.blocks.ChalkBlock;
import team.comofas.arstheurgia.blocks.RitualBlockEntityRenderer;
import team.comofas.arstheurgia.blocks.ritualblocktest.RitualBlock;
import team.comofas.arstheurgia.ArsUtils;
import team.comofas.arstheurgia.blocks.RitualBlockEntity;


public class ArsBlocks {

    public static final Block RITUALCENTER = new RitualBlock(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
    public static final Block ASYRIEL_SIGIL = new ChalkBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block SPRING_SYMBOL = new ChalkBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block SUMMER_SYMBOL = new ChalkBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block AUTUMN_SYMBOL = new ChalkBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static final Block WINTER_SYMBOL = new ChalkBlock(FabricBlockSettings.of(Material.METAL).hardness(1.0f));
    public static BlockEntityType<RitualBlockEntity> RITUALBLOCK_ENTITY;

    public static void registerAll() {
        registerBlock(ASYRIEL_SIGIL, "asyriel_sigil_chalk");
        registerBlock(SPRING_SYMBOL, "spring_symbol_chalk");
        registerBlock(SUMMER_SYMBOL, "summer_symbol_chalk");
        registerBlock(AUTUMN_SYMBOL, "autumn_symbol_chalk");
        registerBlock(WINTER_SYMBOL, "winter_symbol_chalk");
        registerBlock(RITUALCENTER, "ritual_block");
        RITUALBLOCK_ENTITY = registerBlockEntity(RITUALCENTER, "ritual_block");

    }
    public static Block registerBlock(Block block, String name) {
        return Registry.register(Registry.BLOCK, ArsUtils.getIdentifier(name), block);
    }
    public static BlockEntityType registerBlockEntity(Block block, String name) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, ArsUtils.getIdentifier(name), BlockEntityType.Builder.create(RitualBlockEntity::new, block).build(null));
    }
}
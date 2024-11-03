package dev.definedentity.definedsblocks.blocks

import com.tterrag.registrate.providers.RegistrateRecipeProvider.has
import dev.definedentity.definedsblocks.DefinedsBlocks
import dev.definedentity.definedsblocks.DefinedsBlocks.Companion.REGISTRATE
import dev.definedentity.definedsblocks.registry.BlockRegistry
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.block.SlabBlock

object DBBlocks {
    val FUTURE_BLOCK = BlockRegistry.legacyBlock("future_block", FutureBlock())
    val UNDEFINED_BLOCK = REGISTRATE.block("undefined_block", ::Block).lang("Undefined Block").simpleItem()
        .properties { p -> p.strength(1.0f).requiresCorrectToolForDrops() }.recipe { ctx, prov ->
            ShapedRecipeBuilder.shaped(ctx.get(), 8).pattern("XYX").pattern("YXY").pattern("XYX")
                .define('X', Blocks.STONE).define('Y', Items.IRON_INGOT).unlockedBy("has_item", has(Items.STONE))
                .save(prov)
        }.register()

    val LIVINGROCK = BlockRegistry.block("livingrock", ::Block)
    val LIVINGROCK_BRICKS = BlockRegistry.block("livingrock_bricks", ::Block)
    val LIVINGROCK_SLATE = BlockRegistry.block("livingrock_slate", ::Block)
    val POLISHED_LIVINGROCK = BlockRegistry.block("polished_livingrock", ::Block)
    val POLISHED_LIVINGROCK_SLAB =
        BlockRegistry.slab("polished_livingrock_slab", "polished_livingrock_slab", "polished_livingrock", ::SlabBlock)
    val MOSSY_LIVINGROCK_BRICKS = BlockRegistry.block("mossy_livingrock_bricks", ::Block)
    val CHISELED_LIVINGROCK_BRICKS = BlockRegistry.block("chiseled_livingrock_bricks", ::Block)
    val CRACKED_LIVINGROCK_BRICKS = BlockRegistry.block("cracked_livingrock_bricks", ::Block)

    val LIVINGWOOD_PLANKS = BlockRegistry.block("livingwood_planks", ::Block)
    val LIVINGWOOD_SLAB = BlockRegistry.slab("livingwood_slab", "livingwood_planks", "livingwood_planks", ::SlabBlock)
    val MOSSY_LIVINGWOOD_PLANKS = BlockRegistry.block("mossy_livingwood_planks", ::Block)
    val PATTERN_FRAMED_LIVVINGWOOD = BlockRegistry.block("pattern_framed_livingwood", ::Block)
    val LIVINGWOOD_LOG = BlockRegistry.log("livingwood_log", ::RotatedPillarBlock)
    val STRIPPED_LIVINGWOOD_LOG = BlockRegistry.log("stripped_livingwood_log", ::RotatedPillarBlock)

    val DREAMWOOD_PLANKS = BlockRegistry.block("dreamwood_planks", ::Block)
    val DREAMWOOD_LOG = BlockRegistry.log("dreamwood_log", ::RotatedPillarBlock)
    val STRIPPED_DREAMWOOD_LOG = BlockRegistry.log("stripped_dreamwood_log", ::RotatedPillarBlock)
    val MOSSY_DREAMWOOD_PLANKS = BlockRegistry.block("mossy_dreamwood_planks", ::Block)

    fun init() {
        REGISTRATE.addRawLang("block.${DefinedsBlocks.MOD_ID}.future_block", "Future Block")

        DefinedsBlocks.LOGGER.info("Registering blocks...")
    }
}

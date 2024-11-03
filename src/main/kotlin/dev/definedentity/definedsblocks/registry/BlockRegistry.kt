package dev.definedentity.definedsblocks.registry

import com.tterrag.registrate.util.entry.BlockEntry
import dev.definedentity.definedsblocks.DefinedsBlocks
import dev.definedentity.definedsblocks.DefinedsBlocks.Companion.REGISTRATE
import dev.definedentity.definedsblocks.utils.DBIdentifier
import dev.definedentity.definedsblocks.utils.TextFormatting
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.core.Registry
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.crafting.StonecutterRecipe
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.block.SlabBlock
import net.minecraft.world.level.block.StairBlock
import net.minecraft.world.level.block.state.BlockBehaviour

object BlockRegistry {
    fun <T : StairBlock> stairs(
        name: String, englishName: String, blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier).lang(englishName).simpleItem().blockstate({ ctx, prov ->
            prov.stairsBlock(
                ctx.get(),
                prov.modLoc("block/${name}"),
            )
        }).register()
    }

    fun <T : StairBlock> stairs(
        name: String, blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return stairs(name, TextFormatting.toEnglishName(name), blockSupplier)
    }

    fun <T : RotatedPillarBlock> log(
        name: String, englishName: String, blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier).lang(englishName).simpleItem().blockstate({ ctx, prov ->
            prov.logBlock(
                ctx.get()
            )
        }).register()
    }

    fun <T : RotatedPillarBlock> log(
        name: String, blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return log(name, TextFormatting.toEnglishName(name), blockSupplier)
    }

    fun <T : SlabBlock> slab(
        name: String,
        englishName: String,
        slabTexture: String,
        fullBlockTexture: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier).lang(englishName).simpleItem().blockstate({ ctx, prov ->
            prov.slabBlock(
                ctx.get(), prov.modLoc("block/${fullBlockTexture}"), prov.modLoc("block/${slabTexture}")
            )
        }).register()
    }

    fun <T : SlabBlock> slab(
        name: String, slabTexture: String, fullBlockTexture: String, blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return slab(name, TextFormatting.toEnglishName(name), slabTexture, fullBlockTexture, blockSupplier)
    }

    fun <T : Block> block(
        name: String, englishName: String, blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier).lang(englishName).simpleItem()
            .recipe { ctx, prov -> StonecutterRecipe() }.register()
    }

    fun <T : Block> block(
        name: String, blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return block(name, TextFormatting.toEnglishName(name), blockSupplier)
    }

    fun legacyBlock(name: String, block: Block): Block {
        ItemRegistry.legacyItem(name, BlockItem(block, FabricItemSettings().group(DefinedsBlocks.ITEM_GROUP)))
        return Registry.register(Registry.BLOCK, DBIdentifier(name), block)
    }
}
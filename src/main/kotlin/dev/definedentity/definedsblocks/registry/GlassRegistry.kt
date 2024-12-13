package dev.definedentity.definedsblocks.registry

import com.tterrag.registrate.util.DataIngredient
import com.tterrag.registrate.util.entry.BlockEntry
import dev.definedentity.definedsblocks.DefinedsBlocks.Companion.REGISTRATE
import dev.definedentity.definedsblocks.utils.TextFormatting
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material

object GlassRegistry {
    fun <T : Block> block(
        name: String,
        englishName: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.block(name, blockSupplier)
            .lang(englishName)
            .properties({ p -> p.strength(0.3f).sound(SoundType.GLASS).noOcclusion() })
            .initialProperties(Material.GLASS)
            .tag(BlockTags.IMPERMEABLE)
            .simpleItem()
            .recipe { ctx, prov ->
                prov.stonecutting(DataIngredient.stacks(Blocks.GLASS.asItem().defaultInstance)) {
                    ctx.get()
                }
            }
            .register()
    }

    fun <T : Block> block(
        name: String,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return block(name, TextFormatting.toEnglishName(name), blockSupplier)
    }
}

package dev.definedentity.definedsblocks.registry

import com.tterrag.registrate.util.DataIngredient
import com.tterrag.registrate.util.entry.BlockEntry
import dev.definedentity.definedsblocks.DefinedsBlocks.Companion.REGISTRATE
import dev.definedentity.definedsblocks.utils.TextFormatting
import net.minecraft.tags.BlockTags
import net.minecraft.util.StringRepresentable
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material

object MossBlockRegistry {
    enum class MossBlockType : StringRepresentable {
        STONE_BRICKS,
        DIRT,
        DEEPSLATE;

        override fun getSerializedName(): String? {
            return name
        }
    }

    fun <T : Block> block(
        name: String,
        englishName: String,
        type: MossBlockType,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return REGISTRATE.`object`(name)
            .block(blockSupplier)
            .lang(englishName)
            .simpleItem()
            .properties { p -> p.requiresCorrectToolForDrops().strength(1.5f, 6.0f) }
            .apply {
                when (type) {
                    MossBlockType.DIRT -> {
                        recipe { ctx, prov ->
                                prov.stonecutting(
                                    DataIngredient.stacks(Blocks.DIRT.asItem().defaultInstance)
                                ) {
                                    ctx.get()
                                }
                            }
                            .tag(BlockTags.DIRT, BlockTags.MINEABLE_WITH_SHOVEL)
                            .initialProperties(Material.DIRT)
                    }
                    MossBlockType.DEEPSLATE -> {
                        recipe { ctx, prov ->
                                prov.stonecutting(
                                    DataIngredient.stacks(Blocks.DEEPSLATE.asItem().defaultInstance)
                                ) {
                                    ctx.get()
                                }
                            }
                            .tag(BlockTags.STONE_BRICKS, BlockTags.MINEABLE_WITH_PICKAXE)
                            .initialProperties(Material.STONE)
                    }
                    MossBlockType.STONE_BRICKS -> {
                        recipe { ctx, prov ->
                                prov.stonecutting(
                                    DataIngredient.stacks(
                                        Blocks.MOSSY_STONE_BRICKS.asItem().defaultInstance
                                    )
                                ) {
                                    ctx.get()
                                }
                            }
                            .tag(BlockTags.STONE_BRICKS, BlockTags.MINEABLE_WITH_PICKAXE)
                            .initialProperties(Material.STONE)
                    }
                }
            }
            .register()
    }

    fun <T : Block> block(
        name: String,
        type: MossBlockType,
        blockSupplier: (BlockBehaviour.Properties) -> T
    ): BlockEntry<T> {
        return block(name, TextFormatting.toEnglishName(name), type, blockSupplier)
    }
}

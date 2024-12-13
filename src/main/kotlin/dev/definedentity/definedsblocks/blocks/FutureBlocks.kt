package dev.definedentity.definedsblocks.blocks

import com.tterrag.registrate.providers.RegistrateRecipeProvider.has
import dev.definedentity.definedsblocks.DefinedsBlocks.Companion.REGISTRATE
import dev.definedentity.definedsblocks.blocks.future_blocks.FutureBlock
import dev.definedentity.definedsblocks.utils.DBIdentifier
import dev.definedentity.definedsblocks.utils.TextFormatting
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.tags.BlockTags
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.material.Material

object FutureBlocks {
    val FUTURA_BLOCK =
        REGISTRATE.block(FutureBlock.ID, ::FutureBlock)
            .properties { p -> p.requiresCorrectToolForDrops().strength(1.5f, 6.0f) }
            .initialProperties(Material.STONE)
            .lang(TextFormatting.toEnglishName(FutureBlock.ID))
            .simpleItem()
            .blockstate { ctx, prov ->
                prov
                    .getVariantBuilder(ctx.get())
                    .partialState()
                    .with(FutureBlock.FUTURE_BLOCK_TYPE, FutureBlock.FutureBlockType.block)
                    .modelForState()
                    .modelFile(
                        prov
                            .models()
                            .getExistingFile(DBIdentifier("block/futura_block/futura_block_online"))
                    )
                    .addModel()
                    .partialState()
                    .with(FutureBlock.FUTURE_BLOCK_TYPE, FutureBlock.FutureBlockType.column_x)
                    .modelForState()
                    .modelFile(
                        prov
                            .models()
                            .getExistingFile(
                                DBIdentifier("block/futura_block/futura_block_column_online")
                            )
                    )
                    .rotationX(90)
                    .rotationY(90)
                    .addModel()
                    .partialState()
                    .with(FutureBlock.FUTURE_BLOCK_TYPE, FutureBlock.FutureBlockType.column_y)
                    .modelForState()
                    .modelFile(
                        prov
                            .models()
                            .getExistingFile(
                                DBIdentifier("block/futura_block/futura_block_column_online")
                            )
                    )
                    .addModel()
                    .partialState()
                    .with(FutureBlock.FUTURE_BLOCK_TYPE, FutureBlock.FutureBlockType.column_z)
                    .modelForState()
                    .modelFile(
                        prov
                            .models()
                            .getExistingFile(
                                DBIdentifier("block/futura_block/futura_block_column_online")
                            )
                    )
                    .rotationX(90)
                    .addModel()
            }
            .item()
            .model { ctx, prov ->
                prov.withExistingParent(
                    ctx.name,
                    DBIdentifier("block/futura_block/futura_block_online")
                )
            }
            .build()
            .recipe({ ctx, prov ->
                ShapedRecipeBuilder.shaped(ctx.get(), 8)
                    .pattern("XXX")
                    .pattern("XYX")
                    .pattern("XXX")
                    .define("X".toCharArray()[0], Blocks.STONE)
                    .define("Y".toCharArray()[0], Items.REDSTONE)
                    .unlockedBy("has_redstone", has(Items.REDSTONE))
                    .save(prov)
            })
            .tag(BlockTags.STONE_BRICKS, BlockTags.MINEABLE_WITH_PICKAXE)
            .register()

    fun init() {}
}

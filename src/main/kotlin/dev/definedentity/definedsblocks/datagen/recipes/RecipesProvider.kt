package dev.definedentity.definedsblocks.datagen.recipes

import dev.definedentity.definedsblocks.blocks.DBBlocks
import dev.definedentity.definedsblocks.blocks.FutureBlock
import dev.definedentity.definedsblocks.blocks.UndefinedBlock
import java.util.function.Consumer
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Blocks

class RecipesProvider(gen: FabricDataGenerator) : FabricRecipeProvider(gen) {
    override fun generateRecipes(exporter: Consumer<FinishedRecipe>) {
        ShapedRecipeBuilder.shaped(DBBlocks.BLOCKS.get(UndefinedBlock.ID)!!.asItem(), 16)
            .pattern("XYX")
            .pattern("YXY")
            .pattern("XYX")
            .define('X', Blocks.STONE)
            .define('Y', Items.IRON_INGOT)
            .unlockedBy("has_item", has(Items.STONE))
            .save(exporter)

        stonecutterResultFromBase(
            exporter,
            DBBlocks.BLOCKS.get(FutureBlock.ID)!!.asItem(),
            DBBlocks.BLOCKS.get(UndefinedBlock.ID)!!.asItem()
        )
    }
}

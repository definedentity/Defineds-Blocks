package dev.definedentity.definedsblocks.datagen

import dev.definedentity.definedsblocks.datagen.lang.EnglishProvider
import dev.definedentity.definedsblocks.datagen.loottables.LootTableProvider
import dev.definedentity.definedsblocks.datagen.models.ModelsProvider
import dev.definedentity.definedsblocks.datagen.recipes.RecipesProvider
import dev.definedentity.definedsblocks.datagen.tags.BlockTags
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

class DefinedsBlocksDataGen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        fabricDataGenerator.addProvider(::EnglishProvider)
        fabricDataGenerator.addProvider(::ModelsProvider)
        fabricDataGenerator.addProvider(::RecipesProvider)
        fabricDataGenerator.addProvider(::LootTableProvider)
        fabricDataGenerator.addProvider(::BlockTags)
    }
}

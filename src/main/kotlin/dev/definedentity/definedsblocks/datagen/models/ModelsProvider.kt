package dev.definedentity.definedsblocks.datagen.models

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.models.BlockModelGenerators
import net.minecraft.data.models.ItemModelGenerators

class ModelsProvider(gen: FabricDataGenerator) : FabricModelProvider(gen) {
    override fun generateBlockStateModels(blockStateModelGenerator: BlockModelGenerators) {
        TrivialCubes.init(blockStateModelGenerator)
    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerators) {}
}

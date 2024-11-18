package dev.definedentity.definedsblocks.datagen

import dev.definedentity.definedsblocks.DefinedsBlocks
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraftforge.common.data.ExistingFileHelper

class DefinedsBlocksDataGen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
        val helper = ExistingFileHelper.withResourcesFromArg()

        DefinedsBlocks.REGISTRATE.setupDatagen(fabricDataGenerator, helper)
    }
}

package dev.definedentity.definedsblocks.datagen.loottables

import dev.definedentity.definedsblocks.blocks.DBBlocks
import dev.definedentity.definedsblocks.blocks.FutureBlock
import dev.definedentity.definedsblocks.blocks.UndefinedBlock
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider

class LootTableProvider(gen: FabricDataGenerator) : FabricBlockLootTableProvider(gen) {
    override fun generateBlockLootTables() {
        dropSelf(DBBlocks.BLOCKS.get(FutureBlock.ID)!!)
        dropSelf(DBBlocks.BLOCKS.get(UndefinedBlock.ID)!!)
    }
}

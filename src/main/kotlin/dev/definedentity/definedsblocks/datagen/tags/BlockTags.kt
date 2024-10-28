package dev.definedentity.definedsblocks.datagen.tags

import dev.definedentity.definedsblocks.blocks.DBBlocks
import dev.definedentity.definedsblocks.blocks.FutureBlock
import dev.definedentity.definedsblocks.blocks.UndefinedBlock
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider
import net.minecraft.tags.BlockTags

class BlockTags(gen: FabricDataGenerator) : FabricTagProvider.BlockTagProvider(gen) {
    override fun generateTags() {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(DBBlocks.BLOCKS.get(UndefinedBlock.ID))
            .add(DBBlocks.BLOCKS.get(FutureBlock.ID))

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(DBBlocks.BLOCKS.get(UndefinedBlock.ID))
            .add(DBBlocks.BLOCKS.get(FutureBlock.ID))
    }
}

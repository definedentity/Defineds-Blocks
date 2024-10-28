package dev.definedentity.definedsblocks.datagen.models

import dev.definedentity.definedsblocks.blocks.DBBlocks
import net.minecraft.data.models.BlockModelGenerators

object TrivialCubes {
    fun init(gen: BlockModelGenerators) {
        DBBlocks.TRIVIAL_BLOCKS.forEach { gen.createTrivialCube(it.value) }
    }
}

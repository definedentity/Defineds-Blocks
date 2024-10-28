package dev.definedentity.definedsblocks.blocks

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.Material

class UndefinedBlock :
    Block(FabricBlockSettings.of(Material.STONE).requiresCorrectToolForDrops().strength(1.0f)) {
    companion object {
        val ID = "undefined_block"
    }
}

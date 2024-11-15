package dev.definedentity.definedsblocks.blocks

import dev.definedentity.definedsblocks.registry.MossBlockRegistry
import dev.definedentity.definedsblocks.registry.MossBlockRegistry.MossBlockType
import net.minecraft.world.level.block.Block

object MossyBlocks {
    val MOSSIER_STONE_BRICKS = MossBlockRegistry.block("mossier_stone_bricks", MossBlockType.STONE_BRICKS, ::Block)
    val FLOWERY_MOSSY_STONE_BRICKS = MossBlockRegistry.block("flowery_mossy_stone_bricks", MossBlockType.STONE_BRICKS, ::Block)
    val FLOWERY_MOSSIER_STONE_BRICKS = MossBlockRegistry.block("flowery_mossier_stone_bricks", MossBlockType.STONE_BRICKS, ::Block)

    val MOSSY_COARSE_DIRT = MossBlockRegistry.block("mossy_coarse_dirt", MossBlockType.DIRT, ::Block)
    val FLOWERY_MOSSY_COARSE_DIRT = MossBlockRegistry.block("flowery_mossy_coarse_dirt", MossBlockType.DIRT, ::Block)

    val MOSSY_DEEPSLATE_TILES = MossBlockRegistry.block("mossy_deepslate_tiles", MossBlockType.DEEPSLATE, ::Block)
    val FLOWERY_MOSSY_DEEPSLATE_TILES = MossBlockRegistry.block("flowery_mossy_deepslate_tiles", MossBlockType.DEEPSLATE, ::Block)

    val MOSSY_DEEPSLATE_BRICKS = MossBlockRegistry.block("mossy_deepslate_bricks", MossBlockType.DEEPSLATE, ::Block)
    val FLOWERY_MOSSY_DEEPSLATE_BRICKS = MossBlockRegistry.block("flowery_mossy_deepslate_bricks", MossBlockType.DEEPSLATE, ::Block)

    fun init() {}
}
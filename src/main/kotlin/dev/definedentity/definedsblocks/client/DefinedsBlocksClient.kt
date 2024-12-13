package dev.definedentity.definedsblocks.client

import dev.definedentity.definedsblocks.blocks.FutureBlocks
import dev.definedentity.definedsblocks.blocks.GlassBlocks
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.renderer.RenderType
import net.minecraft.world.level.block.Block

class DefinedsBlocksClient : ClientModInitializer {
    override fun onInitializeClient() {
        renderTranslucentBlock()
    }

    fun renderTranslucentBlock() {
        val blocks =
            listOf<Block>(
                FutureBlocks.FUTURA_BLOCK.get(),
                GlassBlocks.MANA_GLASS.get(),
                GlassBlocks.ELF_GLASS.get(),
            )

        blocks.forEach { BlockRenderLayerMap.INSTANCE.putBlock(it, RenderType.translucent()) }
    }
}

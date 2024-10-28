package dev.definedentity.definedsblocks.client

import dev.definedentity.definedsblocks.blocks.DBBlocks
import dev.definedentity.definedsblocks.blocks.FutureBlock
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.client.renderer.RenderType

class DefinedsBlocksClient : ClientModInitializer {
    override fun onInitializeClient() {
        renderTranslucentBlock()
    }

    fun renderTranslucentBlock() {
        val blocks = listOf(DBBlocks.BLOCKS.get(FutureBlock.ID))

        blocks.forEach { BlockRenderLayerMap.INSTANCE.putBlock(it, RenderType.translucent()) }
    }
}

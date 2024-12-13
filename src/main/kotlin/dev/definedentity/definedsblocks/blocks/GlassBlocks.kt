package dev.definedentity.definedsblocks.blocks

import dev.definedentity.definedsblocks.registry.GlassRegistry
import net.minecraft.world.level.block.GlassBlock

object GlassBlocks {
    val MANA_GLASS = GlassRegistry.block("mana_glass", ::GlassBlock)

    val ELF_GLASS = GlassRegistry.block("elf_glass", ::GlassBlock)

    fun init() {}
}

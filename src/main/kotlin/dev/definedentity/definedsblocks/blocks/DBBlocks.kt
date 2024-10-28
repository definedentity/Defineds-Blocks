package dev.definedentity.definedsblocks.blocks

import dev.definedentity.definedsblocks.DefinedsBlocks
import dev.definedentity.definedsblocks.items.DBItems
import dev.definedentity.definedsblocks.utils.DBIdentifier
import net.minecraft.core.Registry
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

object DBBlocks {
    val BLOCKS = hashMapOf<String, Block>()
    val TRIVIAL_BLOCKS = hashMapOf<String, Block>()

    fun init() {
        block(FutureBlock.ID, FutureBlock(), false)
        block(UndefinedBlock.ID, UndefinedBlock())

        DefinedsBlocks.LOGGER.info("Registering blocks...")
    }

    fun block(name: String, block: Block, isTrivialBlock: Boolean = true) {
        DBItems.item(name, BlockItem(block, Item.Properties().tab(DefinedsBlocks.ITEM_GROUP)))
        val block = Registry.register(Registry.BLOCK, DBIdentifier(name), block)
        BLOCKS[name] = block

        if (isTrivialBlock) {
            TRIVIAL_BLOCKS[name] = block
        }
    }
}

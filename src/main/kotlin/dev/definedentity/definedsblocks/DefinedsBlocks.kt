package dev.definedentity.definedsblocks

import dev.definedentity.definedsblocks.blocks.DBBlocks
import dev.definedentity.definedsblocks.blocks.FutureBlock
import dev.definedentity.definedsblocks.items.DBItems
import dev.definedentity.definedsblocks.utils.DBIdentifier
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import org.slf4j.LoggerFactory

class DefinedsBlocks : ModInitializer {
    companion object {
        val MOD_ID = "definedsblocks"
        val MOD_NAME = "Defined's Blocks"
        val LOGGER = LoggerFactory.getLogger(MOD_NAME)

        val ITEM_GROUP =
            FabricItemGroupBuilder.build(DBIdentifier("general")) {
                DBBlocks.BLOCKS.get(FutureBlock.ID)!!.asItem().defaultInstance
            }
    }

    override fun onInitialize() {
        DBItems.init()
        DBBlocks.init()
    }
}

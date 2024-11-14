package dev.definedentity.definedsblocks

import com.tterrag.registrate.Registrate
import dev.definedentity.definedsblocks.blocks.DBBlocks
import dev.definedentity.definedsblocks.blocks.MossyBlocks
import dev.definedentity.definedsblocks.registry.BlockRegistry
import dev.definedentity.definedsblocks.utils.DBIdentifier
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import org.slf4j.LoggerFactory

class DefinedsBlocks : ModInitializer {
    companion object {
        val MOD_ID = "definedsblocks"
        val MOD_NAME = "Defined's Blocks"
        val LOGGER = LoggerFactory.getLogger(MOD_NAME)

        val REGISTRATE = Registrate.create(MOD_ID)

        val ITEM_GROUP = FabricItemGroupBuilder.build(DBIdentifier("general")) {
            MossyBlocks.MOSSIER_STONE_BRICKS.get().asItem().defaultInstance
        }
    }

    override fun onInitialize() {
        REGISTRATE.creativeModeTab { ITEM_GROUP }
        REGISTRATE.addRawLang("itemGroup.${MOD_ID}.general", "Defined's Blocks")

        DBBlocks.init()

        REGISTRATE.register()
    }
}

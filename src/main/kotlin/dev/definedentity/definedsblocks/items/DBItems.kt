package dev.definedentity.definedsblocks.items

import dev.definedentity.definedsblocks.DefinedsBlocks
import dev.definedentity.definedsblocks.utils.DBIdentifier
import net.minecraft.core.Registry
import net.minecraft.world.item.Item

object DBItems {
    fun item(name: String, item: Item): Item {
        return Registry.register(Registry.ITEM, DBIdentifier(name), item)
    }

    fun init() {
        DefinedsBlocks.LOGGER.info("Registering items...")
    }
}

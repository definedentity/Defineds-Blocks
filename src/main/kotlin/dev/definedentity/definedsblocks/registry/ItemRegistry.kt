package dev.definedentity.definedsblocks.registry

import dev.definedentity.definedsblocks.utils.DBIdentifier
import net.minecraft.core.Registry
import net.minecraft.world.item.Item

object ItemRegistry {
    fun legacyItem(name: String, item: Item): Item {
        return Registry.register(Registry.ITEM, DBIdentifier(name), item)
    }
}
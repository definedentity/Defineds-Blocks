package dev.definedentity.definedsblocks.blocks

import dev.definedentity.definedsblocks.DefinedsBlocks

object DBBlocks {
    fun init() {
        DefinedsBlocks.LOGGER.info("Registering blocks...")
        MossyBlocks.init()
        FuturaBlocks.init()
        GlassBlocks.init()
    }
}

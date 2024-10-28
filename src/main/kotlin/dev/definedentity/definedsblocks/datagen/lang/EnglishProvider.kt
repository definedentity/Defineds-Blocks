package dev.definedentity.definedsblocks.datagen.lang

import dev.definedentity.definedsblocks.blocks.DBBlocks
import dev.definedentity.definedsblocks.utils.TextFormatting
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider

class EnglishProvider(gen: FabricDataGenerator) : FabricLanguageProvider(gen, "en_us") {
    override fun generateTranslations(translationBuilder: TranslationBuilder) {
        DBBlocks.BLOCKS.forEach {
            translationBuilder.add(
                it.value,
                TextFormatting.toEnglishName(it.value.asItem().toString())
            )
        }
    }
}

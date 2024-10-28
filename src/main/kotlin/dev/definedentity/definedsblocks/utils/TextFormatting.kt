package dev.definedentity.definedsblocks.utils

import java.util.Locale

object TextFormatting {
    fun toEnglishName(internalName: Any): String {
        return internalName.toString().lowercase(Locale.ROOT).split("_").joinToString(" ") {
            it.replaceFirstChar { char -> char.uppercaseChar() }
        }
    }
}

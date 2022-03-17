package de.chafficui.deepLTranslatorAPI

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TranslatorTest {

    @Test
    fun translate() {
        Translator.initialize("src/main/resources/chromedriver.exe")
        val translator = Translator(Language.GERMAN, Language.ENGLISH)
        for (i in 0..50) {
            val text = "Hallo Welt,  was geht bei dir, ich möchte das jetzt bitte wissen, was machst du so?"
            val translated = translator.translate(text)
            assertEquals("Hello world, what's up with you, I want to know this now please, what do you do?", translated, "Failed at $i")
        }
    }
}
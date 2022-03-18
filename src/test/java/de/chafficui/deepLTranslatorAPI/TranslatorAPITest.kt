package de.chafficui.deepLTranslatorAPI

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TranslatorAPITest {

    @Test
    fun translate() {
        TranslatorAPI.initialize("src/main/resources/chromedriver.exe")
        val translatorAPI = TranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH)
        val fullTime = System.currentTimeMillis()
        for (i in 0..50) {
            val text = "Hallo Welt?"
            val time = System.currentTimeMillis()
            val translated = translatorAPI.translate(text)
            println("Translated in ${System.currentTimeMillis() - time}ms")
            assertEquals("Hello world?", translated, "Failed at $i")
        }
        println("Everything translated in ${System.currentTimeMillis() - fullTime}ms")
        translatorAPI.quit()
    }

    @Test
    fun translateAPI() {
        TranslatorAPI.initialize("src/main/resources/chromedriver.exe")
        val translatorAPI = TranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "180ba3f9-d82b-ebc0-5f0c-2eedf350fd55:fx")
        val fullTime = System.currentTimeMillis()
        for (i in 0..50) {
            val text = "Hallo Welt?"
            val time = System.currentTimeMillis()
            val translated = translatorAPI.fastTranslate(text)
            println("Translated in ${System.currentTimeMillis() - time}ms")
            assertEquals("Hello world?", translated, "Failed at $i")
        }
        println("Everything translated in ${System.currentTimeMillis() - fullTime}ms")
        translatorAPI.quit()
    }
}
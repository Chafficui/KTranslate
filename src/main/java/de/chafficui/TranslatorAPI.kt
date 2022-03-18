package de.chafficui

abstract class TranslatorAPI(
    protected val sourceLanguage: Language,
    protected val targetLanguage: Language
) {

    /**
     * Translates the given text to the target language.
     * @param text Text to translate
     * @return Translated text
     */
    abstract fun translate(text: String): String
}
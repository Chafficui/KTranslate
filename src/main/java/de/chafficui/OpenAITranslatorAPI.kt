package de.chafficui

import com.theokanning.openai.OpenAiService
import com.theokanning.openai.completion.CompletionRequest

class OpenAITranslatorAPI(sourceLanguage: Language, targetLanguage: Language, apiKey: String) :
    TranslatorAPI(sourceLanguage, targetLanguage) {
    private val service = OpenAiService(apiKey)

    override fun translate(text: String): String {
        val completion = service.createCompletion(
            "text-babbage-001",
            CompletionRequest.builder()
                .prompt("Translate the following sentence from ${sourceLanguage.name} to ${targetLanguage.name}: \"$text\"")
                .echo(false)
                .temperature(.0)
                .build()
        ).choices[0]
        return completion.text.replace("\n", "").removeSurrounding("\"")
    }
}
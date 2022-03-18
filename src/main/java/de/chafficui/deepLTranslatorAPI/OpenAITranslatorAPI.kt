package de.chafficui.deepLTranslatorAPI

import com.theokanning.openai.OpenAiService
import com.theokanning.openai.completion.CompletionRequest

class OpenAITranslatorAPI(private val sourceLanguage: Language, private val targetLanguage: Language, apiKey: String) {
    private val service = OpenAiService(apiKey)

    fun translate(text: String): String {
        val completion = service.createCompletion(
            "text-babbage-001",
            CompletionRequest.builder().prompt("Translate the following sentence from ${sourceLanguage.name} to ${targetLanguage.name}: \"$text\"")
                .echo(false)
                .temperature(.0)
                .build()
        ).choices[0]
        return completion.text.replace("\n", "").removeSurrounding("\"")
    }
}
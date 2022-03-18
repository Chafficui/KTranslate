package de.chafficui

import java.net.URI
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.charset.StandardCharsets

class DeepLProTranslatorAPI(sourceLanguage: Language, targetLanguage: Language, apiKey: String): TranslatorAPI(sourceLanguage, targetLanguage) {
    private val params = mutableMapOf(
            "source_lang" to sourceLanguage.shortSrc,
            "target_lang" to targetLanguage.shortTarget,
            "text" to "Hello World",
            "auth_key" to apiKey
        )
    private val client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build()
    private val uri = if(apiKey.endsWith(":fx")) {
        URI.create("https://api-free.deepl.com/v2/translate")
    } else {
        URI.create("https://api.deepl.com/v2/translate")
    }


    override fun translate(text: String): String {
        params["text"] = text
        val request = HttpRequest.newBuilder()
            .POST(buildFormDataFromMap(params))
            .uri(uri)
            .setHeader("User-Agent", "ParadoxAutoTranslator")
            .header("Content-Type", "application/x-www-form-urlencoded")
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        return response.body().split("\"text\":\"")[1].split("\"")[0]
    }

    private fun buildFormDataFromMap(data: Map<String, String>): HttpRequest.BodyPublisher? {
        val builder = StringBuilder()
        data.forEach {
            if (builder.isNotEmpty()) {
                builder.append("&")
            }
            builder.append(URLEncoder.encode(it.key, StandardCharsets.UTF_8))
            builder.append("=")
            builder.append(URLEncoder.encode(it.value, StandardCharsets.UTF_8))
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString())
    }
}
package de.chafficui.deepLTranslatorAPI

import de.chafficui.deepLTranslatorAPI.driver.DeepLDriver
import java.net.URI
import java.net.URLEncoder
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.charset.StandardCharsets

/**
 * The translator API.
 * A tranlation API that uses the DeepL API and website to localize text.
 *
 * Before creating an object of this class the TranslatorAPI needs to be initialized.
 *
 * @see [DeepL](https://www.deepl.com/)
 *
 * @author  Felix Beinßen
 * @since   1.0
 *
 * @param sourceLanguage The source language.
 * @param targetLanguage The target language.
 */
class DeepLTranslatorAPI(private val sourceLanguage: Language = Language.BRITISH_ENGLISH, private val targetLanguage: Language = Language.GERMAN) {
    private var deepLDriver: DeepLDriver? = null
    private var params: MutableMap<String, String>? = null
    private var client: HttpClient? = null

    init {
        if (!isInitialized) throw IllegalStateException("TranslatorAPI is not initialized!")
    }

    private fun setupTranslate() {
        deepLDriver = DeepLDriver()
        deepLDriver?.setup(sourceLanguage, targetLanguage)
    }

    private fun setupFastTranslate() {
        if(apiKey.isBlank()) throw IllegalStateException("API key is not set!")
        params = mutableMapOf(
            "source_lang" to sourceLanguage.shortSrc,
            "target_lang" to targetLanguage.shortTarget,
            "text" to "Hello World",
            "auth_key" to apiKey
        )
        client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build()
    }

    /**
     * Translates the given text to the target language.
     * A slow but free translation method. Use this method if you don't need to translate a lot of text.
     * @param text The text to translate
     * @return The translated text
     */
    fun freeTranslate(text: String): String {
        if(deepLDriver == null) setupTranslate()
        val deepLDriver = this.deepLDriver ?: throw IllegalStateException("Something went wrong!")
        if (text.isBlank()) throw IllegalArgumentException("Text is empty!")
        Thread.sleep(200)
        val srcInput = deepLDriver.sourceInput
        srcInput.sendKeys(text)
        Thread.sleep(200)

        val targetOutput = deepLDriver.targetOutput

        var targetText = targetOutput.getAttribute("value")
        var textBefore = ""
        while (targetText == "" || targetText != textBefore) {
            textBefore = targetText
            targetText = targetOutput.getAttribute("value")
            Thread.sleep(200)
            if (targetText == textBefore) {
                targetText = targetOutput.getAttribute("value")
                Thread.sleep(500)
            }
        }

        targetText = targetOutput.getAttribute("value")

        deepLDriver.clear()

        return targetText
    }

    /**
     * Translates the given text to the target language.
     * Is way faster than the normal freeTranslate method, but requires an API key by deepL.com to use.
     * @param text Text to translate
     * @return Translated text
     */
    fun fastTranslate(text: String): String {
        if(params == null || client == null) setupFastTranslate()
        val params = this.params
        val client = this.client
        if(params == null || client == null) throw IllegalStateException("Something went wrong!")

        params["text"] = text
        val request = HttpRequest.newBuilder()
            .POST(buildFormDataFromMap(params))
            .uri(URI.create("https://api-free.deepl.com/v2/translate"))
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

    companion object {
        var isInitialized = false
            private set

        var apiKey = ""

        /**
         * Initializes the TranslatorAPI.
         * @param chromeDriverPath Path to the ChromeDriver.exe
         * @param apiKey API key from deepL.com
         */
        @JvmStatic
        fun initialize(chromeDriverPath: String = "", apiKey: String = "") {
            if (isInitialized) return
            isInitialized = true
            if(apiKey.isNotBlank()) this.apiKey = apiKey
            System.setProperty("webdriver.chrome.driver", chromeDriverPath)
            Runtime.getRuntime().addShutdownHook(Thread {
                DeepLDriver.closeAllDrivers()
            })
        }

        /**
         * Initializes the TranslatorAPI.
         * @param chromeDriverPath Path to the ChromeDriver.exe
         * @param apiKey API key from deepL.com
         */
        @JvmStatic
        fun initalize(apiKey: String = "", chromeDriverPath: String = "") {
            initialize(chromeDriverPath, apiKey)
        }
    }
}
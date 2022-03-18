package de.chafficui

import de.chafficui.driver.DeepLDriver
import java.util.concurrent.TimeoutException

class DeepLFreeTranslatorAPI(
    sourceLanguage: Language,
    targetLanguage: Language,
    chromeDriverPath: String,
    private val timeOutMillis: Long = 10000
): TranslatorAPI(sourceLanguage, targetLanguage) {
    private var deepLDriver: DeepLDriver

    init {
        setup(chromeDriverPath)
        deepLDriver = DeepLDriver()
        deepLDriver.setup(sourceLanguage, targetLanguage)
    }

    override fun translate(text: String): String {
        if (text.isBlank()) throw IllegalArgumentException("Text is empty!")
        Thread.sleep(200)
        val srcInput = deepLDriver.sourceInput
        srcInput.sendKeys(text)
        Thread.sleep(200)

        val targetOutput = deepLDriver.targetOutput

        val started = System.currentTimeMillis()

        var targetText = ""
        var textBefore = ""
        while (targetText == "" || targetText != textBefore) {
            textBefore = targetText
            targetText = targetOutput.getAttribute("value")
            Thread.sleep(200)
            if (targetText == textBefore) {
                targetText = targetOutput.getAttribute("value")
                Thread.sleep(500)
            }
            if(System.currentTimeMillis() - started > timeOutMillis) {
                throw TimeoutException("Translation timed out!")
            }
        }

        targetText = targetOutput.getAttribute("value")

        deepLDriver.clear()

        return targetText
    }

    companion object {
        private var hookRegistered = false
        private fun setup(chromeDriverPath: String) {
            System.setProperty("webdriver.chrome.driver", chromeDriverPath)
            if(hookRegistered) return
            Runtime.getRuntime().addShutdownHook(Thread {
                DeepLDriver.closeAllDrivers()
            })
        }
    }
}
package de.chafficui.deepLTranslatorAPI.driver

import de.chafficui.deepLTranslatorAPI.Language
import de.chafficui.deepLTranslatorAPI.DeepLTranslatorAPI.Companion.isInitialized
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class DeepLDriver {
    private val driver: ChromeDriver

    init {
        if(!isInitialized) throw IllegalStateException("Translator is not initialized!")
        driver = ChromeDriver(options)
        drivers.add(driver)
        driver.get("https://www.deepl.com/translator")
        driver.executeScript(DISABLE_ANIMATIONS_SCRIPT)
    }

    fun setup(sourceLanguage: Language, targetLanguage: Language) {
        val srcLanguageDropDown = getByXPath("//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[1]/div/button")
        srcLanguageDropDown.click()
        getByXPath(sourceLanguage.srcPath).click()

        val targetLanguageDropDown = getByXPath("//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[1]/div[1]/div[1]/button")
        targetLanguageDropDown.click()
        getByXPath(targetLanguage.targetPath).click()
    }

    private fun getByXPath(xpath: String): WebElement {
        return driver.findElement(By.xpath(xpath))
    }

    val sourceInput: WebElement
        get() = getByXPath("//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[2]/textarea")

    val targetOutput: WebElement
        get() = getByXPath("//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[1]/textarea")

    fun clear() {
        sourceInput.clear()
    }

    fun quit() {
        driver.quit()
        drivers.remove(driver)
    }



    companion object {
        private val drivers = mutableListOf<ChromeDriver>()
        private val options = ChromeOptions()

        fun closeAllDrivers() {
            for (driver in drivers) {
                driver.quit()
            }
        }

        init {
            options.addArguments("--disable-gpu", "--window-size=1920,1080")
            options.addArguments("--disable-blink-features=AutomationControlled")
            options.addArguments("--no-sandbox")
            options.addArguments("--disable-gpu")
            options.addArguments("--disable-crash-reporter")
            options.addArguments("--disable-extensions")
            options.addArguments("--disable-in-process-stack-traces")
            options.addArguments("--disable-logging")
            options.addArguments("--disable-dev-shm-usage")
            options.addArguments("--log-level=3")
            options.addArguments("--output=/dev/null")
            options.addArguments("--silent")
            options.addArguments("--headless")
        }

        /**
         * Script to disable animations on a website.
         *
         *
         * Source: https://github.com/dcts/remove-CSS-animations
         */
        private const val DISABLE_ANIMATIONS_SCRIPT =
            "document.querySelector('html > head').insertAdjacentHTML(\"beforeend\", \"" +
                    "<style>\\n" +
                    "* {\\n" +
                    "  -o-transition-property: none !important;\\n" +
                    "  -moz-transition-property: none !important;\\n" +
                    "  -ms-transition-property: none !important;\\n" +
                    "  -webkit-transition-property: none !important;\\n" +
                    "  transition-property: none !important;\\n" +
                    "}\\n" +
                    "* {\\n" +
                    "  -o-transform: none !important;\\n" +
                    "  -moz-transform: none !important;\\n" +
                    "  -ms-transform: none !important;\\n" +
                    "  -webkit-transform: none !important;\\n" +
                    "  transform: none !important;\\n" +
                    "}\\n" +
                    "* {\\n" +
                    "  -webkit-animation: none !important;\\n" +
                    "  -moz-animation: none !important;\\n" +
                    "  -o-animation: none !important;\\n" +
                    "  -ms-animation: none !important;\\n" +
                    "  animation: none !important;\\n" +
                    "}\\n" +
                    "</style>\\n" +
                    "\");"
    }
}
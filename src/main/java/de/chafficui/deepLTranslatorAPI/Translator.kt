package de.chafficui.deepLTranslatorAPI

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class Translator(private val sourceLanguage: Language, private val targetLanguage: Language) {
    private val driver: ChromeDriver

    init {
        if(!isInitialized) throw IllegalStateException("Translator is not initialized!")
        val options = ChromeOptions()

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
        options.addArguments("--headless")

        driver = ChromeDriver(options)
        drivers.add(driver)
        driver.get("https://www.deepl.com/translator")
        driver.executeScript(DISABLE_ANIMATIONS_SCRIPT)
    }

    private fun reset() {
        val srcLanguageDropDown = driver.findElement(By.xpath("//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[1]/div/button"))
        srcLanguageDropDown.click()
        driver.findElement(By.xpath(sourceLanguage.srcPath)).click()

        val targetLanguageDropDown = driver.findElement(By.xpath("//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[1]/div[1]/div[1]/button"))
        targetLanguageDropDown.click()
        driver.findElement(By.xpath(targetLanguage.targetPath)).click()

        Thread.sleep(500)
    }

    fun translate(text: String): String {
        reset()
        val srcInput = driver.findElement(By.xpath("//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[2]/textarea"))
        srcInput.sendKeys(text)

        val targetInput = driver.findElement(By.xpath("//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[1]/textarea"))

        var targetText = targetInput.getAttribute("value")
        while (targetText == "") {
            Thread.sleep(100)
            targetText = targetInput.getAttribute("value")
        }

        Thread.sleep(500)
        targetText = targetInput.getAttribute("value")

        srcInput.clear()

        return targetText
    }

    companion object {
        private var isInitialized = false

        @JvmStatic
        fun initialize(chromeDriverPath: String) {
            if(isInitialized) return
            isInitialized = true
            System.setProperty("webdriver.chrome.driver", chromeDriverPath)
            Runtime.getRuntime().addShutdownHook(Thread {
                closeAllDrivers()
            })
        }

        private val drivers = mutableListOf<ChromeDriver>()

        private fun closeAllDrivers() {
            for (driver in drivers) {
                driver.quit()
            }
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
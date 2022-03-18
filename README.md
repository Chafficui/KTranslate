# KTranslate
## An easy to use translation / localization api written in Kotlin.

## OpenAI Translator
- Uses OpenAI to translate strings to a target language.
- Cost: $0.0012 per 1k tokens
- Time per translation: ~200ms
- Highly variable accuracy
- _Requires an openai api key._
````Kotlin
val translator = OpenAITranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "YOUR_API_KEY") //get your api key from open https://openai.com/api/
println(translator.translate("Hallo Welt")) // --> "Hello World"
````

## DeepL Pro Translator
- Uses the DeepL API to translate strings to a target language.
- Cost: 20€ each 1,0000,000 characters
- Time per translation: ~100ms
- Most accurate
- _Requiures an DeepLPro api key._
````Kotlin
DeepLTranslatorAPI.initialize(apiKey = "YOUR_API_KEY")
val translator = DeepLTranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH) //get your api key from open https://https://www.deepl.com/de/pro-account/summary
println(translator.fastTranslate("Hallo Welt")) // --> "Hello World"
````

## DeepL FREE Translator
- The only completely free method to translate. 
- Cost: 0€
- Time per translation: ~2000ms
- Usually accurate
- _Requires a copy of [chromedriver.exe](https://chromedriver.storage.googleapis.com/index.html) installed on your system._
````Kotlin
DeepLTranslatorAPI.initialize(chromeDriverPath = "path/to/chromedriver.exe")
val translator = DeepLTranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH) //get your api key from open https://https://www.deepl.com/de/pro-account/summary
println(translator.freeTranslate("Hallo Welt")) // --> "Hello World"
````

# KTranslate
## An easy to use translation / localization api written in Kotlin.

## OpenAI Translator
- Uses OpenAI to translate strings to a target language.
- Cost: $0.0012 per 1k tokens
- Time per translation: ~400ms
- Highly variable accuracy
- _Requires an openai api key._
Kotlin:
````Kotlin
val translator = OpenAITranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "YOUR_API_KEY") //get your api key from open https://openai.com/api/
println(translator.translate("Hallo Welt")) // --> "Hello World"
````
Java:
````Java
OpenAITranslatorAPI translator = new OpenAITranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "YOUR_API_KEY"); //get your api key from open https://openai.com/api/
System.out.println(translator.translate("Hallo Welt")); // --> "Hello World"
````

## DeepL Pro Translator
- Uses the DeepL API to translate strings to a target language.
- Cost: 20€ each 1,0000,000 characters
- Time per translation: ~200ms
- Most accurate
- _Requiures an DeepLPro api key._
````Kotlin
val translator = DeepLProTranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "YOUR_API_KEY") //get your api key from open https://https://www.deepl.com/de/pro-account/summary
println(translator.translate("Hallo Welt")) // --> "Hello World"
````
Java:
````Java
DeepLProTranslatorAPI translator = new DeepLProTranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "YOUR_API_KEY"); //get your api key from open https://https://www.deepl.com/de/pro-account/summary
System.out.println(translator.translate("Hallo Welt")); // --> "Hello World"
````

## DeepL FREE Translator
- The only completely free method to translate. 
- Cost: 0€
- Time per translation: ~1500ms
- Usually accurate
- _Requires a copy of [chromedriver.exe](https://chromedriver.storage.googleapis.com/index.html) installed on your system._
````Kotlin
val translator = DeepLFreeTranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "path/to/your/chromedriver.exe")
println(translator.translate("Hallo Welt")) // --> "Hello World"
````
Java:
````Java
DeepLFreeTranslatorAPI translator = new DeepLFreeTranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "path/to/your/chromedriver.exe");
System.out.println(translator.translate("Hallo Welt")); // --> "Hello World"
````

# KTranslate
KTranslate is an easy to use TranslationAPI written in Kotlin, with currently 26 supported languages. It is very easy to use in Kotlin and Java projects via [Jitpack](https://jitpack.io/#Chafficui/KTranslate).

## Summary
- [OpenAI Translator](#openai-translator)
- [DeepL Pro Translator](#deepl-pro-translator)
- [DeepL Free Translator](#deepl-free-translator)
- [Languages Supported](#languages-supported)

## OpenAI Translator
- Uses OpenAI to translate strings to a target language.
- Cost: ~$0.0003 per 1k characters
- Time per translation: ~400ms
- Highly variable accuracy
- _Requires an openai api key._    
#### Kotlin:
````Kotlin
val translator = OpenAITranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "YOUR_API_KEY") //get your api key from open https://openai.com/api/
println(translator.translate("Hallo Welt")) // --> "Hello World"
````
#### Java:
````Java
OpenAITranslatorAPI translator = new OpenAITranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "YOUR_API_KEY"); //get your api key from open https://openai.com/api/
System.out.println(translator.translate("Hallo Welt")); // --> "Hello World"
````

## DeepL Pro Translator
- Uses the DeepL API to translate strings to a target language.
- Cost: 0.02€ per 1k characters
- Time per translation: ~200ms
- Most accurate
- _Requiures an DeepLPro api key._    
#### Kotlin
````Kotlin
val translator = DeepLProTranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "YOUR_API_KEY") //get your api key from open https://https://www.deepl.com/de/pro-account/summary
println(translator.translate("Hallo Welt")) // --> "Hello World"
````
#### Java:
````Java
DeepLProTranslatorAPI translator = new DeepLProTranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "YOUR_API_KEY"); //get your api key from open https://https://www.deepl.com/de/pro-account/summary
System.out.println(translator.translate("Hallo Welt")); // --> "Hello World"
````

## DeepL Free Translator
- The only completely free method to translate. 
- Cost: Completely free
- Time per translation: ~1500ms
- Usually accurate
- _Requires a copy of [chromedriver.exe](https://chromedriver.storage.googleapis.com/index.html) installed on your system._    
#### Kotlin
````Kotlin
val translator = DeepLFreeTranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "path/to/your/chromedriver.exe")
println(translator.translate("Hallo Welt")) // --> "Hello World"
````
#### Java:
````Java
DeepLFreeTranslatorAPI translator = new DeepLFreeTranslatorAPI(Language.GERMAN, Language.BRITISH_ENGLISH, "path/to/your/chromedriver.exe");
System.out.println(translator.translate("Hallo Welt")); // --> "Hello World"
````

## Languages Supported
At the moment there are 26 languages supported.
- Bulgarian
- Chinese
- Danish
- German
- British English
- American English
- Estonian
- Finnish
- French
- Greek
- Italian
- Japanese
- Latvian
- Lithuanian
- Dutch
- Polish
- Portuguese
- Brazilian Portuguese
- Romanian
- Russian
- Swedish
- Slovakian
- Slovenian
- Spanish
- Czech
- Hungarian

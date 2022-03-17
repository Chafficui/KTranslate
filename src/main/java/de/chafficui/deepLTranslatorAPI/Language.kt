package de.chafficui.deepLTranslatorAPI

enum class Language(val srcPath: String, val targetPath: String) {
    BULGARIAN(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[1]/button[2]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[1]/button[1]"
    ),
    CHINESE(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[1]/button[3]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[1]/button[2]"
    ),
    DANISH(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[1]/button[4]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[1]/button[3]"
    ),
    GERMAN(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[1]/button[5]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[1]/button[4]"
    ),
    ENGLISH(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[1]/button[6]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[1]/button[5]"
    ),
    ESTONIAN(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[1]/button[7]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[1]/button[7]"
    ),
    FINNISH(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[1]/button[8]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[1]/button[8]"
    ),
    FRENCH(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[1]/button[9]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[1]/button[9]"
    ),
    GREEK(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[2]/button[1]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[2]/button[1]"
    ),
    ITALIAN(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[2]/button[2]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[2]/button[2]"
    ),
    JAPANESE(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[2]/button[3]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[2]/button[3]"
    ),
    LATVIAN(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[2]/button[4]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[2]/button[4]"
    ),
    LITHUANIAN(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[2]/button[5]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[2]/button[5]"
    ),
    DUTCH(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[2]/button[6]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[2]/button[6]"
    ),
    POLISH(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[2]/button[7]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[2]/button[7]"
    ),
    PORTUGUESE(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[2]/button[8]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[2]/button[8]"
    ),
    ROMANIAN(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[2]/button[9]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[3]/button[1]"
    ),
    RUSSIAN(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[3]/button[1]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[3]/button[2]"
    ),
    SWEDISH(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[3]/button[2]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[3]/button[3]"
    ),
    SLOVAKIAN(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[3]/button[3]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[3]/button[4]"
    ),
    SLOVENIAN(
        "//*[@id=\\\"panelTranslateText\\\"]/div[3]/section[1]/div[3]/div[4]/div/div[3]/button[4]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[3]/button[5]"
    ),
    SPANISH(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[3]/button[5]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[3]/button[6]"
    ),
    CZECH(
        "//*[@id=\\\"panelTranslateText\\\"]/div[3]/section[1]/div[3]/div[4]/div/div[3]/button[6]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[3]/button[7]"
    ),
    HUNGARIAN(
        "//*[@id=\"panelTranslateText\"]/div[3]/section[1]/div[3]/div[4]/div/div[3]/button[7]",
        "//*[@id=\"panelTranslateText\"]/div[3]/section[2]/div[3]/div[7]/div/div[3]/button[8]"
    )
}
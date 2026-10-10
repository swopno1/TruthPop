package com.example.model

enum class PromptType(val labelEn: String, val labelBn: String) {
    TRUTH("Truth", "সত্য"),
    DARE("Dare", "সাহস / ডেয়ার")
}

enum class GameCategory(val labelEn: String, val labelBn: String, val iconEmoji: String) {
    FRIENDS("Friends", "বন্ধু", "👥"),
    COUPLES("Couples", "দম্পতি / রোমান্স", "❤️"),
    FAMILY("Family", "পরিবার", "👨‍👩‍👧‍👦")
}

enum class Intensity(val labelEn: String, val labelBn: String, val emoji: String) {
    CHILL("Chill", "সহজ", "🟢"),
    FUN("Fun", "মজার", "🟡"),
    SPICY("Spicy", "সাহসী", "🔴")
}

enum class Language(val displayName: String, val code: String) {
    ENGLISH("English", "en"),
    BANGLA("বাংলা", "bn")
}

data class PromptItem(
    val id: String,
    val type: PromptType,
    val category: GameCategory,
    val intensity: Intensity,
    val textEn: String,
    val textBn: String,
    val hintEn: String? = null,
    val hintBn: String? = null
)

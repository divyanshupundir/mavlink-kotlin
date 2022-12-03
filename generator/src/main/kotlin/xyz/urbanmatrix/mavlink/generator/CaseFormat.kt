package xyz.urbanmatrix.mavlink.generator

internal class CaseFormat(private val words: List<String>) {

    companion object {

        fun fromDelimited(identifier: String, delimiter: String): CaseFormat =
            CaseFormat(identifier.split(delimiter).map(String::lowercase))

        fun fromSnake(identifier: String): CaseFormat = fromDelimited(identifier, "_")

        fun fromKebab(identifier: String): CaseFormat = fromDelimited(identifier, "-")

        fun fromCamel(identifier: String): CaseFormat =
            fromSnake(identifier.replace("([a-z])([A-Z]+)".toRegex(), "$1_$2"))
    }

    fun toTitle() = words.joinToString(" ") { it.lowercase().replaceFirstChar(Char::titlecaseChar) }

    fun toLowerSnake() = words.joinToString("_")

    fun toUpperSnake() = toLowerSnake().uppercase()

    fun toLowerKebab() = words.joinToString("-")

    fun toUpperKebab() = toLowerKebab().uppercase()

    fun toLowerCamel() = toUpperCamel().replaceFirstChar(Char::lowercase)

    fun toUpperCamel() = words.joinToString("") { it.replaceFirstChar(Char::uppercase) }
}

package jetbrains.kotlin.course.alias.card

import jetbrains.kotlin.course.alias.util.IdentifierFactory
import jetbrains.kotlin.course.alias.util.words
import org.springframework.stereotype.Service

@Service
class CardService() {
    private val identifierFactory: IdentifierFactory = IdentifierFactory()
    private val cards : List<Card> = generateCards()
    private fun generateCards(): List<Card> =
        words.run {
            this.shuffled().chunked(WORDS_IN_CARD).take(cardsAmount).map { it.toWords() }.map { Card(identifierFactory.uniqueIdentifier(), it) }
        }

    private fun List<String>.toWords(): List<Word> = this.map { Word(it) }

    fun getCardByIndex(index: Int): Card = cards.getOrNull(index) ?: error("The card does not exists")
    companion object{
        private const val WORDS_IN_CARD : Int = 4
        val cardsAmount : Int = words.size / WORDS_IN_CARD
    }
}

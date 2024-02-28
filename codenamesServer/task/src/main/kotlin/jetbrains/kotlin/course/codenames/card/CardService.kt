package jetbrains.kotlin.course.codenames.card

import jetbrains.kotlin.course.codenames.utils.Utils.TOTAL_NUMBER
import jetbrains.kotlin.course.codenames.utils.words
import org.springframework.stereotype.Service

@Service
class CardService {
    fun generateWordsCards(): List<Card>{
        require(words.size >= TOTAL_NUMBER){
            "Forbidden state"
        }
        words = words.shuffled()
        val res = words.take(TOTAL_NUMBER).map { it -> Card(WordCardData(it), CardState.Front) }
        words = words.drop(TOTAL_NUMBER)
        return res
    }
}

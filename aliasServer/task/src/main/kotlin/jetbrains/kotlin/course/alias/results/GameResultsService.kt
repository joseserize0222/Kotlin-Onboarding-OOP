package jetbrains.kotlin.course.alias.results

import jetbrains.kotlin.course.alias.team.Team
import jetbrains.kotlin.course.alias.team.TeamService.Companion.teamsStorage
import org.springframework.stereotype.Service

typealias GameResult = List<Team>

@Service
class GameResultsService {
    fun saveGameResults(result: GameResult){
        require(result.isNotEmpty()){
            "results are empty"
        }
        require(result.all { teamsStorage.contains(it.id)}){
            "The team is not in the list"
        }
        gameHistory.add(result)
    }

    fun getAllGameResults(): List<GameResult> = gameHistory.reversed()
    companion object{
        val gameHistory = mutableListOf<GameResult>()
    }
}

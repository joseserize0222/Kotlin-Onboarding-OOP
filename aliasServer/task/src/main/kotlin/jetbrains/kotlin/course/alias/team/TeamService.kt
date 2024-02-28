package jetbrains.kotlin.course.alias.team

import org.springframework.stereotype.Service
import jetbrains.kotlin.course.alias.util.Identifier
import jetbrains.kotlin.course.alias.util.IdentifierFactory

@Service
class TeamService {
    private val identifierFactory = IdentifierFactory()

    fun generateTeamsForOneRound(teamsNumber: Int) : List<Team>{
        val list = mutableListOf<Team>()
        repeat(teamsNumber){
            val number = identifierFactory.uniqueIdentifier()
            val newTeam = Team(number)
            teamsStorage.put(number, newTeam)
            list.add(newTeam)
        }
        return list.toList()
    }

    companion object{
        val teamsStorage = mutableMapOf<Identifier, Team>()
    }
}

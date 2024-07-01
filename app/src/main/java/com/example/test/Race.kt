package com.example.test

import com.example.test.Autos.Auto

class Race(
    val cars: MutableList<Auto>,
    val log: (String) -> Unit)
{
    var round: Int = 1
    val contenders: MutableList<Auto> = cars.toMutableList()
    val winners: MutableList<Auto> = mutableListOf()

    fun nextRound() : Boolean
    {
        winners.clear()
        fun decideWinner(p1:Auto, p2:Auto, winner: Boolean) : String
        {
            if(winner)
            {
                winners.add(p1)
                return "\n${p1.modelName} ${p1.modelSeries} vs " +
                        "${p2.modelName} ${p2.modelSeries}: " +
                        "${p1.modelName} ${p1.modelSeries}"
            }
            winners.add(p2)
            return "\n${p1.modelName} ${p1.modelSeries} vs " +
                    "${p2.modelName} ${p2.modelSeries}: " +
                    "${p2.modelName} ${p2.modelSeries}"
        }

        log("\n\nRound #$round\n")

        if(contenders.count() % 2 == 1)
        {
            winners.add(contenders.last())
        }

        for(i in 1..<contenders.count() step 2)
        {
            log(decideWinner(contenders[i-1], contenders[i],
                contenders[i-1].motorCapacity<=contenders[i].motorCapacity))
        }

        contenders.clear()
        for(winner in winners)
        {
            contenders.add(winner)
        }

        round++
        if(winners.count() == 1)
        {
            log("\nThe winner is:\n${winners[0]}\n\n")
            return false
        }
        return true
    }
}
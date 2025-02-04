package com.cocherage.game

import kotlin.random.Random

class Game(
    private val maxRounds: Int = 100,
    private val aPlayer: Player = Player { RoundResult.ROCK },
    private val bPlayer: Player = Player { RoundResult.valueOf(Random.nextInt(RoundResult.entries.size)) }
) {

    fun getAScore() = aPlayer.score
    fun getBScore() = bPlayer.score

    fun play() {
        for (round in 1..maxRounds) {
            playRound()
        }
    }

    fun printResults() {
        println("Player A wins: ${aPlayer.score} of $maxRounds games")
        println("Player B wins: ${bPlayer.score} of $maxRounds games")
        println("Draws: ${maxRounds - aPlayer.score - bPlayer.score} of $maxRounds games")
    }

    fun playRound() {
        val aResult = aPlayer.play()
        val bResult = bPlayer.play()

        when {
            aResult.isWinning(bResult) -> aPlayer.incrementScore()
            bResult.isWinning(aResult) -> bPlayer.incrementScore()
        }
    }
}

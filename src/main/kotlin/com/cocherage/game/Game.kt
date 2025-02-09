package com.cocherage.game

import kotlin.random.Random

/**
 * Represents a game of Rock, Paper, Scissors between two players.
 *
 * @property maxRounds The maximum number of rounds to play in the game. Defaults to 100.
 * @property aPlayer The first player in the game. Defaults to a player that always plays ROCK.
 * @property bPlayer The second player in the game. Defaults to a player that plays randomly.
 */
class Game(
    private val maxRounds: Int = 100,
    private val aPlayer: Player = Player { RoundResult.ROCK },
    private val bPlayer: Player = Player { RoundResult.valueOf(Random.nextInt(RoundResult.entries.size)) }
) {

    /**
     * Gets the score of player A.
     * @return The score of player A.
     */
    fun getAScore() = aPlayer.score

    /**
     * Gets the score of player B.
     * @return The score of player B.
     */
    fun getBScore() = bPlayer.score

    /**
     * Plays the game for the specified number of rounds.
     */
    fun play() {
        for (round in 1..maxRounds) {
            playRound()
        }
    }

    /**
     * Prints the results of the game to the console.  Includes the number of wins for each player and the number of draws.
     */
    fun printResults() {
        println("Player A wins: ${aPlayer.score} of $maxRounds games")
        println("Player B wins: ${bPlayer.score} of $maxRounds games")
        println("Draws: ${maxRounds - aPlayer.score - bPlayer.score} of $maxRounds games")
    }

    /**
     * Plays a single round of the game.  Each player makes a move, and the winner is determined.
     * If player A wins, their score is incremented.
     * If player B wins, their score is incremented.
     * If it is a draw, neither score is incremented.
     */
    fun playRound() {
        val aResult = aPlayer.play()
        val bResult = bPlayer.play()

        when {
            aResult.isWinning(bResult) -> aPlayer.incrementScore()
            bResult.isWinning(aResult) -> bPlayer.incrementScore()
        }
    }
}
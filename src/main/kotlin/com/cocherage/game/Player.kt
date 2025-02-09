package com.cocherage.game


/**
 * Represents a player in the Rock, Paper, Scissors game.
 *
 * @property _score The player's current score.
 * @property mechanism A function that determines the player's move for a given round.
 */
class Player(private var _score: Int = 0, val mechanism: () -> RoundResult) {

    /**
     * Gets the player's score.
     * @return The player's score.
     */
    val score: Int
        get() = _score

    /**
     * Determines the player's move for the current round.
     * @return The player's move (Rock, Paper, or Scissors).
     */
    fun play(): RoundResult {
        return mechanism();
    }

    /**
     * Increments the player's score by 1.
     */
    fun incrementScore() {
        _score++
    }
}

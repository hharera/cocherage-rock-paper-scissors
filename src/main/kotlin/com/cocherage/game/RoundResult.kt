package com.cocherage.game


enum class RoundResult() {
    ROCK, PAPER, SCISSORS;

    fun isWinning(other: RoundResult): Boolean {
        return when (this) {
            ROCK -> other == SCISSORS
            PAPER -> other == ROCK
            SCISSORS -> other == PAPER
        }
    }

    companion object {
        fun valueOf(idx: Int): RoundResult {
            return entries.getOrNull(idx) ?: throw IllegalArgumentException("Invalid index: $idx")
        }
    }
}

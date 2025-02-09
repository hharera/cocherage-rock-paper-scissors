package com.cocherage.game


/**
 * Represents the possible results of a round of Rock, Paper, Scissors.
 */
enum class RoundResult() {
    ROCK, PAPER, SCISSORS;

    /**
     * Determines if this result wins against the other result.
     *
     * @param other The other result to compare against.
     * @return True if this result wins against the other result, false otherwise.
     */
    fun isWinning(other: RoundResult): Boolean {
        return when (this) {
            ROCK -> other == SCISSORS
            PAPER -> other == ROCK
            SCISSORS -> other == PAPER
        }
    }

    companion object {
        /**
         * Gets a RoundResult by its index in the enum.
         *
         * @param idx The index of the RoundResult to get.
         * @return The RoundResult at the specified index.
         * @throws IllegalArgumentException if the index is invalid.
         */
        fun valueOf(idx: Int): RoundResult {
            return entries.getOrNull(idx) ?: throw IllegalArgumentException("Invalid index: $idx")
        }
    }
}

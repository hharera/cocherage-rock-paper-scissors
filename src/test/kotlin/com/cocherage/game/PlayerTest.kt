package com.cocherage.game

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class PlayerTest {

    @Test
    fun givenPlayer_withRock_shouldReturnRock() {
        val player = Player { RoundResult.ROCK }
        assertEquals(RoundResult.ROCK, player.play())
    }
}
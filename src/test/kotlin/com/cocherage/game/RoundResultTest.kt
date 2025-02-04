package com.cocherage.game

import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class RoundResultTest {

    @Test
    fun givenRock_withRock_shouldReturnFalse() {
        assertFalse(RoundResult.ROCK.isWinning(RoundResult.ROCK))
    }

    @Test
    fun givenRock_withPaper_shouldReturnFalse() {
        assertFalse(RoundResult.ROCK.isWinning(RoundResult.PAPER))
    }

    @Test
    fun givenRock_withScissors_shouldReturnTrue() {
        assertTrue(RoundResult.ROCK.isWinning(RoundResult.SCISSORS))
    }

    @Test
    fun givenPaper_withRock_shouldReturnTrue() {
        assertTrue(RoundResult.PAPER.isWinning(RoundResult.ROCK))
    }

    @Test
    fun givenPaper_withPaper_shouldReturnFalse() {
        assertFalse(RoundResult.PAPER.isWinning(RoundResult.PAPER))
    }

    @Test
    fun givenPaper_withScissors_shouldReturnFalse() {
        assertFalse(RoundResult.PAPER.isWinning(RoundResult.SCISSORS))
    }

    @Test
    fun givenScissors_withRock_shouldReturnFalse() {
        assertFalse(RoundResult.SCISSORS.isWinning(RoundResult.ROCK))
    }

    @Test
    fun givenScissors_withPaper_shouldReturnTrue() {
        assertTrue(RoundResult.SCISSORS.isWinning(RoundResult.PAPER))
    }

    @Test
    fun givenScissors_withScissors_shouldReturnFalse() {
        assertFalse(RoundResult.SCISSORS.isWinning(RoundResult.SCISSORS))
    }

    @Test
    fun given0_shouldReturnRock() {
        assertEquals(RoundResult.ROCK, RoundResult.valueOf(0))
    }

    @Test
    fun given1_shouldReturnPaper() {
        assertEquals(RoundResult.PAPER, RoundResult.valueOf(1))
    }

    @Test
    fun given2_shouldReturnScissors() {
        assertEquals(RoundResult.SCISSORS, RoundResult.valueOf(2))
    }

    @Test
    fun given3_shouldReturnScissors() {
        assertThrows<IllegalArgumentException> {
            RoundResult.valueOf(3)
        }
    }
}
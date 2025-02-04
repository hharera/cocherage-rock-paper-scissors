package com.cocherage.game

import io.mockk.mockk
import io.mockk.verify
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GameTest {

    private val originalOut = System.out
    private lateinit var outContent: ByteArrayOutputStream

    @BeforeTest
    fun setUpStreams() {
        outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
    }

    @AfterTest
    fun restoreStreams() {
        System.setOut(originalOut)
    }


    @Test
    fun givenPaperAndRock_whenPlay_shouldIncrementBScoreByMaxRound() {
        val maxRounds = 10
        val game = Game(
            maxRounds = maxRounds,
            aPlayer = Player { RoundResult.PAPER },
            bPlayer = Player { RoundResult.ROCK }
        )

        game.play()

        assertEquals(maxRounds, game.getAScore())
        assertEquals(0, game.getBScore())
    }

    @Test
    fun givenPaperAndRock_whenPlayRound_shouldIncrementAScore() {
        val game = Game(
            maxRounds = 1,
            aPlayer = Player { RoundResult.PAPER },
            bPlayer = Player { RoundResult.ROCK }
        )

        game.playRound()

        assertEquals(1, game.getAScore())
        assertEquals(0, game.getBScore())
    }

    @Test
    fun givenPaperAndRock_whenPlayRound_shouldIncrementBScore() {
        val game = Game(
            maxRounds = 1,
            aPlayer = Player { RoundResult.ROCK },
            bPlayer = Player { RoundResult.PAPER },
        )

        game.playRound()

        assertEquals(0, game.getAScore())
        assertEquals(1, game.getBScore())
    }

    @Test
    fun givenRockAndRock_whenPlayRound_shouldNotIncrementScore() {
        val game = Game(
            maxRounds = 1,
            aPlayer = Player { RoundResult.ROCK },
            bPlayer = Player { RoundResult.ROCK },
        )

        game.playRound()

        assertEquals(0, game.getAScore())
        assertEquals(0, game.getBScore())
    }

    @Test
    fun givenPlayers_whenPlayRound_shouldCallPlay() {
        val aPlayer = mockk<Player>(relaxed = true)
        val bPlayer = mockk<Player>(relaxed = true)

        val game = Game(
            maxRounds = 1,
            aPlayer = aPlayer,
            bPlayer = bPlayer
        )

        game.playRound()

        verify { aPlayer.play() }
        verify { bPlayer.play() }
    }

    @Test
    fun givenGame_whenPrintResults_shouldPrintCorrectResults() {
        val game = Game(
            maxRounds = 3,
            aPlayer = Player { RoundResult.ROCK },
            bPlayer = Player { RoundResult.SCISSORS }
        )

        game.play()
        game.printResults()

        val expectedOutput = """
            Player A wins: 3 of 3 games
            Player B wins: 0 of 3 games
            Draws: 0 of 3 games
        """.trimIndent()

        assertEquals(expectedOutput, outContent.toString().trim())
    }

    @Test
    fun givenGameWithDraws_whenPrintResults_shouldPrintCorrectResults() {
        val game = Game(
            maxRounds = 3,
            aPlayer = Player { RoundResult.ROCK },
            bPlayer = Player { RoundResult.ROCK }
        )

        game.play()
        game.printResults()

        val expectedOutput = """
            Player A wins: 0 of 3 games
            Player B wins: 0 of 3 games
            Draws: 3 of 3 games
        """.trimIndent()

        assertEquals(expectedOutput, outContent.toString().trim())
    }
}
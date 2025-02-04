package com.cocherage.game

class Player(private var _score: Int = 0, val mechanism: () -> RoundResult) {

    val score: Int
        get() = _score

    fun play(): RoundResult {
        return mechanism();
    }

    fun incrementScore() {
        _score++
    }
}

package com.example.a1lesson3.ui;

import com.example.a1lesson3.data.Card;
import com.example.a1lesson3.data.Game;

import java.util.List;

public class EmogiGame {

    private final Game<String> game;

    public EmogiGame() {
        List<String > content = List.of("\uD83D\uDE08","\uD83D\uDE32","\uD83D\uDE0E");
        game = new Game<>(content);
    }

    public void choose(Card<String> card){
        game.choose(card);
    }

    public List<Card<String>> getCards(){
        return game.getCards();
    }
}

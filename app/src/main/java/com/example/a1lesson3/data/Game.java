package com.example.a1lesson3.data;

import android.util.Log;

import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {

    private List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> contents){
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false,false,contents.get(i),i * 1));
            cards.add(new Card<>(false,false,contents.get(i),i*2+1));
        }
        Collections.shuffle(cards);
    }
    public void choose(Card<CardContent> card){
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()){
            findPairs(card);
        }
    }
    public void findPairs(Card<CardContent> card){
        for (Card<CardContent> searchCard: cards){
            if (searchCard.isFaceUp()
                    &&searchCard.getId() != card.getId()
                    && searchCard.equals(card)){
               searchCard.setMatched(true);
               card.setMatched(true);
               cards.remove(searchCard);
               cards.remove(card);
            return;
            }
        }
    }

    public List<Card<CardContent>> getCards(){
        return cards;
    }

}

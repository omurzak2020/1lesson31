package com.example.a1lesson3.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.a1lesson3.R;
import com.example.a1lesson3.data.Card;

import java.util.List;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener{

    private RecyclerView recyclerView;
    private EmojiAdapter adapter;
    private EmogiGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_cards);
        game = new EmogiGame();
        adapter = new EmojiAdapter(game,this);
        recyclerView.setAdapter(adapter);
      /*  adapter = new EmojiAdapter(game, new EmojiAdapter.Listener() {
            @Override
            public void cardClick(Card<String> card) {

            }
        });*/
    }

    @Override
    public void cardClick(Card<String> card) {
        game.choose(card);
        adapter.notifyDataSetChanged();
    }
}
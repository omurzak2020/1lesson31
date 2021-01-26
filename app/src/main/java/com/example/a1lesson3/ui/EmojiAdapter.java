package com.example.a1lesson3.ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a1lesson3.R;
import com.example.a1lesson3.data.Card;

import java.util.List;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    private final EmogiGame game;
    private final Listener listener;

    public EmojiAdapter(EmogiGame game, Listener listener) {
        this.game = game;
        this.listener = listener;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view,parent,false);
        return new EmojiHolder(view,listener);
    }


    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.bind(game.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }

    public class EmojiHolder extends RecyclerView.ViewHolder {

        private Listener listener;
        private TextView tvCard;

        public EmojiHolder(@NonNull View itemView, Listener listener) {
            super(itemView);
            this.listener = listener;
            tvCard = itemView.findViewById(R.id.tv_card);
        }
        public void bind(Card<String> card){

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.cardClick(card);
                }
            });
                    if (card.isFaceUp()){
                        tvCard.setBackgroundColor(Color.BLUE);
                        tvCard.setText(card.getContent());
                    }else {
                        tvCard.setBackgroundResource(R.drawable.ic_launcher_background);
                        tvCard.setText("");
                    }
        }
    }
    interface Listener{
        void cardClick(Card<String> card);
    }
}

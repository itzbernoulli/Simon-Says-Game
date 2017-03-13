package com.oyinloyeayodeji.www.simonsaysgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ayo on 13/03/2017.
 */

public class HighScoreAdapter extends ArrayAdapter<HighScore> {
    public HighScoreAdapter(Context context, List<HighScore> highscores) {
        super(context, 0, highscores);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.highscore_list_item,parent,false
            );
        }

        HighScore currentHighScore = getItem(position);

        TextView nameView = (TextView)listItemView.findViewById(R.id.highScoreName);
        nameView.setText(currentHighScore.getmName());

        TextView scoreView = (TextView)listItemView.findViewById(R.id.highScore);
        scoreView.setText(currentHighScore.getmScore());

        return listItemView;
    }
}

package com.oyinloyeayodeji.www.simonsaysgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HighScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        ArrayList<HighScore>  high = new ArrayList<>();
        high.add(new HighScore("Ayodeji",90));
        high.add(new HighScore("Joshua",50));
        high.add(new HighScore("Maggie",45));

        ListView highScoreListView = (ListView)findViewById(R.id.highscore_list);

        HighScoreAdapter adapter = new HighScoreAdapter(this, high);

        highScoreListView.setAdapter(adapter);
    }
}

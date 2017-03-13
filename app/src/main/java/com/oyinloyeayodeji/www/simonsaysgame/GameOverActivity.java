package com.oyinloyeayodeji.www.simonsaysgame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class GameOverActivity extends AppCompatActivity {
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        pref = getSharedPreferences("SCORE",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        int overallHighScore = pref.getInt("highScoreValue",0);
        int newScore = pref.getInt("score",0);
        String playerName = pref.getString("Player","name");

        if (pref.contains("highScoreValue")){
            if (overallHighScore < newScore){
                editor.putString("highScoreName",playerName);
                editor.putInt("highScoreValue",newScore);
                editor.commit();
                Toast.makeText(this,"New Highscore " + playerName + " , " + newScore, Toast.LENGTH_LONG).show();
            }else{
                int score = pref.getInt("Score",0);
                Toast.makeText(this,"You didn't exceed the Present Highscore " + playerName + " , " + score, Toast.LENGTH_LONG).show();
            }
        }else{
            int score = pref.getInt("Score",0);
            Toast.makeText(this,"New Highscore of " + score + " set by " + playerName, Toast.LENGTH_LONG).show();
            editor.putInt("highScoreValue",score);
            editor.commit();
        }


    }
}

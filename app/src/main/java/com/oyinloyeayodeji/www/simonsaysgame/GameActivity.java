package com.oyinloyeayodeji.www.simonsaysgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    SharedPreferences pref;
    ArrayList<String> buttonsClicked = new ArrayList<String>();
    ArrayList<String> rand = new ArrayList<String>();

    String buttonsToggledString = "";
    String buttonsClickedString = "";
    Button redButton,blueButton,yellowButton,greenButton,trigger,restart;
    TextView instructions, notice;
    Boolean continueGame = true;
    int lastRandomNum = 0;
    int rounds = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        pref = getSharedPreferences("SCORE",MODE_PRIVATE);
        final String playerName =  pref.getString("Player","nothing");
        SharedPreferences.Editor editor = pref.edit();
        //editor.putInt("Score", anewScore);
        editor.commit();

        redButton = (Button)findViewById(R.id.red);
        blueButton = (Button)findViewById(R.id.blue);
        yellowButton = (Button)findViewById(R.id.yellow);
        greenButton = (Button)findViewById(R.id.green);
        trigger = (Button)findViewById(R.id.trigger);
        restart = (Button)findViewById(R.id.restart);

        instructions = (TextView)findViewById(R.id.instructions);
        notice = (TextView)findViewById(R.id.notice);

        trigger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedStrings();
                generatedStrings();
                if(buttonsClickedString.equals(buttonsToggledString)){
                    rounds++;
                    notice.setText("Good Job " + playerName +"!!!");
                    onStart();
                }else{
                    notice.setText("aaargh " + playerName + " You Loose!!!");
                    restart.setVisibility(View.VISIBLE);
                }
                buttonsClicked = new ArrayList<>();
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsClicked.add("A");
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsClicked.add("B");
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsClicked.add("C");
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonsClicked.add("D");
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();

        for(int j=0; j< rounds; j++){
            generateRandomArrayList();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                modifyColors(rand, 0);
            }
        },1000);
        instructions.setText("Welcome to Round " + rounds);
    }

    public String generatedStrings(){
        buttonsClickedString = "";
        for (String s : buttonsClicked)
        {
            buttonsClickedString += s + "\t";
        }
        return buttonsClickedString;
    }

    public String clickedStrings(){
        buttonsToggledString = "";
        for (String s : rand)
        {
            buttonsToggledString += s + "\t";
        }
        return buttonsToggledString;
    }

    public void modifyColors(final List<String> list, int position){
        final int nextPosition = position;
        final Button myButton = switchButtons(list.get(nextPosition));
        myButton.setAlpha(0f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switchButtons(list.get(nextPosition)).setAlpha(1.0f);
                if(nextPosition < list.size()-1){
                    modifyColors(list,nextPosition + 1);
                }else{

                }
            }
        },1500);
    }

    public Button switchButtons(String i){
        Button toggleButton = null;
            switch (i) {
                case "A":
                    toggleButton = redButton;
                    break;
                case "B":
                    toggleButton = blueButton;
                    break;
                case "C":
                    toggleButton = yellowButton;
                    break;
                case "D":
                    toggleButton = greenButton;
                    break;
                default:
                    break;
            }
        return toggleButton;
    }

    public ArrayList<String> generateRandomArrayList(){
        Random randomNumber = new Random();
        int num = randomNumber.nextInt(4) + 1;
        if(lastRandomNum != num) {
            switch (num) {
                case 1:
                    rand.add("A");
                    lastRandomNum = num;
                    break;
                case 2:
                    rand.add("B");
                    lastRandomNum = num;
                    break;
                case 3:
                    rand.add("C");
                    lastRandomNum = num;
                    break;
                case 4:
                    rand.add("D");
                    lastRandomNum = num;
                    break;
                default:
                    break;
            }
        }else{
            generateRandomArrayList();
        }
        return rand;
    }
}

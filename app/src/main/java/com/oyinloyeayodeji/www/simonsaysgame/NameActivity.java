package com.oyinloyeayodeji.www.simonsaysgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {
    SharedPreferences preferences;
    EditText nameText;
    Button startGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameText = (EditText)findViewById(R.id.enterName);
        startGame = (Button)findViewById(R.id.startGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences = getSharedPreferences("SCORE",MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                String name = nameText.getText().toString();

                if (name.isEmpty()){
                    Toast.makeText(NameActivity.this,"Please input a name", Toast.LENGTH_LONG).show();
                }else{
                    editor.putString("Player",name);
                    editor.commit();

                    Intent i= new Intent( NameActivity.this, GameActivity.class);
                    startActivity(i);
                }

            }
        });


    }
}

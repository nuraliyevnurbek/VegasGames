package com.example.vegasgames;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView AboutGame;
    TextView TextName;
    TextView Developer;

    String aboutGame;
    String textName;
    String developer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextName=(TextView)findViewById(R.id.textName);
        textName="Welcome to our game VEGAS100 !!!";
        TextName.setText(textName);

        AboutGame=(TextView)findViewById(R.id.aboutGame);
        aboutGame="The rules of the Vegas100 are very common.Game is played by" +
                " 2 people and every time they can put dices one by one.Every "+
                " their scores are calculated automatically.Player who gain more" +
                "then 100 will be winer of the game!";
        AboutGame.setText(aboutGame);

        Developer=(TextView)findViewById(R.id.me);
        developer=" nurbek.nuraliyev@inbox.ru";
        Developer.setText(developer);


    }


    public void Play(View view){
        Intent main2=new Intent(this,Main2Activity.class);
        startActivity(main2);
    }
}

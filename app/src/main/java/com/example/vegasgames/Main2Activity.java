package com.example.vegasgames;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView jeckpot1;
    ImageView jeckpot2;
    ImageView jeckpot3;

    TextView p1;
    TextView p2;
    TextView player;

    int playerNumber=1;
    int playerScore1=0;
    int playerScore2=0;
    int randomNumber;
    int clickNumber1=0;
    int clickNumber2=0;
    int winnerScore;
    int winnerClickNumber;
    int jeckpotCount;
    int jeckpotBonus;
    int jeckpotActive=0;
    int buyJeckpotActive=0;
    int gainer;
    int playerActivate=1;


    String winner;
    Random random = new Random();
    Button letsGo;
    Button buyJackpot;

    int[] photoArray={R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main2);
         img1=(ImageView)findViewById(R.id.dice1);
        img2=(ImageView)findViewById(R.id.dice2);
        img3=(ImageView)findViewById(R.id.dice3);
        img4=(ImageView)findViewById(R.id.dice4);
        jeckpot1=(ImageView)findViewById(R.id.jackpot1);
        jeckpot2=(ImageView)findViewById(R.id.jackpot2);
        jeckpot3=(ImageView)findViewById(R.id.jackpot3);

        p1=(TextView)findViewById(R.id.p1);
        p2=(TextView)findViewById(R.id.p2);
        player=(TextView)findViewById(R.id.players);

        letsGo=(Button)findViewById(R.id.letsGo);
        buyJackpot=(Button)findViewById(R.id.buyJackpot);



    }

    public void letsGo(View view){

        jeckpot1.setImageResource(R.drawable.jackpot);
        jeckpot2.setImageResource(R.drawable.jackpot);
        jeckpot3.setImageResource(R.drawable.jackpot);

        if (playerNumber!=0 && playerActivate!=0) {
            jeckpotActive =1;
            buyJeckpotActive=1;

            if (playerNumber == 1) {

                clickNumber1++;
                gainer=0;

                randomNumber = random.nextInt(4);
                img1.setImageResource(photoArray[randomNumber]);
                playerScore1 = playerScore1 + randomNumber;
                gainer=gainer+randomNumber;

                randomNumber = random.nextInt(4);
                img2.setImageResource(photoArray[randomNumber]);
                playerScore1 = playerScore1 + randomNumber;
                gainer=gainer+randomNumber;

                randomNumber = random.nextInt(4);
                img3.setImageResource(photoArray[randomNumber]);
                playerScore1 = playerScore1 + randomNumber;
                gainer=gainer+randomNumber;

                randomNumber = random.nextInt(4);
                img4.setImageResource(photoArray[randomNumber]);
                playerScore1 = playerScore1 + randomNumber + 4;
                gainer=gainer+randomNumber+4;

                p1.setText("P1:" + playerScore1);
                playerNumber = 2;
                Toast.makeText(getApplicationContext(),"Dice : " + gainer,Toast.LENGTH_SHORT).show();


            } else {
                    clickNumber2++;
                    gainer=0;

                randomNumber = random.nextInt(4);
                img1.setImageResource(photoArray[randomNumber]);
                playerScore2 = playerScore2 + randomNumber;
                gainer=gainer+randomNumber;

                randomNumber = random.nextInt(4);
                img2.setImageResource(photoArray[randomNumber]);
                playerScore2 = playerScore2 + randomNumber;
                gainer=gainer+randomNumber;

                randomNumber = random.nextInt(4);
                img3.setImageResource(photoArray[randomNumber]);
                playerScore2 = playerScore2 + randomNumber;
                gainer=gainer+randomNumber;

                randomNumber = random.nextInt(4);
                img4.setImageResource(photoArray[randomNumber]);
                playerScore2 = playerScore2 + randomNumber + 4;
                gainer=gainer+randomNumber+4;

                p2.setText("P2:" + playerScore2);
                playerNumber = 1;
                Toast.makeText(getApplicationContext(),"Dice : "+gainer,Toast.LENGTH_SHORT).show();

            }

            playerActivate=0;
        }

        if(playerScore1 >=100 || playerScore2>=100 || playerNumber==0){
            jeckpotActive=0;
            buyJeckpotActive=0;
            playerNumber=0;
            p1.setVisibility(View.INVISIBLE);
            p2.setVisibility(View.INVISIBLE);
            buyJackpot.setVisibility(View.INVISIBLE);


            if(playerScore2>=100){
                winner="PLAYER2 !";
                winnerScore=playerScore2;
                winnerClickNumber=clickNumber2;
            }
            else{
                winner="PLAYER1 !";
                winnerScore=playerScore1;
                winnerClickNumber=clickNumber1;
            }

            new AlertDialog.Builder(this)
                    .setTitle(" WINNER IS " + winner)
                    .setMessage("       Your Score : "+ winnerScore  +
                            " after "+ winnerClickNumber+ " times       clicking!!!")
                    .setNegativeButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            playerScore1=0;
                            playerScore2=0;
                            playerNumber=1;
                            clickNumber1=0;
                            clickNumber2=0;

                            p1.setText("P1:"+playerScore1);
                            p2.setText("P2:"+playerScore2);
                            player.setText("Player"+playerNumber);


                            p1.setVisibility(View.VISIBLE);
                            p2.setVisibility(View.VISIBLE);

                        }
                    })
                    .show();
        }


    }

    public void buyJackpot(View view){
        if (buyJeckpotActive==1) {

            jeckpot1.setImageResource(R.drawable.jeckpotwin);
            jeckpot2.setImageResource(R.drawable.jeckpotwin);
            jeckpot3.setImageResource(R.drawable.jeckpotwin);

            while (jeckpotBonus < 5) {
                jeckpotBonus = random.nextInt(10);
            }

            if (playerNumber == 2) {
                playerScore1 = playerScore1 + jeckpotBonus - 7;
                p1.setText("P1:" + playerScore1);
                player.setText("Player" + playerNumber);

            }

            if (playerNumber == 1) {
                playerScore2 = playerScore2 + jeckpotBonus - 7;
                p2.setText("P2:" + playerScore2);
                player.setText("Player" + playerNumber);
            }

            Toast.makeText(getApplicationContext(),"Bought Jeckpot : "+jeckpotBonus,Toast.LENGTH_SHORT).show();
        }

        jeckpotActive=0;
        buyJeckpotActive=0;
        playerActivate=1;
    }


    public void playJeckpot(View view){
        if(jeckpotActive==1) {

            jeckpotCount = random.nextInt(3);
            if (jeckpotCount == 1) {
                    jeckpotBonus=10;


                jeckpot1.setImageResource(R.drawable.jeckpotwin);
                jeckpot2.setImageResource(R.drawable.jeckpotwin);
                jeckpot3.setImageResource(R.drawable.jeckpotwin);
            } else {
                jeckpotBonus = -2;

                jeckpot1.setImageResource(R.drawable.fail);
                jeckpot2.setImageResource(R.drawable.fail);
                jeckpot3.setImageResource(R.drawable.fail);

            }


            if (playerNumber == 2) {
                playerScore1 = playerScore1 + jeckpotBonus;
                p1.setText("P1:" + playerScore1);
                player.setText("Player" + playerNumber);

            }

            if (playerNumber == 1) {
                playerScore2 = playerScore2 + jeckpotBonus;
                p2.setText("P2:" + playerScore2);
                player.setText("Player" + playerNumber);
            }

            Toast.makeText(getApplicationContext(),"Won Jeckpot : "+jeckpotBonus,Toast.LENGTH_SHORT).show();
        }


        jeckpotActive = 0;
        buyJeckpotActive=0;
        playerActivate=1;
    }



}

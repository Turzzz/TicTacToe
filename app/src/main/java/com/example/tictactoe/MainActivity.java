package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int boxcounter = 1;
    Button[] bt = new Button[10];
    boolean gameover = false;
    int player1score,player2score = 0;
    TextView player1scoreTV,player2scoreTV;
    Button restartbt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 1; i <= 9; i++) {
            String allbox = "box" + String.valueOf(i);
            int resID = getResources().getIdentifier(allbox, "id", getPackageName());
            bt[i] = findViewById(resID);
            bt[i].setOnClickListener(this);
            bt[i].setTextSize(60);
        }

        player1scoreTV = findViewById(R.id.player1scoreID);
        player2scoreTV = findViewById(R.id.player2scoreID);

        restartbt = findViewById(R.id.RestartID);
        restartbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });
    }

    @Override
    public void onClick(View v) {

        if(((Button) v).getText().toString().equals("") && gameover == false){
            if(boxcounter%2 == 1){
//                ((Button) v).setTextSize(26);
                ((Button) v).setText("X");
                boxcounter++;
                wincheckfunction();
            }
            else{
                ((Button) v).setText("O");
                boxcounter++;
                wincheckfunction();
            }
        }

    }

    public void wincheckfunction(){

        String[] boxField = new String[10];
        int i;

        for (i = 1; i<=9; i++) {
            boxField[i] = bt[i].getText().toString();
        }

          if(
              boxField[1].equals(boxField[2]) && boxField[1].equals(boxField[3]) && !boxField[1].equals("") ||
              boxField[4].equals(boxField[5]) && boxField[4].equals(boxField[6]) && !boxField[4].equals("") ||
              boxField[7].equals(boxField[8]) && boxField[7].equals(boxField[9]) && !boxField[7].equals("") ||
              boxField[1].equals(boxField[4]) && boxField[1].equals(boxField[7]) && !boxField[1].equals("") ||
              boxField[2].equals(boxField[5]) && boxField[2].equals(boxField[8]) && !boxField[2].equals("") ||
              boxField[3].equals(boxField[6]) && boxField[3].equals(boxField[9]) && !boxField[3].equals("") ||
              boxField[1].equals(boxField[5]) && boxField[1].equals(boxField[9]) && !boxField[1].equals("") ||
              boxField[3].equals(boxField[5]) && boxField[3].equals(boxField[7]) && !boxField[3].equals("")
          ){

                  if(boxcounter%2 == 1) {
                      Toast.makeText(this, "Player Two WIN !!!", Toast.LENGTH_SHORT).show();
                      gameover = true;
                      player2score++;
                      player2scoreTV.setText("Player 2: " + Integer.toString(player2score));
                  }
                  else{
                      Toast.makeText(this, "Player One WIN !!!", Toast.LENGTH_SHORT).show();
                      gameover = true;
                      player1score++;
                      player1scoreTV.setText("Player 1: " + Integer.toString(player1score));

                  }
          }

          else{
              if(boxcounter == 10){
                  Toast.makeText(this, "DRAW !!!", Toast.LENGTH_SHORT).show();
                  gameover = true;
              }
          }

        }

    public void restart(){
        boxcounter = 1;
        gameover = false;
        for (int i = 1; i <= 9; i++) {
            String allbox = "box" + String.valueOf(i);
            int resID = getResources().getIdentifier(allbox, "id", getPackageName());
            bt[i] = findViewById(resID);
            bt[i].setText("");
        }
    }








}

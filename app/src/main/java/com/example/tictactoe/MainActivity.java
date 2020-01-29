package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int boxcounter = 1;
    Button[] bt = new Button[10];


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
    }

    @Override
    public void onClick(View v) {

        if(((Button) v).getText().toString().equals("")){
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

        for (int i = 1; i<=9; i++) {
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

                  if(boxcounter%2 == 1){
                   Toast.makeText(this, "Two jitche", Toast.LENGTH_SHORT).show();
                  }
                  else{
                      Toast.makeText(this, "one jitche", Toast.LENGTH_SHORT).show();
                  }
          }

          else{
              if(boxcounter == 10){
                  Toast.makeText(this, "Draw Vai", Toast.LENGTH_SHORT).show();
              }
          }

        }



}

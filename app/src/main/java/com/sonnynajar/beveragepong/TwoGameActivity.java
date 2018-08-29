package com.sonnynajar.beveragepong;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class TwoGameActivity extends AppCompatActivity {

    Button action1,action2;
    String p1,p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_game);

        action1 = findViewById(R.id.player1);
        action2 = findViewById(R.id.player2);
        p1 = getIntent().getExtras().getString("ValueP1");
        p2 = getIntent().getExtras().getString("ValueP2");
        action1.setText(p1);
        action2.setText(p2);
    }

    public void shootAction(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(TwoGameActivity.this);
        String shootingPlayer = "?";
        if (view.getId() == R.id.player1) {
            shootingPlayer = action1.getText().toString();
        } else if (view.getId() == R.id.player2){
            shootingPlayer = action2.getText().toString();
        }

        builder.setTitle(shootingPlayer + " shoots..");
        builder.setIcon(R.drawable.cup_and_ball_ico);
        builder.setMessage("Did the ball go in?");
        final String player = shootingPlayer;
        builder.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(getApplicationContext(),"Miss!",Toast.LENGTH_LONG).show();
                        scoreAction(false, player);
                    }
                });
        builder.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        scoreAction(true, player);
                    }
                });
        builder.setNeutralButton("CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Not their turn.",Toast.LENGTH_LONG).show();
                    }
                });

        builder.show();
    }

    public void scoreAction(boolean didScore, String player) {

        AlertDialog.Builder builder = new AlertDialog.Builder(TwoGameActivity.this);
        builder.setTitle("Score update");

        if(didScore){
            builder.setIcon(R.drawable.good_shot_ico);
            builder.setMessage("Was it the drinking cup?");

            builder.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            chooseCup();
                        }
                    });
            builder.setPositiveButton("YES!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int which) {
                            gameOver();
                        }
                    });
            builder.setNeutralButton("CANCEL",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"Canceled.",Toast.LENGTH_LONG).show();
                        }
                    });

        } else {
            String[] inOptions = new String[]{"Missed Table", "Bounced Out", "Deflected!"};
            builder.setIcon(R.drawable.bad_shot_ico);
            builder.setItems(inOptions, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    if(which == 0){
                        Toast.makeText(TwoGameActivity.this, "You suck :(", Toast.LENGTH_SHORT).show();
                    } else if(which == 1){
                        Toast.makeText(TwoGameActivity.this,"Good try...", Toast.LENGTH_SHORT).show();
                    } else if(which == 2){
                        deflectedBy();
                    }

                }
            }) ;
            builder.create();
        }

        builder.show();
    }

    public void chooseCup() {
        Toast.makeText(TwoGameActivity.this,"What cup did it land on?", Toast.LENGTH_SHORT).show();
    }

    public void deflectedBy() {
        Toast.makeText(TwoGameActivity.this,"You got schooled!", Toast.LENGTH_SHORT).show();
    }

    public void gameOver() {
        Toast.makeText(TwoGameActivity.this,"You lose!", Toast.LENGTH_SHORT).show();
    }



}

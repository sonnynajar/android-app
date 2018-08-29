package com.sonnynajar.beveragepong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FourNamesActivity extends AppCompatActivity {

    Button btn;
    EditText p1,p2,p3,p4;
    String s1,s2,s3,s4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_names);
    }

    public void start2v2Game(View view) {
        btn = findViewById(R.id.twoVtwo);
        p1 = findViewById(R.id.player1);
        p2 = findViewById(R.id.player2);
        p3 = findViewById(R.id.player3);
        p4 = findViewById(R.id.player4);
        s1 = p1.getText().toString();
        s2 = p2.getText().toString();
        s3 = p3.getText().toString();
        s4 = p4.getText().toString();

        Intent intent = new Intent(this, FourGameActivity.class);
        intent.putExtra("ValueP1", s1);
        intent.putExtra("ValueP2", s2);
        intent.putExtra("ValueP3", s3);
        intent.putExtra("ValueP4", s4);
        startActivity(intent);
    }
}

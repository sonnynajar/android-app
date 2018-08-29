package com.sonnynajar.beveragepong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FourGameActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4;
    String p1,p2,p3,p4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_game);

        tv1 = findViewById(R.id.player1);
        tv2 = findViewById(R.id.player2);
        tv3 = findViewById(R.id.player2);
        tv4 = findViewById(R.id.player4);
        p1 = getIntent().getExtras().getString("ValueP1");
        p2 = getIntent().getExtras().getString("ValueP2");
        p3 = getIntent().getExtras().getString("ValueP3");
        p4 = getIntent().getExtras().getString("ValueP4");
        tv1.setText(p1);
        tv2.setText(p2);
        tv3.setText(p3);
        tv4.setText(p4);
    }
}

package com.sonnynajar.beveragepong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TwoNamesActivity extends AppCompatActivity {

    Button btn;
    EditText p1,p2;
    String s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_names);
    }

    public void start1v1Game(View view) {
        btn = findViewById(R.id.oneVone);
        p1 = findViewById(R.id.player1);
        p2 = findViewById(R.id.player2);
        s1 = p1.getText().toString();
        s2 = p2.getText().toString();

        Intent intent = new Intent(this, TwoGameActivity.class);
        intent.putExtra("ValueP1", s1);
        intent.putExtra("ValueP2", s2);
        startActivity(intent);
    }
}

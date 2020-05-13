package com.example.jo_bhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Single_game_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_game_result);
        Intent intent=getIntent();
        String winner=intent.getStringExtra("winner");
        TextView t=(TextView)findViewById(R.id.textView2);
        ImageView i=(ImageView)findViewById(R.id.imageView);
        t.setText(winner);
        if(winner=="You win !!")
            i.setBackgroundColor(getResources().getColor(R.color.green));
        else if(winner=="You lose !!")
            i.setBackgroundColor(getResources().getColor(R.color.red));

    }
}

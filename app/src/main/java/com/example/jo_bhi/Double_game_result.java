package com.example.jo_bhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Double_game_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_game_result);
        TextView e=(TextView)findViewById(R.id.textView);
        Intent intent=getIntent();
        String p1_name=intent.getStringExtra("p1_name");
        String p2_name=intent.getStringExtra("p2_name");
        int score_1=intent.getIntExtra("score_p1",0);
        int score_2=intent.getIntExtra("score_p2",0);
        if(score_1>score_2)
            e.setText("Winner : "+p1_name);
        else if(score_2>score_1)
            e.setText("Winner : "+p2_name);
        else
            e.setText("DRAW");
    }
}

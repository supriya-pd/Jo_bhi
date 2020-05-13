package com.example.jo_bhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class Double_mode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_mode);
        EditText p1_name=(EditText)findViewById(R.id.name);
        EditText p2_name=(EditText)findViewById(R.id.p2_name);
        EditText rounds=(EditText)findViewById(R.id.rounds_no);

        String name_1=p1_name.getText().toString();
        String name_2=p2_name.getText().toString();
        int no_of_rounds=Integer.parseInt(rounds.getText().toString());
        Intent intent =new Intent(Double_mode.this,double_game.class);
        intent.putExtra("p1_name",name_1);
        intent.putExtra("p2_name",name_2);
        intent.putExtra("rounds",no_of_rounds);
        startActivity(intent);
    }
}

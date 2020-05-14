package com.example.jo_bhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Double_mode extends AppCompatActivity {
    int no_of_rounds;
    String name_1,name_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_mode);
        EditText p1_name=(EditText)findViewById(R.id.name);
        EditText p2_name=(EditText)findViewById(R.id.p2_name);
        EditText rounds=(EditText)findViewById(R.id.rounds_no);
        Button b=(Button)findViewById(R.id.button_d_submit);

         name_1=p1_name.getText().toString();
         name_2=p2_name.getText().toString();
try {
     no_of_rounds = Integer.parseInt(rounds.getText().toString());
}catch (NumberFormatException e){}
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent =new Intent(Double_mode.this,double_game.class);
        intent.putExtra("p1_name",name_1);
        intent.putExtra("p2_name",name_2);
        intent.putExtra("rounds",no_of_rounds);
        startActivity(intent);

    }
});

    }
}

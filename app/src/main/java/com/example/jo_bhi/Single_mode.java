package com.example.jo_bhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Single_mode extends AppCompatActivity {
    int no_of_rounds;
    String name_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_mode);
        EditText p1_name=(EditText)findViewById(R.id.name);
        Button b=(Button)findViewById(R.id.button_s_submit);
        EditText rounds=(EditText)findViewById(R.id.s_rounds_no);

         name_1=p1_name.getText().toString();
try{
        no_of_rounds=Integer.parseInt(rounds.getText().toString());
}
catch (NumberFormatException e){}


b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(Single_mode.this,single_game.class);
        intent.putExtra("p1_name",name_1);

        intent.putExtra("rounds",no_of_rounds);
        startActivity(intent);

    }
});


    }
}

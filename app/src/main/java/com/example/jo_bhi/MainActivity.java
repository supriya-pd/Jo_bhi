package com.example.jo_bhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void open_single_player_mode(View v){
        Intent intent=new Intent(MainActivity.this,Single_mode.class);
        startActivity(intent);
    }
    public void open_double_player_mode(View v){
Intent intent=new Intent(MainActivity.this,Double_mode.class);
startActivity(intent);
    }


}

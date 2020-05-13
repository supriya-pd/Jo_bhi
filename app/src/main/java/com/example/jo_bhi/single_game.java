package com.example.jo_bhi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class single_game extends AppCompatActivity {
    String p1_name;
    int no_of_rounds;
    int random_number;
    TextView score_1,score_2;
    Button submit;
    RadioGroup p1,p2;
    RadioButton rb_p1,rb_p2;
    int selected_1,selected_2;
    int score_p1=0;
    int score_p2=0;
String winner;
    int times=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_game);
        Intent intent=getIntent();
        p1_name=intent.getStringExtra("p1_name");
        no_of_rounds=intent.getIntExtra("rounds",0);
        Random random=new Random();
        random_number=random.nextInt(3);

        TextView p1=(TextView)findViewById(R.id.s_p1);
        TextView p2=(TextView)findViewById(R.id.s_p2);
        p1.setText(p1_name);
        p2.setText("Computer");
        ButtonListener();


    }

    public void ButtonListener(){

        score_1 =(TextView)findViewById(R.id.s_score_1);
        score_2 =(TextView)findViewById(R.id.s_score_2);
        p1=(RadioGroup)findViewById(R.id.s_p1_options);
        p2=(RadioGroup)findViewById(R.id.s_p2_options);
        submit=(Button)findViewById(R.id.s_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                times++;
                selected_1=p1.getCheckedRadioButtonId();
                rb_p1=(RadioButton)findViewById(selected_1);
                selected_2=p2.getCheckedRadioButtonId();


                switch(random_number){
                    case 0:selected_2=R.id.s_p2_paper;
                    break;
                    case 1:selected_2=R.id.s_p2_rock;
                        break;
                    case 2:selected_2=R.id.s_p2_scissor;
                        break;
                }

               // Toast.makeText(single_game.this,Integer.toString(selected_1)+"\n"+Integer.toString(selected_2),Toast.LENGTH_SHORT).show();
               int difference=selected_2-selected_1;

                switch(difference){
                    case -176:
                    case 53:
                    case -2:
                        Toast.makeText(single_game.this,"Draw",Toast.LENGTH_SHORT).show();
                        break;
                    case 13:
                    case -49:
                    case 9:
                        score_p2++;
                        score_1.setText("Computer : "+Integer.toString(score_p2));
                        break;
                    case -87:
                    case -38:
                    case 98:score_p1++;
                        score_2.setText(p1_name+" : "+Integer.toString(score_p1));
                        break;
                }

                if(times==no_of_rounds){
                    Intent intent=new Intent(single_game.this,Single_game_result.class);
                   if(score_p1>score_p2)
                       winner="You win !!";
                   else if(score_p1<score_p2)
                       winner="You lose !!";
                           else
                               winner="It's a draw !!";
                           intent.putExtra("winner",winner);
                    startActivity(intent);

                }
            }
        });
    }

}

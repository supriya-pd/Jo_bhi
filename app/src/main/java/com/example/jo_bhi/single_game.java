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

import static com.example.jo_bhi.Single_mode.EXTRA_INT;
import static com.example.jo_bhi.Single_mode.EXTRA_NAME_A;

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
    Random random=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_game);
        Intent intent=getIntent();
        p1_name=intent.getStringExtra(EXTRA_NAME_A);
        no_of_rounds=intent.getIntExtra(EXTRA_INT,0);

        random_number=random.nextInt(3);

        TextView p1=(TextView)findViewById(R.id.s_p1);
        TextView p2=(TextView)findViewById(R.id.s_p2);
        try{
        p1.setText(p1_name);
        p2.setText("Computer");
        score_1.setText(p1_name+" : "+Integer.toString(score_p1));
        score_2.setText("Computer : "+Integer.toString(score_p2));}
        catch(RuntimeException re){}
        ButtonListener();


    }

    public void ButtonListener(){
        no_of_rounds=5;

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

                if((selected_1==R.id.s_p1_paper && selected_2==R.id.s_p2_paper )|| (selected_1==R.id.s_p1_rock && selected_2==R.id.s_p2_rock )||(selected_1==R.id.s_p1_scissor && selected_2==R.id.s_p2_scissor )){
                    Toast.makeText(single_game.this,"Draw",Toast.LENGTH_SHORT).show();
                }
                else if((selected_1==R.id.s_p1_paper && selected_2==R.id.s_p2_rock )|| (selected_1==R.id.s_p1_rock && selected_2==R.id.s_p2_scissor )||(selected_1==R.id.s_p1_scissor && selected_2==R.id.s_p2_paper ))
                {
                    score_p1++;
                    score_1.setText(p1_name+" : "+Integer.toString(score_p1));
                }
                else{
                    score_p2++;
                    score_2.setText("Computer : "+Integer.toString(score_p2));
                }
                random_number=random.nextInt(3);


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

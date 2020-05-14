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

public class double_game extends AppCompatActivity {

    TextView score_1,score_2;
    Button submit;
    RadioGroup p1,p2;
    RadioButton rb_p1,rb_p2;
    int selected_1,selected_2;
    int score_p1=0;
    int score_p2=0;
    int no_of_rounds;
    int times=0;
    String p1_name;
    String p2_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_game);
        Intent intent=getIntent();
         p1_name=intent.getStringExtra("p1_name");
         p2_name=intent.getStringExtra("p2_name");
         no_of_rounds=intent.getIntExtra("rounds",0);
        TextView p1=(TextView)findViewById(R.id.p1);
        TextView p2=(TextView)findViewById(R.id.p2);
        try{p1.setText(p1_name);
        p2.setText(p2_name);
        score_1.setText(p1_name+" : "+Integer.toString(score_p1));
        score_2.setText(p2_name+" : "+Integer.toString(score_p2));}
        catch(RuntimeException re){}
        ButtonListener();


    }

    public void ButtonListener(){
        no_of_rounds=5;

        score_1 =(TextView)findViewById(R.id.score_1);
        score_2 =(TextView)findViewById(R.id.score_2);
        p1=(RadioGroup)findViewById(R.id.p1_options);
        p2=(RadioGroup)findViewById(R.id.p2_options);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                times++;
                selected_1=p1.getCheckedRadioButtonId();
                rb_p1=(RadioButton)findViewById(selected_1);
                selected_2=p2.getCheckedRadioButtonId();
                rb_p2=(RadioButton)findViewById(selected_2);
                // Toast.makeText(MainActivity.this,Integer.toString(selected_1)+"\n"+Integer.toString(selected_2),Toast.LENGTH_SHORT).show();

if((selected_1==R.id.p1_paper && selected_2==R.id.p2_paper )|| (selected_1==R.id.p1_rock && selected_2==R.id.p2_rock )||(selected_1==R.id.p1_scissor && selected_2==R.id.p2_scissor )){
    Toast.makeText(double_game.this,"Draw\n"+Integer.toString(times),Toast.LENGTH_SHORT).show();
}
else if((selected_1==R.id.p1_paper && selected_2==R.id.p2_rock )|| (selected_1==R.id.p1_rock && selected_2==R.id.p2_scissor )||(selected_1==R.id.p1_scissor && selected_2==R.id.p2_paper ))
{
    score_p1++;
    score_1.setText(p1_name+" : "+Integer.toString(score_p1));
}
else{
    score_p2++;
    score_2.setText(p2_name+" : "+Integer.toString(score_p2));
}
      if(times==no_of_rounds){
Intent intent=new Intent(double_game.this,Double_game_result.class);
intent.putExtra("score_p1",score_p1);
intent.putExtra("score_p2",score_p2);
intent.putExtra("p1_name",p1_name);
           intent.putExtra("p2_name",p2_name);
           startActivity(intent);

}
            }
        });
    }



}



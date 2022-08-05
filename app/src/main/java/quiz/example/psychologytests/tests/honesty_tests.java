package quiz.example.psychologytests.tests;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.MainActivity;
import quiz.example.psychologytests.qw.level1Qw;

public class honesty_tests extends AppCompatActivity {
    Button buttonYes;
    Button buttonBack;
    Button buttonNo;
    TextView textViewQw;
    int count = 0;
    int index = 0;
    Dialog dialog;


private  level1Qw[] level1Qw1 = new level1Qw[]{
       new level1Qw(true, R.string.level1qw1),
       new level1Qw(false, R.string.level1qw2),
       new level1Qw(true, R.string.level1qw3),
       new level1Qw(false, R.string.level1qw4),
       new level1Qw(true, R.string.level1qw5),
       new level1Qw(true, R.string.level1qw6),
       new level1Qw(false, R.string.level1qw7) ,
       new level1Qw(true, R.string.level1qw8) ,
       new level1Qw(true, R.string.level1qw9) ,
       new level1Qw(true, R.string.level1qw10) ,
       new level1Qw(true, R.string.level1qw11) ,
       new level1Qw(true, R.string.level1qw12) ,
       new level1Qw(false, R.string.level1qw13) ,
       new level1Qw(true, R.string.level1qw14) ,
       new level1Qw(true, R.string.level1qw15) ,
       new level1Qw(true, R.string.level1qw16) ,
       new level1Qw(true, R.string.level1qw17) ,
       new level1Qw(true, R.string.level1qw18) ,
       new level1Qw(true, R.string.level1qw19) ,
       new level1Qw(true, R.string.level1qw20) ,
       new level1Qw(true, R.string.level1qw21) ,
       new level1Qw(true, R.string.level1qw22) ,
       new level1Qw(true, R.string.level1qw23) ,
       new level1Qw(true, R.string.level1qw24) ,
       new level1Qw(true, R.string.level1qw25) ,
       new level1Qw(false, R.string.level1qw26) ,
       new level1Qw(false, R.string.level1qw27) ,
       new level1Qw(true, R.string.level1qw28) ,
       new level1Qw(true, R.string.level1qw29) ,
       new level1Qw(true, R.string.level1qw30) ,
       new level1Qw(true, R.string.level1qw31) ,
       new level1Qw(true, R.string.level1qw32) ,
       new level1Qw(true, R.string.level1qw33)
};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        buttonYes = findViewById(R.id.buttonYes);
        buttonNo = findViewById(R.id.buttonNo);
        textViewQw = findViewById(R.id.textView);
        buttonBack = findViewById(R.id.buttonBack);

        textViewQw.setText(level1Qw1[index].getNumberQw());
        buttonBack.setVisibility(View.GONE);
        buttonBack.setClickable(false);
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialog.setCancelable(false);
        Button btncontinue1 = dialog.findViewById(R.id.buttondiolog);
        dialog.show();

        btncontinue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnswerClock(true);

            }
        });
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnswerClock(false);

            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(honesty_tests.this, MainActivity.class);
              startActivity(intent);
              finish();
            }
        });

    }

    private void AnswerClock(boolean answer) {

        index++;
        if(index ==33){
            if (count<=5){
                textViewQw.setText(R.string.level1_oneAnswer);
                buttonYes.setVisibility(View.GONE);
                buttonYes.setClickable(false);
                buttonNo.setVisibility(View.GONE);
                buttonNo.setClickable(false);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);

            }
             else if (count>5 &&count <=13){
                textViewQw.setText(R.string.level1_twoAnswer);
                buttonYes.setVisibility(View.GONE);
                buttonYes.setClickable(false);
                buttonNo.setVisibility(View.GONE);
                buttonNo.setClickable(false);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);

            }
            else if (count>13 &&count <=29){
                textViewQw.setText(R.string.level1_threeAnswer);
             // Answer answer1 = new Answer();
               // answer1.setOtvet(R.string.level1_threeAnswer);
                //Intent intent = new Intent(level1.this, Answer.class);
                //startActivity(intent);
                //finish();

                buttonYes.setVisibility(View.GONE);
                buttonYes.setClickable(false);
                buttonNo.setVisibility(View.GONE);
                buttonNo.setClickable(false);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);


            }
            else if (count>29 &&count <=34){
                textViewQw.setText(R.string.level1_fourAnswer);
                buttonYes.setVisibility(View.GONE);
                buttonYes.setClickable(false);
                buttonNo.setVisibility(View.GONE);
                buttonNo.setClickable(false);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);

            }
        }else if (answer == level1Qw1[index].isAnswer()){
            textViewQw.setText(level1Qw1[index].getNumberQw());
            count++;

        }else {
            textViewQw.setText(level1Qw1[index].getNumberQw());
        }
    }


}

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

import quiz.example.psychologytests.qw.ObservationQw;
import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.MainActivity;

public class Observation_tests extends AppCompatActivity {

    Button buttonBack;

    TextView textViewQw;
    TextView textViewQw_one;
    TextView textViewQw_two;
    TextView textViewQw_free;
    int count = 0;
    int index = 0;
    Dialog dialog;

ObservationQw obs = new ObservationQw();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observation);

        textViewQw = findViewById(R.id.textView);
        buttonBack = findViewById(R.id.buttonBack);
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialog.setCancelable(false);
        Button btncontinue1 = dialog.findViewById(R.id.buttondiolog);
       // dialog.show();

        btncontinue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });

        buttonBack.setVisibility(View.GONE);
        buttonBack.setClickable(false);
        textViewQw_one = findViewById(R.id.textView1);
        textViewQw_two=findViewById(R.id.textView2);
        textViewQw_free =findViewById(R.id.textView3);

        textViewQw_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count +10;
                AnswerClock();

            }
        });

        textViewQw_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count +5;
                AnswerClock();

            }
        });

        textViewQw_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count = count +3;
                AnswerClock();

            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent = new Intent(Observation_tests.this, MainActivity.class);
              startActivity(intent);
              finish();
            }
        });
    }


    private void AnswerClock() {

        index++;

        if(index ==14){
            textViewQw_one.setVisibility(View.GONE);
            textViewQw_two.setVisibility(View.GONE);
            textViewQw_free.setVisibility(View.GONE);
            if (count<=74){
                textViewQw.setText(R.string.observation_threeAnswer);

                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);

            }
             else if (count>75 &&count <=99){
                textViewQw.setText(R.string.observation_twoAnswer);

                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);
            }

            else if (count>100 &&count <=150){
                textViewQw.setText(R.string.observation_oneAnswer);
             // Answer answer1 = new Answer();
               // answer1.setOtvet(R.string.level1_threeAnswer);
                //Intent intent = new Intent(level1.this, Answer.class);
                //startActivity(intent);
                //finish();
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);

            }
            else if (count>29 &&count <=34){
                textViewQw.setText(R.string.level1_fourAnswer);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);
            }
        }else {
           // textViewQw.setText(Qw[index]);
            textViewQw_one.setText(obs.oneText_10[index]);
            textViewQw_two.setText(obs.oneText_5[index]);
            textViewQw_free.setText(obs.oneText_3[index]);
            textViewQw.setText(obs.observationQw[index]);
        }

        }
    }




package quiz.example.psychologytests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Observation_tests extends AppCompatActivity {
    Button buttonYes;
    Button buttonBack;
    Button buttonNo;
    TextView textViewQw;
    TextView textViewQw_one;
    TextView textViewQw_two;
    TextView textViewQw_free;
    int count = 0;
    int index = 0;







ObservationQw obs = new ObservationQw();
private  ObservationQw[] observationQws = new ObservationQw[]{



};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observation);


        textViewQw = findViewById(R.id.textView);
        buttonBack = findViewById(R.id.buttonBack);


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
              Intent intent = new Intent(Observation_tests.this,MainActivity.class);
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
                textViewQw.setText(R.string.level1_oneAnswer);

                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);

            }
             else if (count>75 &&count <=99){
                textViewQw.setText(R.string.level1_twoAnswer);


                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);



            }
            else if (count>100 &&count <=150){
                textViewQw.setText(R.string.level1_threeAnswer);
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




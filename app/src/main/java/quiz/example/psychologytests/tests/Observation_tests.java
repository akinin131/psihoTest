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

import quiz.example.psychologytests.activityTest.Room.AppDatabase;
import quiz.example.psychologytests.activityTest.Room.User;
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


    TextView numberQwTextView;
    TextView voprosTextView;
    TextView vopros1TextView;
    TextView vopros2TextView;
    int numberQw = 1;

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
        TextView btnconсclose = dialog.findViewById(R.id.btnclose);
        TextView textView1 = dialog.findViewById(R.id.text);
        textView1.setText(R.string.observationqw_dialog);

        numberQwTextView = findViewById(R.id.numberQW);
        voprosTextView = findViewById(R.id.vopros);
        vopros1TextView = findViewById(R.id.vopros1);
        vopros2TextView = findViewById(R.id.vopros2);


        btncontinue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
        dialog.show();

        btnconсclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Observation_tests.this, MainActivity.class);
                startActivity(intent);
                finish();
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
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);

            }
        });

        textViewQw_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count +5;
                AnswerClock();
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);

            }
        });

        textViewQw_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count = count +3;
                AnswerClock();
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);

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

    public void saveNewUser(int firstName, int lastName) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        db.userDao().insertUser(user);
    }


    private void AnswerClock() {

        index++;

        if(index ==15){
            textViewQw_one.setVisibility(View.GONE);
            textViewQw_two.setVisibility(View.GONE);
            textViewQw_free.setVisibility(View.GONE);
            numberQwTextView.setVisibility(View.GONE);
            numberQwTextView.setClickable(false);

            voprosTextView.setClickable(false);
            voprosTextView.setVisibility(View.GONE);

            vopros1TextView.setClickable(false);
            vopros1TextView.setVisibility(View.GONE);

            vopros2TextView.setClickable(false);
            vopros2TextView.setVisibility(View.GONE);

            saveNewUser(R.string.Mindfulness_Test,R.string.Mindfulnessqw);
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
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);

            }
            else if (count>29 &&count <=34){
                textViewQw.setText(R.string.level1_fourAnswer);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);
            }
        }else {
            textViewQw_one.setText(obs.oneText_10[index]);
            textViewQw_two.setText(obs.oneText_5[index]);
            textViewQw_free.setText(obs.oneText_3[index]);
            textViewQw.setText(obs.observationQw[index]);
        }

        }
    }




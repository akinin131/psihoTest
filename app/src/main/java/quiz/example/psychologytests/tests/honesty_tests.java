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
import quiz.example.psychologytests.activityTest.Room.AppDatabase;
import quiz.example.psychologytests.activityTest.Room.User;
import quiz.example.psychologytests.qw.level1Qw;

public class honesty_tests extends AppCompatActivity {
    Button buttonYes;
    Button buttonBack;
    Button buttonNo;
    TextView textViewQw;
    TextView numberQwTextView;
    TextView voprosTextView;
    TextView vopros1TextView;
    TextView vopros2TextView;
    int count = 0;
    int index = 0;
    int numberQw = 1;
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
        numberQwTextView = findViewById(R.id.numberQW);
        voprosTextView = findViewById(R.id.vopros);
        vopros1TextView = findViewById(R.id.vopros1);
        vopros2TextView = findViewById(R.id.vopros2);
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
        TextView btnconсclose = dialog.findViewById(R.id.btnclose);
        TextView textView1 = dialog.findViewById(R.id.text);
        textView1.setText(R.string.Test_honesty_dialog);
        //dialog.show();

        btncontinue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });
        btnconсclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(honesty_tests.this, MainActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();

            }
        });
        dialog.show();

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnswerClock(true);
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);


            }
        });
        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnswerClock(false);
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);
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
    public void saveNewUser(int firstName, int lastName) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        db.userDao().insertUser(user);
    }

    private void AnswerClock(boolean answer) {

        index++;
        if(index ==33){
            numberQwTextView.setVisibility(View.GONE);
            numberQwTextView.setClickable(false);

            voprosTextView.setClickable(false);
            voprosTextView.setVisibility(View.GONE);

            vopros1TextView.setClickable(false);
            vopros1TextView.setVisibility(View.GONE);

            vopros2TextView.setClickable(false);
            vopros2TextView.setVisibility(View.GONE);

            saveNewUser(R.string.Honesty_test,R.string.Hotestyqw);
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

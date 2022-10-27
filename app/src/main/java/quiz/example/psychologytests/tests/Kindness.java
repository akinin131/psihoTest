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
import quiz.example.psychologytests.qw.KindnessQw;

public class Kindness extends AppCompatActivity {
    Button buttonYes;
    Button buttonBack;
    Button buttonNo;
    TextView textViewQw;
    int count = 0;
    int index = 0;
    Dialog dialog;


    TextView numberQwTextView;
    TextView voprosTextView;
    TextView vopros1TextView;
    TextView vopros2TextView;
    int numberQw = 1;




    private KindnessQw[] kindnessQws = new KindnessQw[]{
            new KindnessQw(true, R.string.kindness1),
            new KindnessQw(false, R.string.kindness2),
            new KindnessQw(true, R.string.kindness3),
            new KindnessQw(true, R.string.kindness4),
            new KindnessQw(false, R.string.kindness5),
            new KindnessQw(false, R.string.kindness6),
            new KindnessQw(true, R.string.kindness7),
            new KindnessQw(false, R.string.kindness8),
            new KindnessQw(false, R.string.kindness9),
            new KindnessQw(false, R.string.kindness10),
            new KindnessQw(true, R.string.kindness11),
            new KindnessQw(false, R.string.kindness12),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kindenss);

        buttonYes = findViewById(R.id.buttonYes);
        buttonNo = findViewById(R.id.buttonNo);
        textViewQw = findViewById(R.id.textView);
        buttonBack = findViewById(R.id.buttonBack);

        numberQwTextView = findViewById(R.id.numberQW);
        voprosTextView = findViewById(R.id.vopros);
        vopros1TextView = findViewById(R.id.vopros1);
        vopros2TextView = findViewById(R.id.vopros2);


        textViewQw.setText(kindnessQws[index].getNumberQw());
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
        textView1.setText(R.string.kindness_dialog);
        dialog.show();


        btncontinue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnconсclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Kindness.this, MainActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
            }
        });

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
                Intent intent = new Intent(Kindness.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void saveNewUser(String firstName, String lastName) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        db.userDao().insertUser(user);
    }


    private void AnswerClock(boolean answer) {

        index++;
        if (index == 12) {

            numberQwTextView.setVisibility(View.GONE);
            numberQwTextView.setClickable(false);

            voprosTextView.setClickable(false);
            voprosTextView.setVisibility(View.GONE);

            vopros1TextView.setClickable(false);
            vopros1TextView.setVisibility(View.GONE);

            vopros2TextView.setClickable(false);
            vopros2TextView.setVisibility(View.GONE);
            saveNewUser("Тест на честность","12 вопросов");

            if (count < 4) {
                textViewQw.setText(R.string.kindness_threeAnswer);
                buttonYes.setVisibility(View.GONE);
                buttonYes.setClickable(false);
                buttonNo.setVisibility(View.GONE);
                buttonNo.setClickable(false);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);

            } else if (count >= 4 && count <= 8) {
                textViewQw.setText(R.string.kindness_twoAnswer);
                buttonYes.setVisibility(View.GONE);
                buttonYes.setClickable(false);
                buttonNo.setVisibility(View.GONE);
                buttonNo.setClickable(false);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);

            } else if (count > 8) {
                textViewQw.setText(R.string.kindness_oneAnswer);
                buttonYes.setVisibility(View.GONE);
                buttonYes.setClickable(false);
                buttonNo.setVisibility(View.GONE);
                buttonNo.setClickable(false);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);
            }

        } else if (answer == kindnessQws[index].isAnswer()) {
            textViewQw.setText(kindnessQws[index].getNumberQw());
            count++;

        } else {
            textViewQw.setText(kindnessQws[index].getNumberQw());
        }
    }

}

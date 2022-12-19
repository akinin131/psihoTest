package quiz.example.psychologytests.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.MainActivity;
import quiz.example.psychologytests.activityTest.Room.AppDatabase;
import quiz.example.psychologytests.activityTest.Room.User;
import quiz.example.psychologytests.activityTest.stateadapter.StateHaracter;
import quiz.example.psychologytests.qw.TemperamentQw;

public class Temperament extends AppCompatActivity {
    Button buttonBack;

    TextView textViewQwMelanholik;
    TextView textViewQw_one;
    TextView textViewQw_two;
    TextView textViewQw_free;
    TextView textViewQw;
    float countHalerik = 0;
    float countSangvinik = 0;
    float  countFlegmatik = 0;
    float  countMelanholik = 0;
    float  index = 0;

    TextView numberQwTextView;
    TextView voprosTextView;
    TextView vopros1TextView;
    TextView vopros2TextView;
    int numberQw = 1;

    Dialog dialog;
    TemperamentQw obs = new TemperamentQw();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperament);

        textViewQwMelanholik = findViewById(R.id.textView4);
        textViewQw = findViewById(R.id.textViewQW);
        buttonBack = findViewById(R.id.buttonBack);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialog.setCancelable(false);
        Button btncontinue1 = dialog.findViewById(R.id.buttondiolog);
        TextView btnconсclose = dialog.findViewById(R.id.btnclose);
        TextView textView1 = dialog.findViewById(R.id.text);
        textView1.setText(R.string.test_temperament);

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
        btnconсclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Temperament.this, MainActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
            }
        });

        buttonBack.setVisibility(View.GONE);
        buttonBack.setClickable(false);
        textViewQw_one = findViewById(R.id.textViewQ);
        textViewQw_two = findViewById(R.id.textView2);
        textViewQw_free = findViewById(R.id.textView3);

        dialog.show();

        textViewQw_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countHalerik++;
                AnswerClock();
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);

            }
        });

        textViewQw_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countSangvinik++;
                AnswerClock();
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);

            }
        });

        textViewQw_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                countFlegmatik++;
                AnswerClock();
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);

            }
        });
        textViewQwMelanholik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                countMelanholik++;
                AnswerClock();
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Temperament.this, MainActivity.class);
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

    @SuppressLint("SetTextI18n")
    private void AnswerClock() {

        index++;

        if (index>=20) {

            numberQwTextView.setVisibility(View.GONE);
            numberQwTextView.setClickable(false);

            voprosTextView.setClickable(false);
            voprosTextView.setVisibility(View.GONE);

            vopros1TextView.setClickable(false);
            vopros1TextView.setVisibility(View.GONE);

            vopros2TextView.setClickable(false);
            vopros2TextView.setVisibility(View.GONE);

            buttonBack.setClickable(true);
            buttonBack.setVisibility(View.VISIBLE);
            countFlegmatik = (countFlegmatik / 20) * 100;
            countMelanholik = (countMelanholik / 20) * 100;
            countSangvinik = (countSangvinik / 20) * 100;
            countHalerik = (countHalerik / 20) * 100;
            String.format("%.1f", countMelanholik);
            String.format("%.1f", countFlegmatik);
            String.format("%.1f", countSangvinik);
            String.format("%.1f", countHalerik);
            textViewQw_one.setText(textViewQw_one.getContext().getString(R.string.flegmatik, (int)countFlegmatik)+"%");
            textViewQw_two.setText(textViewQw_two.getContext().getString(R.string.melancholic, (int)countMelanholik)+"%");
            textViewQw_free.setText(textViewQw_free.getContext().getString(R.string.sanguine, (int)countSangvinik)+"%");
            textViewQwMelanholik.setText(textViewQwMelanholik.getContext().getString(R.string.Choleric, (int)countHalerik)+"%");
            textViewQw.setText(R.string.resTemperament);


            textViewQw_one.setClickable(false);
            textViewQw_two.setClickable(false);
            textViewQw_free.setClickable(false);
            textViewQwMelanholik.setClickable(false);
            textViewQw.setClickable(false);


            saveNewUser(R.string.Temperament_Test,R.string.Temperamentqw);

        } else {
            textViewQw_one.setText(obs.oneText_Halerik[(int) index]);
            textViewQw_two.setText(obs.oneText_Sangvinik[(int) index]);
            textViewQw_free.setText(obs.oneText_Flegmatik[(int) index]);
            textViewQwMelanholik.setText(obs.oneText_Melanholik[(int) index]);
        }
    }
}



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
import quiz.example.psychologytests.activityTest.FragmentActivity.Izbrannoe;
import quiz.example.psychologytests.activityTest.Room.AppDatabase;
import quiz.example.psychologytests.activityTest.Room.User;
import quiz.example.psychologytests.qw.EntrepreneurTestQw;
import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.MainActivity;

public class EntrepreneurTest extends AppCompatActivity {

    Button buttonBack;
    TextView textViewQw;
    TextView textViewQw_one;
    TextView textViewQw_two;
    TextView textViewQw_free;
    TextView textViewQw_four;

    TextView numberQwTextView;
    TextView voprosTextView;
    TextView vopros1TextView;
    TextView vopros2TextView;

    int numberQw = 1;
    Izbrannoe izbrannoe = new Izbrannoe ();
    int count = 0;
    int index = 0;
    Dialog dialog;
    EntrepreneurTestQw entrepreneurTestQw = new EntrepreneurTestQw();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrepreneur_test);

        textViewQw = findViewById(R.id.textView);
        buttonBack = findViewById(R.id.buttonBack);

        buttonBack.setVisibility(View.GONE);
        buttonBack.setClickable(false);
        textViewQw_one = findViewById(R.id.textView1);
        textViewQw_two=findViewById(R.id.textView2);
        textViewQw_free =findViewById(R.id.textView3);
        textViewQw_four =findViewById(R.id.textView4);

        numberQwTextView = findViewById(R.id.numberQW);
        voprosTextView = findViewById(R.id.vopros);
        vopros1TextView = findViewById(R.id.vopros1);
        vopros2TextView = findViewById(R.id.vopros2);

        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // прозрачный фон диалогового окна
        dialog.setCancelable(false);
        Button btncontinue1 = dialog.findViewById(R.id.buttondiolog);
        TextView btnconсclose = dialog.findViewById(R.id.btnclose);
        TextView textView1 = dialog.findViewById(R.id.text);
        textView1.setText(R.string.Entrepreneur_dialog);
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
                Intent intent = new Intent(EntrepreneurTest.this, MainActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
            }
        });

        textViewQw_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count +4;
                AnswerClock();
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);
            }
        });

        textViewQw_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count +3;
                AnswerClock();
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);
            }
        });

        textViewQw_free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count +2;
                AnswerClock();
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);
            }
        });

        textViewQw_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count = count +1;
                AnswerClock();
                numberQw++;
                String b = String.valueOf(numberQw);
                numberQwTextView.setText(b);
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EntrepreneurTest.this, MainActivity.class);
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

    private void AnswerClock() {
        index++;

        if(index == 6){
            textViewQw_one.setVisibility(View.GONE);
            textViewQw_two.setVisibility(View.GONE);
            textViewQw_free.setVisibility(View.GONE);
            textViewQw_four.setVisibility(View.GONE);

            numberQwTextView.setVisibility(View.GONE);
            numberQwTextView.setClickable(false);

            voprosTextView.setClickable(false);
            voprosTextView.setVisibility(View.GONE);

            vopros1TextView.setClickable(false);
            vopros1TextView.setVisibility(View.GONE);

            vopros2TextView.setClickable(false);
            vopros2TextView.setVisibility(View.GONE);
            saveNewUser("Тест на богатство","7 вопросов");

            if (count<=12){
                textViewQw.setText(R.string.EntrepreneurAnswer12);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);
            }

            else if (count>=13 &&count <=16){
                textViewQw.setText(R.string.EntrepreneurAnswer13_16);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);
            }

            else if (count>=17 &&count <=20){
                textViewQw.setText(R.string.EntrepreneurAnswer17_20);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);
                numberQwTextView.setVisibility(View.GONE);
                numberQwTextView.setClickable(false);
            }
            else if (count>=21 &&count <=24){
                textViewQw.setText(R.string.EntrepreneurAnswer21_24);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);
                numberQwTextView.setVisibility(View.GONE);
                numberQwTextView.setClickable(false);
            }
            else if (count>=25 &&count <=28){
                textViewQw.setText(R.string.EntrepreneurAnswer25_28);
                buttonBack.setVisibility(View.VISIBLE);
                buttonBack.setClickable(true);
                numberQwTextView.setVisibility(View.GONE);
                numberQwTextView.setClickable(false);
            }

        }else {
            textViewQw_one.setText(entrepreneurTestQw.oneText_4[index]);
            textViewQw_two.setText(entrepreneurTestQw.oneText_3[index]);
            textViewQw_free.setText(entrepreneurTestQw.oneText_2[index]);
            textViewQw_four.setText(entrepreneurTestQw.oneText_1[index]);
            textViewQw.setText(entrepreneurTestQw.EntrepreneurQw[index]);
        }
    }
    }
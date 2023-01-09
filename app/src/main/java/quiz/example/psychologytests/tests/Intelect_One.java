package quiz.example.psychologytests.tests;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.MainActivity;
import quiz.example.psychologytests.activityTest.Room.AppDatabase;
import quiz.example.psychologytests.activityTest.Room.User;
import quiz.example.psychologytests.qw.IntelectOneAnswer;

public class Intelect_One extends AppCompatActivity {

    Button buttonBack;

    TextView textViewQw;
    TextView numberQwTextView;
    TextView voprosTextView;
    TextView vopros1TextView;
    TextView vopros2TextView;

    TextView textViewQw_one;
    TextView textViewQw_two;
    TextView textViewQw_free;

    int count = 0;
    int countQW = 1;
    int index1 = 0;
    int index2 = 1;
    int index3 = 2;
    int numberQw = 0;
    Dialog dialog;
    int res = 0;
    IntelectOneAnswer IntelectOne1 = new IntelectOneAnswer();

    private IntelectOneAnswer[] IntelectOne = new IntelectOneAnswer[]{
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_1_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_1_2),
            new IntelectOneAnswer(true,R.string.IntelectOne_qw_1_3),

            new IntelectOneAnswer(true,R.string.IntelectOne_qw_2_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_2_2),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_2_3),

            new IntelectOneAnswer(false,R.string.IntelectOne_qw_3_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_3_2),
            new IntelectOneAnswer(true,R.string.IntelectOne_qw_3_3),

            new IntelectOneAnswer(true,R.string.IntelectOne_qw_4_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_4_2),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_4_3),

            new IntelectOneAnswer(false,R.string.IntelectOne_qw_5_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_5_2),
            new IntelectOneAnswer(true,R.string.IntelectOne_qw_5_3),

            new IntelectOneAnswer(false,R.string.IntelectOne_qw_6_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_6_2),
            new IntelectOneAnswer(true,R.string.IntelectOne_qw_6_3),

            new IntelectOneAnswer(false,R.string.IntelectOne_qw_7_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_7_2),
            new IntelectOneAnswer(true,R.string.IntelectOne_qw_7_3),

            new IntelectOneAnswer(true,R.string.IntelectOne_qw_8_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_8_2),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_8_3),

            new IntelectOneAnswer(false,R.string.IntelectOne_qw_9_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_9_2),
            new IntelectOneAnswer(true,R.string.IntelectOne_qw_9_3),

            new IntelectOneAnswer(true,R.string.IntelectOne_qw_10_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_10_2),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_10_3),

            new IntelectOneAnswer(true,R.string.IntelectOne_qw_11_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_11_2),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_11_3),

            new IntelectOneAnswer(false,R.string.IntelectOne_qw_12_1),
            new IntelectOneAnswer(false,R.string.IntelectOne_qw_12_2),
            new IntelectOneAnswer(true,R.string.IntelectOne_qw_12_3),
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intelect_one);

        //textViewQw = findViewById(R.id.textView);
        buttonBack = findViewById(R.id.buttonBack);
        numberQwTextView = findViewById(R.id.numberQW);
        voprosTextView = findViewById(R.id.textView1);
        vopros1TextView = findViewById(R.id.textView2);
        vopros2TextView = findViewById(R.id.textView32);
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
        textView1.setText(R.string.IntelectOnedialog);
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
                Intent intent = new Intent(Intelect_One.this, MainActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
            }
        });

        Log.d("MyLOg","index"+index1);
        Log.d("MyLOg","index"+index2);
        Log.d("MyLOg","index"+index3);

        voprosTextView.setText(IntelectOne[index1].getNumberQw());
        vopros1TextView.setText(IntelectOne[index2].getNumberQw());
        vopros2TextView.setText(IntelectOne[index3].getNumberQw());

        textViewQw_one = findViewById(R.id.vopros);
        textViewQw_two=findViewById(R.id.vopros1);
        textViewQw_free =findViewById(R.id.vopros2);

//        voprosTextView.setText(IntelectOne[index1].getNumberQw());
//        vopros1TextView.setText(IntelectOne[index2].getNumberQw());
//        vopros2TextView.setText(IntelectOne[index3].getNumberQw());

        voprosTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res = IntelectOne[index1].isAnswer();


                AnswerClock(res);


            }
        });

        vopros1TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res = IntelectOne[index2].isAnswer();
                AnswerClock(res);

            }
        });

        vopros2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res = IntelectOne[index3].isAnswer();
                AnswerClock(res);



            }
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intelect_One.this, MainActivity.class);
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
        index1 += 3;
        index2 += 3;
        index3 += 3;
        numberQw++;
        res++;
        countQW++;

        Log.d("MyLOg","index"+index1);
        Log.d("MyLOg","index"+index2);
        Log.d("MyLOg","index"+index3);
        if(res ==12){
            textViewQw.setText(textViewQw.getContext().getString(R.string.IntelectOneAnswer,(int)countQW));

            voprosTextView.setVisibility(View.GONE);
            vopros1TextView.setVisibility(View.GONE);
            vopros2TextView.setVisibility(View.GONE);

            voprosTextView.setClickable(false);
            vopros1TextView.setClickable(false);
            vopros2TextView.setClickable(false);

            numberQwTextView.setVisibility(View.GONE);
            numberQwTextView.setClickable(false);

            textViewQw_one.setVisibility(View.GONE);
            textViewQw_two.setVisibility(View.GONE);
            textViewQw_free.setVisibility(View.GONE);
            numberQwTextView.setVisibility(View.GONE);

            saveNewUser(R.string.Intelligence_test,R.string.Intelecttqw);


        } else if (answer){
            count++;
            voprosTextView.setText(IntelectOne[index1].getNumberQw());
            vopros1TextView.setText(IntelectOne[index2].getNumberQw());
            vopros2TextView.setText(IntelectOne[index3].getNumberQw());
            textViewQw.setText(IntelectOne1.IntelectQW[numberQw]);
            count++;
            String b = String.valueOf(countQW);
            numberQwTextView.setText(b);

        }else {
            voprosTextView.setText(IntelectOne[index1].getNumberQw());
            vopros1TextView.setText(IntelectOne[index2].getNumberQw());
            vopros2TextView.setText(IntelectOne[index3].getNumberQw());
            textViewQw.setText(IntelectOne1.IntelectQW[numberQw]);
            String b = String.valueOf(countQW);
            numberQwTextView.setText(b);
        }
    }
}
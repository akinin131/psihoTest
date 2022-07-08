package quiz.example.psychologytests;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Answer extends AppCompatActivity {
    TextView answer;
     String otvet1;

    public Answer() {

    }


    public void setOtvet(String otvet) {
        this.otvet1 = otvet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_answer);
        answer = findViewById(R.id.answer);
        answer.setText(otvet1);



    }


}
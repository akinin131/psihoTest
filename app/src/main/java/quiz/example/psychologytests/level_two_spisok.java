package quiz.example.psychologytests;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class level_two_spisok extends AppCompatActivity {

    private TextView mTextView;
    private TextView honesty_test;
    Button buttonBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_one_spisok);

        mTextView = (TextView) findViewById(R.id.text);
        buttonBack = findViewById(R.id.btn_back);
        honesty_test = findViewById(R.id.honesty_test);
        // Enables Always-on

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(level_two_spisok.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        honesty_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(level_two_spisok.this, Observation_tests.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
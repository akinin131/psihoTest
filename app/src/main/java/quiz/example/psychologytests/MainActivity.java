package quiz.example.psychologytests;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView testOnCharacter;
    ImageView testOnSposobnosti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testOnCharacter = findViewById(R.id.testOnCharacter);
        testOnSposobnosti = findViewById(R.id.testOnSposobnosti);

        testOnCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,level_one_spisok.class);
               startActivity(intent);
               finish();
            }
        });
        testOnSposobnosti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,level_two_spisok.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
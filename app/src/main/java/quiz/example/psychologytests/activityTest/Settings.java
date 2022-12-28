package quiz.example.psychologytests.activityTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import quiz.example.psychologytests.R;

public class Settings extends AppCompatActivity {

    Button btnRu;
    Button btnEn;
    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnRu = findViewById(R.id.buttonRu);
        btnEn = findViewById(R.id.buttonEn);
        btnBack = findViewById(R.id.buttonBack);

        btnRu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("ru_btn.click");
                Locale locale = new Locale("ru");
                changeLocale(locale);
            }
        });

        btnEn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("en_btn.click");
                Locale locale = new Locale("en");
                changeLocale(locale);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @SuppressWarnings("deprecation")
    private void changeLocale(Locale locale)

    {
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getBaseContext().getResources()
                .updateConfiguration(configuration,
                        getBaseContext()
                                .getResources()
                                .getDisplayMetrics());
        setTitle(R.string.app_name);

        TextView et = findViewById(R.id.textView6);
        et.setText(R.string.texttest);
        TextView et1 = findViewById(R.id.buttonBack);
        et1.setText(R.string.Back);
    }

}
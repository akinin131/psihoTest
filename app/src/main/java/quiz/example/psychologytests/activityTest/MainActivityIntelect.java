package quiz.example.psychologytests.activityTest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.FragmentActivity.Izbrannoe;
import quiz.example.psychologytests.activityTest.adapter.StateAdapterIntelect;
import quiz.example.psychologytests.activityTest.stateadapter.StateIntelect;

public class MainActivityIntelect extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    DrawerLayout drawer;
    private Toolbar toolbar;
    StateAdapterIntelect adapter;
    ArrayList<StateIntelect> states1 = new ArrayList<StateIntelect>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intelect);

        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер
        StateAdapterIntelect adapter = new StateAdapterIntelect(this, states1,this);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.draver);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void setInitialData(){
        states1.add(new StateIntelect("Тест на внимательность",  "15 Вопросов"));
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.sposobnosti) {
            Intent intent = new Intent(MainActivityIntelect.this, MainActivitySposobnosti.class);
            startActivity(intent);

        } else if (id == R.id.haracter) {
            Intent intent = new Intent(MainActivityIntelect.this, MainActivityHaracter.class);
            startActivity(intent);

        } else if (id == R.id.test_sex) {
            Intent intent = new Intent(MainActivityIntelect.this, MainActivityFamily.class);
            startActivity(intent);

        }
        else if (id == R.id.main_page) {
            Intent intent = new Intent(MainActivityIntelect.this, MainActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.izbrannoe) {
            Intent intent = new Intent(MainActivityIntelect.this, Izbrannoe.class);
            startActivity(intent);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
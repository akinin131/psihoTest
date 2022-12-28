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
import quiz.example.psychologytests.activityTest.adapter.StateAdapterEntrepreneur;
import quiz.example.psychologytests.activityTest.stateadapter.StateEntrepreneur;

public class MainActivitySposobnosti extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    private Toolbar toolbar;
    ArrayList<StateEntrepreneur> states1 = new ArrayList<StateEntrepreneur>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sposobnosti);

        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер
        StateAdapterEntrepreneur adapter = new StateAdapterEntrepreneur(this, states1,this);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        setTitle(getString(R.string.sposobnosti_item));
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
        states1.add(new StateEntrepreneur(R.string.wealth_test, R.string.wealthsqw));
        states1.add(new StateEntrepreneur(R.string.Mindfulness_Test, R.string.Mindfulnessqw));
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.main_page) {
            Intent intent = new Intent(MainActivitySposobnosti.this, MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.haracter) {
            Intent intent = new Intent(MainActivitySposobnosti.this, MainActivityHaracter.class);
            startActivity(intent);

        } else if (id == R.id.test_sex) {
            Intent intent = new Intent(MainActivitySposobnosti.this, MainActivityFamily.class);
            startActivity(intent);

        }
        else if (id == R.id.test_intelect) {
            Intent intent = new Intent(MainActivitySposobnosti.this, MainActivityIntelect.class);
            startActivity(intent);
        }
        else if (id == R.id.izbrannoe) {
            Intent intent = new Intent(MainActivitySposobnosti.this, Izbrannoe.class);
            startActivity(intent);
        }
        else if (id == R.id.settings) {
            Intent intent = new Intent(MainActivitySposobnosti.this, Settings.class);
            startActivity(intent);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
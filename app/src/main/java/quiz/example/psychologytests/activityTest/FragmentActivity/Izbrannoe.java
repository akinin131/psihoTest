package quiz.example.psychologytests.activityTest.FragmentActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import quiz.example.psychologytests.R;
import quiz.example.psychologytests.activityTest.MainActivity;
import quiz.example.psychologytests.activityTest.MainActivityFamily;
import quiz.example.psychologytests.activityTest.MainActivityHaracter;
import quiz.example.psychologytests.activityTest.MainActivityIntelect;
import quiz.example.psychologytests.activityTest.MainActivitySposobnosti;
import quiz.example.psychologytests.activityTest.Room.AppDatabase;
import quiz.example.psychologytests.activityTest.Room.User;
import quiz.example.psychologytests.activityTest.Settings;
import quiz.example.psychologytests.activityTest.UserListAdapter;


public class Izbrannoe extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private UserListAdapter userListAdapter;
    DrawerLayout drawer;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izbrannoe);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(getString(R.string.Izbrannoe));
        drawer = findViewById(R.id.draver);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        initRecyclerView();

        loadUserList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);
        recyclerView.setAdapter(userListAdapter);
        System.out.println(userListAdapter);
    }

    private void loadUserList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<User> userList = db.userDao().getAllUsers();
        userListAdapter.setUserList(userList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            loadUserList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sposobnosti) {
            Intent intent = new Intent(Izbrannoe.this, MainActivitySposobnosti.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.haracter) {
            Intent intent = new Intent(Izbrannoe.this, MainActivityHaracter.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.test_sex) {
            Intent intent = new Intent(Izbrannoe.this, MainActivityFamily.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.test_intelect) {
            Intent intent = new Intent(Izbrannoe.this, MainActivityIntelect.class);
            startActivity(intent);
            finish();

        }
         else if (id == R.id.main_page) {
            Intent intent = new Intent(Izbrannoe.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else if (id == R.id.settings) {
            Intent intent = new Intent(Izbrannoe.this, Settings.class);
            startActivity(intent);
            finish();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
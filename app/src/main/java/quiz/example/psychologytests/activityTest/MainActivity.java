package quiz.example.psychologytests.activityTest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import quiz.example.psychologytests.activityTest.FragmentActivity.Izbrannoe;
import quiz.example.psychologytests.activityTest.adapter.StateAdapterMain;
import quiz.example.psychologytests.activityTest.stateadapter.StateMain;
import quiz.example.psychologytests.R;
import quiz.example.psychologytests.fragment.fragment1;
import quiz.example.psychologytests.fragment.fragment2;
import quiz.example.psychologytests.fragment.fragment3;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final int NUM_PAGES = 3;


    DrawerLayout drawer;
    private Toolbar toolbar;


    ArrayList<StateMain> states1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.pager);
        FragmentStateAdapter pagerAdapter = new ScreenSlidePageAdapter(this);
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setPageTransformer(new ZoomOutPageTransformer());

        setTitle(getString(R.string.AllTest));

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list1);
        // создаем адаптер
        StateAdapterMain adapter = new StateAdapterMain(this, states1, this);
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

     void setInitialData() {
        states1.add(new StateMain(R.string.Honesty_test,R.string.Hotestyqw));
        states1.add(new StateMain(R.string.Mindfulness_Test,R.string.Mindfulnessqw));
        states1.add(new StateMain(R.string.Kindness_Test,R.string.Kindnessqw));
        states1.add(new StateMain(R.string.wealth_test,R.string.wealthsqw));
        states1.add(new StateMain(R.string.Temperament_Test,R.string.Temperamentqw));
        states1.add(new StateMain(R.string.Intelligence_test,R.string.Intelecttqw));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.sposobnosti) {
            Intent intent = new Intent(MainActivity.this, MainActivitySposobnosti.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.haracter) {
            Intent intent = new Intent(MainActivity.this, MainActivityHaracter.class);
            startActivity(intent);

        } else if (id == R.id.test_sex) {
            Intent intent = new Intent(MainActivity.this, MainActivityFamily.class);
            startActivity(intent);

        } else if (id == R.id.test_intelect) {
            Intent intent = new Intent(MainActivity.this, MainActivityIntelect.class);
            startActivity(intent);
        }
        else if (id == R.id.izbrannoe) {
            startActivityForResult(new Intent(MainActivity.this, Izbrannoe.class), 100);
        }
        else if (id == R.id.settings) {
            startActivityForResult(new Intent(MainActivity.this, Settings.class), 100);
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private static class ScreenSlidePageAdapter extends FragmentStateAdapter {
        public ScreenSlidePageAdapter(MainActivity mainActivity) {
            super(mainActivity);
        }

        @NonNull
        @NotNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0:
                    return new fragment1();

                case 1:
                    return new fragment2();
                case 2:
                    return new fragment3();

                default:
                    return null;
            }

        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

    private static class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @Override
        public void transformPage(@NonNull @NotNull View page, float position) {
            int pageWidth = page.getWidth();
            int pageHeight = page.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                page.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    page.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    page.setTranslationX(-horzMargin + vertMargin / 2);
                }
                // Scale the page down (between MIN_SCALE and 1)
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                page.setAlpha(MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                page.setAlpha(0f);
            }
        }

    }


}

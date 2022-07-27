package ark.noah.historymanager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import ark.noah.historymanager.data.History;
import ark.noah.historymanager.databinding.ActivityMainBinding;
import ark.noah.historymanager.fragments.main.First.PageFirstFragment;
import ark.noah.historymanager.fragments.main.Second.PageSecondFragment;
import ark.noah.historymanager.fragments.main.SectionsStateAdapter;

public class MainActivity extends AppCompatActivity {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{ R.string.tab_text_1, R.string.tab_text_2, };

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsStateAdapter sectionsStateAdapter = new SectionsStateAdapter(this);
        sectionsStateAdapter.addFragment(new PageFirstFragment());
        sectionsStateAdapter.addFragment(new PageSecondFragment());

        binding.appBarMain.viewPager.setAdapter(sectionsStateAdapter);
        new TabLayoutMediator(binding.appBarMain.tabs, binding.appBarMain.viewPager, (tab, position) -> {
            TextView tv = new TextView(MainActivity.this);
            tv.setText(TAB_TITLES[position]);
            tv.setGravity(Gravity.CENTER);
            tv.setTextAppearance(R.style.TextAppearance_Tab_Header);
            tab.setCustomView(tv);
        }).attach();

        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.fab.setOnClickListener(view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show());
        binding.DrawerRecylcer.setLayoutManager(new LinearLayoutManager(this));
        binding.DrawerRecylcer.setAdapter(
                new MainDrawerAdapter(
                        new History[] {
                                new History("test1", 0),
                                new History("test2", 1)
                        }
                )
        );
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar == null) return;
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);

        binding.DrawerRecylcer.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                int count1 = ((MainDrawerAdapter) Objects.requireNonNull(binding.DrawerRecylcer.getAdapter())).getItemCount();
                Toast.makeText(rv.getContext().getApplicationContext(), "count: " + count1, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            default:
            case android.R.id.home:
                binding.drawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), getText(R.string.settings_not_yet_implemented), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
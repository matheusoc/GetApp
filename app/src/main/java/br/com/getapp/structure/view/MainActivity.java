package br.com.getapp.structure.view;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextClock;

import br.com.getapp.R;
import br.com.getapp.structure.view.fragment.CallTimePicker;
import br.com.getapp.structure.view.adapter.TabAdapter;
import br.com.getapp.structure.view.fragment.ListFragment;
import br.com.getapp.structure.view.fragment.RemoveFragment;

/**
 * Created by matheusoliveira on 08/03/2016.
 */
public class MainActivity extends AppCompatActivity {

    private TextClock txtClock;
    private FloatingActionButton fab;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new TabAdapter(getSupportFragmentManager(), 2));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getText().equals("Alarmes")){
                    fab.show();
                } else {
                    fab.hide();
                }
                ListFragment.refresh();
                RemoveFragment.refresh();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        txtClock = (TextClock) findViewById(R.id.textClock);
        txtClock.setFormat24Hour(txtClock.getFormat24Hour());


        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new CallTimePicker();
                newFragment.show(getFragmentManager(), "Start");
            }
        });

    }
}

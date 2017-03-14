package io.airasia;

import android.app.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar toolbar;
    TabLayout tabLayout;
    Button oneWay;
    Button round;
    Button multicity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        oneWay = (Button) findViewById(R.id.one_way);
        round = (Button) findViewById(R.id.round);
        multicity = (Button) findViewById(R.id.multicity);
        oneWay.setOnClickListener(this);
        round.setOnClickListener(this);
        multicity.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager viewPager) {
        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FlightFragment(), "Flight");
        adapter.addFrag(new FlightFragment(), "Train");
        adapter.addFrag(new FlightFragment(), "Bus");
        viewPager.setAdapter(adapter);
    }

    private void applyNormalStyle(Button btn) {
        btn.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        btn.setBackground(ContextCompat.getDrawable(this, R.drawable.button_background));
    }
    private void applyActiveStyle(Button btn) {
        btn.setTextColor(ContextCompat.getColor(this, R.color.topPink));
        btn.setBackground(ContextCompat.getDrawable(this, R.drawable.button_background_pressed));
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.one_way) {
            applyActiveStyle(oneWay);
            applyNormalStyle(multicity);
            applyNormalStyle(round);
        } else if (id == R.id.round) {
            applyActiveStyle(round);
            applyNormalStyle(multicity);
            applyNormalStyle(oneWay);
        } else if (id == R.id.multicity) {
            applyActiveStyle(multicity);
            applyNormalStyle(oneWay);
            applyNormalStyle(round);
        }
    }

}

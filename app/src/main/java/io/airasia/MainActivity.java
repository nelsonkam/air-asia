package io.airasia;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button oneWay;
    Button round;
    Button multicity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Top Button Setup
        oneWay = (Button) findViewById(R.id.one_way);
        round = (Button) findViewById(R.id.round);
        multicity = (Button) findViewById(R.id.multicity);
        oneWay.setOnClickListener(this);
        round.setOnClickListener(this);
        multicity.setOnClickListener(this);

        // "One way" is selected by default
        activateButton(oneWay);
        SimpleFragment fragment = SimpleFragment.newInstance("One Way");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, fragment);
        transaction.commit();
    }


    private void applyNormalStyle(Button btn) {
        btn.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        btn.setBackground(ContextCompat.getDrawable(this, R.drawable.button_background));
    }
    private void applyActiveStyle(Button btn) {
        btn.setTextColor(ContextCompat.getColor(this, R.color.topPink));
        btn.setBackground(ContextCompat.getDrawable(this, R.drawable.button_background_pressed));
    }
    private void activateButton(Button btn) {
        int id = btn.getId();
        if (id == R.id.one_way) {
            applyActiveStyle(oneWay);
            applyNormalStyle(multicity);
            applyNormalStyle(round);
            SimpleFragment fragment = SimpleFragment.newInstance("One Way");
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();
        } else if (id == R.id.round) {
            applyActiveStyle(round);
            applyNormalStyle(multicity);
            applyNormalStyle(oneWay);
            SimpleFragment fragment = SimpleFragment.newInstance("Round");
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();
        } else if (id == R.id.multicity) {
            applyActiveStyle(multicity);
            applyNormalStyle(oneWay);
            applyNormalStyle(round);
            MulticityFragment fragment = new MulticityFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.commit();
        }
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.one_way) {
            activateButton(oneWay);
        } else if (id == R.id.round) {
            activateButton(round);
        } else if (id == R.id.multicity) {
           activateButton(multicity);
        }
    }

}

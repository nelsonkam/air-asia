package io.airasia;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import io.airasia.fragments.MulticityFragment;
import io.airasia.fragments.SimpleFragment;
import io.airasia.utils.HighlightUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button oneWay;
    Button round;
    Button multicity;
    Button activeBtn;
    RelativeLayout fragmentContainer;
    Drawable initialBackground;
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

        fragmentContainer = (RelativeLayout) findViewById(R.id.fragment_container);
        initialBackground = fragmentContainer.getBackground();

        // "One way" is selected by default
        activateButton(oneWay);
    }


    private void applyNormalStyle(Button btn) {
        btn.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        btn.setBackground(ContextCompat.getDrawable(this, R.drawable.button_background));
    }
    private void applyActiveStyle(Button btn) {
        btn.setTextColor(ContextCompat.getColor(this, R.color.topPink));
        btn.setBackground(ContextCompat.getDrawable(this, R.drawable.button_background_pressed));
        activeBtn = btn;
    }
    private void activateButton(Button btn) {
        int id = btn.getId();
        if (id == R.id.one_way) {
            switchFragment(oneWay, SimpleFragment.newInstance("One Way"));
        } else if (id == R.id.round) {
            switchFragment(round, SimpleFragment.newInstance("Round"));
        } else if (id == R.id.multicity) {
            switchFragment(multicity, new MulticityFragment());
        }
    }

    private void switchFragment(Button nextActiveBtn, Fragment fragment) {
        // if it is switching for the first time
        if (activeBtn != null) {
            applyNormalStyle(activeBtn);
        }
        applyActiveStyle(nextActiveBtn);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
        HighlightUtil.highlight(this, fragmentContainer);
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

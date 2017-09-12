package com.day04.course.fragmentapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements AFragment.AListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aButton = (Button) findViewById(R.id.aButton);
        Button bButton = (Button) findViewById(R.id.bButton);
        Button cButton = (Button) findViewById(R.id.cButton);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, AFragment.newInstance("A", MainActivity.this))
                .commit();

        aButton.setOnClickListener(this);
        bButton.setOnClickListener(this);
        cButton.setOnClickListener(this);

    }

    private void viewFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    @Override
    public void onClick(View view) {

        if (R.id.aButton == view.getId()) {
            viewFragment(AFragment.newInstance("A", MainActivity.this));
        } else if (R.id.bButton == view.getId()) {
            viewFragment(new BFragment());
        } else {
            viewFragment(new CFragment());
        }
    }

    @Override
    public void showAndUpdateB(String value) {
        viewFragment(new BFragment());
    }
}

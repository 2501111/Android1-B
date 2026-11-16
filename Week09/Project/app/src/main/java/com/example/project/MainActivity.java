package com.example.project;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout layout;
    private FragmentContainerView containerView;
    private FragmentManager manager;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        containerView = findViewById(R.id.fragmentContainer);
        manager = getSupportFragmentManager();
        manager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (manager.getBackStackEntryCount() == 0) {
                    layout.setVisibility(VISIBLE);
                    containerView.setVisibility(INVISIBLE);
                }
            }
        });

        layout = findViewById(R.id.layout);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button3);
        button1.setOnClickListener(this);
        Button button4 = findViewById(R.id.button4);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        int type = v.getId();
         if (type ==  R.id.button1) {
             intent = new Intent(MainActivity.this, FragmentActivity.class);
         } else if (type == R.id.button2) {
             intent = new Intent(MainActivity.this, DialogFragmentActivity.class);
         }


        if (intent != null)
            startActivity(intent);
    }
}
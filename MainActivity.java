package com.example.infinity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction f1=getSupportFragmentManager().beginTransaction();
        f1.add(R.id.fragments,new Fragment1());
        f1.commit();



        LinearLayout layout=findViewById(R.id.l2);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearimage();
                ImageView i1=findViewById(R.id.m1);
                i1.setBackgroundResource(R.drawable.newwhome);
                FragmentTransaction f1=getSupportFragmentManager().beginTransaction();
                f1.replace(R.id.fragments,new Fragment1());
                f1.commit();
            }
        });

        LinearLayout layout3=findViewById(R.id.l3);
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearimage();
                ImageView i3 = findViewById(R.id.m3);
                i3.setBackgroundResource(R.drawable.newwhome);
                FragmentTransaction f1 = getSupportFragmentManager().beginTransaction();
                f1.replace(R.id.fragments, new Fragment2());
                f1.commit();
            }

        });

        LinearLayout layout4=findViewById(R.id.l4);
        layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearimage();
                ImageView i3 = findViewById(R.id.m4);
                i3.setBackgroundResource(R.drawable.newwhome);
                FragmentTransaction f1 = getSupportFragmentManager().beginTransaction();
                f1.replace(R.id.fragments, new Fragment3());
                f1.commit();
            }

        });

    }

    private void clearimage() {
        ImageView i1 = findViewById(R.id.m1);
        i1.setBackgroundResource(R.drawable.homebw);
        ImageView i3 = findViewById(R.id.m3);
        i3.setBackgroundResource(R.drawable.homebw);
        ImageView i4 = findViewById(R.id.m4);
        i4.setBackgroundResource(R.drawable.homebw);

    }
}
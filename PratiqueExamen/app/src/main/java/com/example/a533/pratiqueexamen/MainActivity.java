package com.example.a533.pratiqueexamen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openActivity1();
       // openActivity2();
    }

    private void openActivity1() {
        Intent intent = new Intent(this,Question1.class);

        startActivity(intent);
    }

    private void openActivity2() {
        Intent intent = new Intent(this,Question2.class);
        startActivity(intent);
    }
}

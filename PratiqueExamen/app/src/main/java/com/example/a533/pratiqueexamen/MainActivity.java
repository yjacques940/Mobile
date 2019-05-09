package com.example.a533.pratiqueexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openActivity2();
    }

    private void openActivity2() {
        Intent intent = new Intent(this,Question2.class);
        startActivity(intent);
    }
}

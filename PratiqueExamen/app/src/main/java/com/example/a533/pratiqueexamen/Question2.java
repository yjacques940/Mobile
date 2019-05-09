package com.example.a533.pratiqueexamen;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        showDialog();
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.question2_sulu);
        dialog.findViewById(R.id.button_ayecaptain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage(true);
                dialog.dismiss();
            }
        });
       dialog.findViewById(R.id.button_nocaptain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage(false);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void showMessage(boolean answer) {
        if(answer)
        {
            Toast.makeText(getApplicationContext(),"Vroom",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"It's treason then",Toast.LENGTH_LONG).show();
        }
    }

}

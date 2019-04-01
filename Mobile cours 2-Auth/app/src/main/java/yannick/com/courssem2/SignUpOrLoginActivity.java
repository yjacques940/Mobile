package yannick.com.courssem2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUpOrLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_or_login);
        setListener();
    }

    private void setListener()
    {
        findViewById(R.id.button_goToLogin).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                sendToLoginActivity();
            }
        });

        findViewById(R.id.button_goToSignUp).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                sendToSignUpActivity();
            }
        });
    }

    private void sendToSignUpActivity()
    {
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
    }

    private void sendToLoginActivity()
    {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}

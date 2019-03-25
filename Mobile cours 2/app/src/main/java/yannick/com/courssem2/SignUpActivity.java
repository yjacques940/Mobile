package yannick.com.courssem2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth = FirebaseAuth.getInstance();
        setListener();
    }

    private void setListener()
    {
        findViewById(R.id.button_signUp).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                signUpUser();
            }
        });
    }

    private void signUpUser() {
        
    }
}

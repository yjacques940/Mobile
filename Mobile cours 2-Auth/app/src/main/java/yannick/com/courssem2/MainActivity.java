package yannick.com.courssem2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        setListener();
    }

    private void setListener() {
        findViewById(R.id.button_logOut).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                logOut();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser)
    {
        if(currentUser == null)
        {
            sendUserToSignUpOrLoginActivity();
        }
    }

    private void sendUserToSignUpOrLoginActivity()
    {
        Intent intent = new Intent(this,SignUpOrLoginActivity.class);
        startActivity(intent);
    }

    private void logOut()
    {
        auth.signOut();
        updateUI(auth.getCurrentUser());
    }
}

package yannick.com.courssem2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
        EditText userEmail = findViewById(R.id.editText_signUpEmail);
        EditText password = findViewById(R.id.editTextsignUpPassword);
        EditText passwordConfirm = findViewById(R.id.editText_signUpPasswordConfirm);

       /* if(password.getText().toString() != passwordConfirm.getText().toString())
        {
            Toast.makeText(this,"Passwords don't match",Toast.LENGTH_SHORT).show();
            return;
        }*/

        auth.createUserWithEmailAndPassword(userEmail.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    sendUserToMainActivity();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error somewhere",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    private void sendUserToMainActivity()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

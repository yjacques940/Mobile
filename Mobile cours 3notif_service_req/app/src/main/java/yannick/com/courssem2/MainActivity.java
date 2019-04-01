package yannick.com.courssem2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import yannick.com.courssem2.Notification.Model.MessageModel;
import yannick.com.courssem2.Notification.NotificationService;

public class MainActivity extends AppCompatActivity {
FirebaseAuth auth;
FirebaseFirestore database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
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
        findViewById(R.id.button_send_message).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
EditText editTextMessage = findViewById(R.id.editText_notification_message);
        MessageModel messageModel = new MessageModel(editTextMessage.getText().toString(),
                auth.getCurrentUser().getEmail());
        database.collection("Notification").add(messageModel).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(),"Message sent",Toast.LENGTH_LONG).show();
                }

            }
        });
}

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = auth.getCurrentUser();
        updateUI(currentUser);
    }

    private void startService()
    {
        Intent service = new Intent(this, NotificationService.class);
        ContextCompat.startForegroundService(this,service);
    }

    private void updateUI(FirebaseUser currentUser)
    {
        if(currentUser == null)
        {
            sendUserToSignUpOrLoginActivity();
        }
        else
        {
            startService();
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

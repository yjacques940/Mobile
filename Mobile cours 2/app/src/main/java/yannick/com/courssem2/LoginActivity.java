package yannick.com.courssem2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setListener();
    }

    private void setListener()
    {
        findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                loginUser();
            }
        });
    }

    private void loginUser()
    {
        EditText email = findViewById(R.id.editText_emailLogin);
        EditText password = findViewById(R.id.editText_passwordLogin);

    }
}

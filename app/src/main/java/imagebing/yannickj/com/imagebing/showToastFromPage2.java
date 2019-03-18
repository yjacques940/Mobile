package imagebing.yannickj.com.imagebing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class showToastFromPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_toast_from_page2);
        showToastMessage();
    }

    private void showToastMessage() {
        Intent intent = getIntent();
        String textToShow = intent.getStringExtra("stringSent");
        Toast toast = Toast.makeText(getApplicationContext(),textToShow, LENGTH_SHORT);
         toast.show();
    }
}

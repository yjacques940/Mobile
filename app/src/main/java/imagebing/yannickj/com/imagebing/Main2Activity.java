package imagebing.yannickj.com.imagebing;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.button_goto_pageThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToConnectActivity();
            }
        });
    }
    private void moveToConnectActivity(){
        Intent intent = new Intent(this,showToastFromPage2.class);
        EditText editText = (EditText)findViewById(R.id.something_editText);
        
        String text = editText.getText().toString();
        intent.putExtra("stringSent",text);
        startActivity(intent);
    }
}

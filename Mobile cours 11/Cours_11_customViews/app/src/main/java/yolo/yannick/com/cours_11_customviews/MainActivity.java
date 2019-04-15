package yolo.yannick.com.cours_11_customviews;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setObjectToDisplay();
    }

    private void setObjectToDisplay(){
        Bitmap planBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.plan);
        PlanView planView = findViewById(R.id.planView);
        planView.addElementToDisplay(new Plan(planBitmap));
    }
}
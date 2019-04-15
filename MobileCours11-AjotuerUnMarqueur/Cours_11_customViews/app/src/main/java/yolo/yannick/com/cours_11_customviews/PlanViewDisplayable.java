package yolo.yannick.com.cours_11_customviews;

import android.graphics.Bitmap;

public interface PlanViewDisplayable {
    public float getPositionX();
    public float getPositionY();
    public float getWidth();
    public float getHeight();
    public Bitmap getBitmap();
}

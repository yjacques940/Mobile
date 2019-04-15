package yolo.yannick.com.cours_11_customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

public class PlanView extends View {
private float zoomLevel = 1f;
private float currentX = 0;
private float currentY = 0;
private ScaleGestureDetector scaleGestureDetector;
private List<PlanViewDisplayable> objectsToDisplay;
private GestureDetector gestureDetector;

    public PlanView(Context context) {
        super(context);
        Init(context,null);
    }

    public PlanView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Init(context,attrs);
    }

    public PlanView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Init(context,attrs);
    }

    public PlanView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Init(context,attrs);
    }

    private void Init(Context context,AttributeSet set)
    {
        objectsToDisplay = new LinkedList<PlanViewDisplayable>();
        scaleGestureDetector = new ScaleGestureDetector(context,new ScaleListener());
        gestureDetector = new GestureDetector(context,new GestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        scaleGestureDetector.onTouchEvent(event);
        gestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint mypaint = new Paint();
        mypaint.setTextSize(72);
        canvas.drawText("Test1",10,100,mypaint);
        canvas.save();
        canvas.scale(zoomLevel,zoomLevel);
        displayObjects(canvas);
        canvas.restore();
    }

    private void displayObjects(Canvas canvas){
        for (PlanViewDisplayable objectToDisplay : objectsToDisplay){
            int positionImageX = (int) objectToDisplay.getPositionX();
            int positionImageY = (int) objectToDisplay.getPositionY();
            //Dessiner le rectangle
            int imageToDisplayLeftPosition = 0;
            int imageToDisplayRightPosition = (int) objectToDisplay.getWidth();
            int imageToDisplayTopPosition = 0;
            int imageToDisplayBottonPosition = (int) objectToDisplay.getHeight();
            //Dessine le rectangle de OU on va dessiner dans le canvas
            int imageWhereToDisplayLeftPosition = (int) (positionImageX - currentX);
            int imageWhereToDisplayRightPosition =  imageWhereToDisplayLeftPosition +
                    imageToDisplayRightPosition - imageToDisplayLeftPosition;
            int imageWhereToDisplayTopPosition = (int) (positionImageY + currentY);
            int imageWhereToDisplayBottonPosition = imageWhereToDisplayTopPosition +
                    imageToDisplayBottonPosition - imageToDisplayTopPosition;

            canvas.drawBitmap(objectToDisplay.getBitmap(),new Rect(imageToDisplayLeftPosition,
                    imageToDisplayTopPosition, imageToDisplayRightPosition,imageToDisplayBottonPosition),
            new Rect(imageWhereToDisplayLeftPosition,imageWhereToDisplayTopPosition,
                    imageWhereToDisplayRightPosition,imageWhereToDisplayBottonPosition),null);
        }
    }

    public void addElementToDisplay(PlanViewDisplayable newObjectToDisplay){
        objectsToDisplay.add(newObjectToDisplay);
        invalidate();
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            zoomLevel *= detector.getScaleFactor();
            zoomLevel = Math.max(0.1f,Math.min(zoomLevel,5.0f));
            invalidate();
            return true;
        }
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            currentX += distanceX/zoomLevel;
            currentY -= distanceY/zoomLevel;
            invalidate();
            return true;
        }
    }
}

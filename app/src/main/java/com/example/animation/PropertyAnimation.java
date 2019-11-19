package com.example.propertyanimation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class PropertyAnimation extends View {
    final int AnimationDuration = 4000;
    final int AnimationDelay = 1000;
    final int ColorAdjust = 5;
    float x,y,radius;
    Paint paint;
    AnimatorSet animatorSet;
    public PropertyAnimation(Context context) {
        super(context);
    }
    public PropertyAnimation(Context context, AttributeSet attrs){
        super(context, attrs);

        paint = new Paint();
        animatorSet = new AnimatorSet();
    }
    void setRadius(float r){
        radius = r;
        paint.setColor(Color.GREEN + (int) radius / ColorAdjust);
        invalidate();
    }
    protected void onSizeChanged(int w, int h,int oldw, int oldh){
        super.onSizeChanged(w,h,oldw,oldh);
        ObjectAnimator growAnimator = ObjectAnimator.ofFloat(this,"radius",0,getWidth());
        growAnimator.setDuration(AnimationDuration);
        growAnimator.setInterpolator(new LinearInterpolator());
        ObjectAnimator shrinkAnimator = ObjectAnimator.ofFloat(this,"radius",getWidth(),0);
        shrinkAnimator.setDuration(AnimationDuration);
        shrinkAnimator.setInterpolator(new DecelerateInterpolator());
        shrinkAnimator.setStartDelay(AnimationDelay);
        animatorSet.play(growAnimator).before(shrinkAnimator);
    }
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                if (animatorSet != null && animatorSet.isRunning())
                    animatorSet.cancel();
                animatorSet.start();
                break;
        }
        return super.onTouchEvent(event);
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawCircle(x,y,radius,paint);
    }
}

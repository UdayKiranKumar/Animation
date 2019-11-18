package com.example.animation;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationSet;

import androidx.annotation.Nullable;

public class PropertyAnimation extends View {
    Paint paint;
    AnimationSet animationSet;
    float x,y,radius;
    final int AnimationDuration = 4000;
    final int AnimationDelay = 1000;

    public PropertyAnimation(Context context) {
        super(context);
    }
    void setRadius(float r)
    {
        radius = r;
        paint.setColor(Color.GREEN + (int)radius );
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        super.onSizeChanged(w, h, oldw, oldh);
        ObjectAnimator growAnimator = ObjectAnimator.ofFloat(this,"radius",getWidth() , 0);
    }

    public PropertyAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}

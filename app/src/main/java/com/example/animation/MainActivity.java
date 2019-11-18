package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
    }
    public void clockwise(View view)
    {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim1);
        imageView.startAnimation(animation1);
    }
    public void zoom(View view)
    {
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim2);
        imageView.startAnimation(animation2);
    }
    public void fade(View view)
    {
        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim3);
        imageView.startAnimation(animation3);
    }
    public void blink(View view)
    {
        Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim4);
        imageView.startAnimation(animation4);
    }
    public void move(View view)
    {
        Animation animation5 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim5);
        imageView.startAnimation(animation5);
    }
    public void slide(View view)
    {
        Animation animation6 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim6);
        imageView.startAnimation(animation6);
    }
}

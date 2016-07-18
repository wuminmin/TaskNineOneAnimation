package com.wuminmin.tasknineoneanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button textViewViewAnimationByCode;
    private Button textViewViewAnimationByXml;
    private Button buttonObjectAnimtorByCode;
    private Button buttonObjectAnimtorByXml;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewViewAnimationByCode = (Button) findViewById(R.id.buttonAnimationByCode);
        textViewViewAnimationByCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TranslateAnimation translateAnimationRight = new TranslateAnimation(0, 400, 0, 0);
                TranslateAnimation translateAnimationDwon = new TranslateAnimation(0, 0, 0, 400);
                translateAnimationRight.setDuration(2000);
                translateAnimationDwon.setDuration(2000);
                translateAnimationDwon.setStartOffset(2000);
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(translateAnimationRight);
                animationSet.addAnimation(translateAnimationDwon);
                textViewViewAnimationByCode.startAnimation(animationSet);
            }
        });


        textViewViewAnimationByXml = (Button) findViewById(R.id.buttonVieAnimationByXml);
        textViewViewAnimationByXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewViewAnimationByXml.startAnimation(AnimationUtils.
                        loadAnimation(MainActivity.this, R.anim.viewanimation));
            }
        });

        buttonObjectAnimtorByCode = (Button) findViewById(R.id.buttonObjectAnimtorByCode);
        buttonObjectAnimtorByCode.setOnClickListener(this);

        buttonObjectAnimtorByXml = (Button)findViewById(R.id.buttonObjectAnimtorByXml);
        buttonObjectAnimtorByXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animator animator = AnimatorInflater.
                        loadAnimator(MainActivity.this, R.animator.objectanimator);
                animator.setTarget(v);
                animator.start();
            }
        });


        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.planet_earth_venues_univearse_jupiter);
        imageView.setVisibility(View.VISIBLE);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView,"ScaleX",1,0);
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imageView,"ScaleX",0,1);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(objectAnimator1,objectAnimator2);
                animatorSet.setDuration(2000);
                animatorSet.start();
            }
        });
    }

    @Override
    public void onClick(View v) {
        ObjectAnimator objectAnimatorRight = ObjectAnimator.ofFloat(buttonObjectAnimtorByCode,
                "translationX", 0, 400);
        ObjectAnimator objectAnimatorLeft = ObjectAnimator.ofFloat(buttonObjectAnimtorByCode,
                "translationX",400,0);
        ObjectAnimator objectAnimatorDwon = ObjectAnimator.ofFloat(buttonObjectAnimtorByCode,
                "translationY",0,400);
        ObjectAnimator objectAnimatorUp= ObjectAnimator.ofFloat(buttonObjectAnimtorByCode,
                "translationY",400,0);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(4000);
        animatorSet.playSequentially(objectAnimatorRight,objectAnimatorDwon,
                objectAnimatorUp,objectAnimatorLeft);
        animatorSet.start();
    }

}
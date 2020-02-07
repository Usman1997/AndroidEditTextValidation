package com.example.edittextanimation.ValidationHelper;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.core.content.ContextCompat;

import com.example.edittextanimation.R;

public class UnderLabelValidator extends Validator {
    private Context mContext;
    private ValidationCallback mValidationCallback;


    @Override
    public boolean trigger() {
        halt();
        return checkFields(mValidationCallback);
    }

    @Override
    public void halt() {
      for(ValidationHolder validationHolder: mValidationHolderList){
          validationHolder.getTextView().setVisibility(View.GONE);
      }
    }


    public void setContext(Context context) {
        mContext = context;
        init();
    }



    private void init() {
        mValidationCallback = new ValidationCallback() {
            @Override
            public void execute(ValidationHolder validationHolder) {
                validationHolder.getTextView().setText(validationHolder.getErr_msg());
                viewAnimation(R.anim.shake, validationHolder.getTextView());

            }
        };
    }

    private void viewAnimation(int anim, final View view) {
        Animation animation = AnimationUtils.loadAnimation(mContext, anim);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                    view.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(animation);
    }


}

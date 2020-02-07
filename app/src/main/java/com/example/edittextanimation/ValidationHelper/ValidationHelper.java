package com.example.edittextanimation.ValidationHelper;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;

public class ValidationHelper {
    private Validator mValidator = null;
    public ValidationHelper(ValidationStyle validationStyle){
          switch (validationStyle){
              case BASIC:
                  if (mValidator == null || !(mValidator instanceof BasicValidator)) {
                      mValidator = new BasicValidator();
                  }
                  break;

              case UNDERLABEL:
                  if (mValidator == null || !(mValidator instanceof UnderLabelValidator)) {
                      mValidator = new UnderLabelValidator();
                  }
                  break;

          }
    }


    public void addValidation(Activity activity,int viewId, String err_msg, String type) {
        mValidator.set(activity,viewId, err_msg, type);
    }

    public void addValidation(Activity activity,int viewId, String err_msg, String type,int length) {
        mValidator.set(activity,viewId, err_msg, type,length);
    }

    public void addValidation(Activity activity,int viewId, String err_msg, String type,int errViewId,boolean isLength) {
        mValidator.set(activity,viewId, err_msg, type,errViewId,isLength);
    }

    public void addValidation(Activity activity,int viewId, String err_msg, String type,int length,int errViewId) {
        mValidator.set(activity,viewId, err_msg, type,length,errViewId);
    }

    public boolean validate(){
         return mValidator.trigger();
    }

    public void setContext(Context context) {
        checkIsUnderlabelValidator();
        ((UnderLabelValidator) mValidator).setContext(context);
    }

    private void checkIsUnderlabelValidator() {
        if (!(mValidator instanceof UnderLabelValidator)) {
            throw new UnsupportedOperationException("Only supported by UnderlabelValidator.");
        }
    }
}

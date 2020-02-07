package com.example.edittextanimation.ValidationHelper;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validator {
    protected ArrayList<ValidationHolder> mValidationHolderList;


    Validator() {
        mValidationHolderList = new ArrayList<>();
    }


    protected boolean checkFields(ValidationCallback validationCallback) {
        boolean result = true;
        for (ValidationHolder validationHolder : mValidationHolderList) {
            switch (validationHolder.getType()) {
                case "CHECK_EMPTY_STRING":
                    result = validateString(validationHolder, validationCallback) && result;
                    break;
                case "CHECK_EMAIL":
                    result = validateEmail(validationHolder, validationCallback) && result;
                    break;
                case "CHECK_PASSWORD":
                    result = validatePassword(validationHolder, validationCallback) && result;
                    break;
            }
        }
        return result;
    }

    private boolean validateString(ValidationHolder validationHolder, ValidationCallback validationCallback) {
        boolean isEmpty;
        isEmpty = validationHolder.getEditText().getText().toString().isEmpty();
        if(isEmpty){
            executeCallback(validationCallback, validationHolder);
            return false;
        }
        return true;
    }

    private boolean validateEmail(ValidationHolder validationHolder, ValidationCallback validationCallback) {
        boolean valid;
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = ".+@.+\\.[a-z]+";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(validationHolder.getEditText().getText().toString());
        valid =  matcher.matches();
        if(!valid){
            executeCallback(validationCallback, validationHolder);
            return false;
        }

        return true;
    }

    private boolean validatePassword(ValidationHolder validationHolder, ValidationCallback validationCallback) {
        boolean valid;
        valid = validationHolder.getEditText().getText().toString().length() >= 6;
        if(!valid){
            executeCallback(validationCallback, validationHolder);
            return valid;
        }

        return true;
    }

    public void set(Activity activity, int viewId, String err_msg, String type) {
        View view = activity.findViewById(viewId);
        if (view instanceof EditText) {
            ValidationHolder validationHolder = new ValidationHolder((EditText) view, err_msg, type);
            mValidationHolderList.add(validationHolder);
        }

    }

    public void set(Activity activity, int viewId, String err_msg, String type, int length) {
        View view = activity.findViewById(viewId);
        if (view instanceof EditText) {
            ValidationHolder validationHolder = new ValidationHolder((EditText) view, err_msg, type, length);
            mValidationHolderList.add(validationHolder);
        }

    }


    public void set(Activity activity, int viewId, String err_msg, String type,int errViewId,boolean isLength) {
        View view = activity.findViewById(viewId);
        View txtView = activity.findViewById(errViewId);
        if (view instanceof EditText && txtView instanceof TextView) {
            ValidationHolder validationHolder = new ValidationHolder((EditText) view, err_msg, type,(TextView) txtView);
            mValidationHolderList.add(validationHolder);
        }

    }

    public void set(Activity activity, int viewId, String err_msg, String type, int length,int errViewId) {
        View view = activity.findViewById(viewId);
        View txtView = activity.findViewById(errViewId);
        if (view instanceof EditText && txtView instanceof TextView) {
            ValidationHolder validationHolder = new ValidationHolder((EditText) view, err_msg, type, length,(TextView) txtView);
            mValidationHolderList.add(validationHolder);
        }

    }


    private void executeCallback(ValidationCallback callback, ValidationHolder validationHolder) {
        callback.execute(validationHolder);
    }


    public abstract boolean trigger();
    public abstract void halt();
}

package com.example.edittextanimation.ValidationHelper;

import android.widget.EditText;
import android.widget.TextView;

public class ValidationHolder {
    private String type;
    private EditText editText;
    private String err_msg;
    private int length;
    private TextView textView;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public ValidationHolder(EditText editText, String err_msg, String type){
        this.editText = editText;
        this.err_msg = err_msg;
        this.type = type;
    }

    public ValidationHolder(EditText editText,String err_msg,String type,int length){
        this.editText = editText;
        this.err_msg = err_msg;
        this.type = type;
        this.length = length;
    }

    public ValidationHolder(EditText editText,String err_msg,String type,TextView textView){
        this.editText = editText;
        this.err_msg = err_msg;
        this.type = type;
        this.textView = textView;
    }

    public ValidationHolder(EditText editText,String err_msg,String type,int length,TextView textView){
        this.editText = editText;
        this.err_msg = err_msg;
        this.type = type;
        this.length = length;
        this.textView = textView;
    }
}

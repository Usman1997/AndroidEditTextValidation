package com.example.edittextanimation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.edittextanimation.ValidationHelper.ValidationHelper;

import static com.example.edittextanimation.ValidationHelper.ValidationStyle.UNDERLABEL;

public class MaterialTextActivity extends AppCompatActivity implements View.OnClickListener {
    EditText evEmail,evPassword,evName;
    Button btnSubmit;
    private ValidationHelper validationHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_text);
        evEmail = (EditText) findViewById(R.id.evEmail);
        evPassword = (EditText) findViewById(R.id.evPassword);
        evName = (EditText) findViewById(R.id.evName);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
        validationHelper = new ValidationHelper(UNDERLABEL);
        validationHelper.setContext(this);
        addValidation();
    }

    private void addValidation(){
        validationHelper.addValidation(this,R.id.evEmail,"Please provide valid Email", "CHECK_EMAIL",R.id.errMsgEmail,false);
        validationHelper.addValidation(this,R.id.evPassword,"Please provide valid password","CHECK_PASSWORD",7,R.id.errMsgPassword);
        validationHelper.addValidation(this,R.id.evName,"Please enter your name","CHECK_EMPTY_STRING",R.id.errMsgName,false);
    }

    @Override
    public void onClick(View view) {
        if(validationHelper.validate()){
            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
        }
    }
}

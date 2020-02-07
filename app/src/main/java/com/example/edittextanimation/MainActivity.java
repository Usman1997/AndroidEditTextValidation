package com.example.edittextanimation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.edittextanimation.utils.MaterialTextField;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnFloatLabel,btnMaterial;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFloatLabel = (Button)findViewById(R.id.btnFloatLabel);
        btnMaterial = (Button) findViewById(R.id.btnMaterial);
        btnMaterial.setOnClickListener(this);
        btnFloatLabel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.btnFloatLabel:
                intent = new Intent(this,FloatLabelActivity.class);
                startActivity(intent);
                break;

            case R.id.btnMaterial:
                intent = new Intent(this, MaterialTextActivity.class);
                startActivity(intent);
                break;
        }
    }
}

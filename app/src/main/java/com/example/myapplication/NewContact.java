package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewContact extends AppCompatActivity {
    private EditText txtId, txtName, txtPhone;
    private Button btnAdd, btnCancel;
    private Intent intent;

    public NewContact() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        intent = getIntent();
        txtId = findViewById(R.id.txtId);
        txtName = findViewById(R.id.txtFullname);
        txtPhone = findViewById(R.id.txtPhone);
        btnAdd = findViewById(R.id.btnAdd);
        btnCancel = findViewById(R.id.btnCancel);

        if (intent != null) {
            txtId.setText(intent.getStringExtra("id"));
            txtName.setText(intent.getStringExtra("name"));
            txtPhone.setText(intent.getStringExtra("phone"));
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                intent.putExtra("id", txtId.getText().toString());
                intent.putExtra("name", txtName.getText().toString());
                intent.putExtra("phone", txtPhone.getText().toString());
                setResult(10, intent);
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

    }
}

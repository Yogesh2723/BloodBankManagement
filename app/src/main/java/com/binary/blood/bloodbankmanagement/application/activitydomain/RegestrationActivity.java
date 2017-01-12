package com.binary.blood.bloodbankmanagement.application.activitydomain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.binary.blood.bloodbankmanagement.R;
import com.binary.blood.bloodbankmanagement.application.controller.RegisterManager;
import com.binary.blood.bloodbankmanagement.application.model.RegisterModel;

public class RegestrationActivity extends AppCompatActivity {
    RegisterManager registerManager;
    private EditText memberId;
    private EditText memberName;
    private EditText memberEmail;
    private EditText memberPhone;
    private EditText memberPass;
    private EditText memberLocation;
    private Spinner memberBGSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);

        memberName = (EditText) findViewById(R.id.memberNameET);
        memberEmail = (EditText) findViewById(R.id.memberEmailET);
        memberPhone = (EditText) findViewById(R.id.memberPhoneET);
        memberPass = (EditText) findViewById(R.id.memberPassET);
        memberLocation = (EditText) findViewById(R.id.memberLocationET);
        memberBGSpinner = (Spinner) findViewById(R.id.memberBGSpinner);
        registerManager = new RegisterManager(this);
    }

    public void save(View view) {
        String name = memberName.getText().toString();
        String email = memberEmail.getText().toString();
        String phone = memberPhone.getText().toString();
        String pass = memberPass.getText().toString();
        String location = memberLocation.getText().toString();
        String bg = memberBGSpinner.getSelectedItem().toString();

        RegisterModel registerModel = new RegisterModel(name, email, phone, pass, location, bg);

        long insertResultRow = registerManager.addMember(registerModel);
        if (insertResultRow > 0) {
            Intent intent = new Intent(RegestrationActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, registerModel.getMemberName() + " >> " + insertResultRow, Toast.LENGTH_SHORT).show();

        }

    }
}
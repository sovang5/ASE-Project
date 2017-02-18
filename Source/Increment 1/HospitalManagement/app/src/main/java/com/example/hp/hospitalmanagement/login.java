package com.example.hp.hospitalmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
    public void onClickLog(View v) {
        EditText editText_emailid = (EditText) findViewById(R.id.editText_emailid);
        EditText editText_password = (EditText) findViewById(R.id.editText_password);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String value = spinner.getSelectedItem().toString();
        System.out.println(" selected item " + value);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        String email_id = pref.getString("emailid", null);
        String pass = pref.getString("password", null);
        if (value.equals("Doctor")) {
            if (editText_emailid.getText().toString().equals(email_id)) {
                if (editText_password.getText().toString().equals(pass)) {
                    Intent redirect = new Intent(login.this, doctor_home.class);
                    startActivity(redirect);
                } else {
                    Toast.makeText(login.this, "Wrong id or password", Toast.LENGTH_LONG).show();
                }
            }


        }
        else
        {
            if (editText_emailid.getText().toString().equals(email_id)) {
                if (editText_password.getText().toString().equals(pass)) {
                    Intent redirect = new Intent(login.this, user_home.class);
                    startActivity(redirect);
                } else {
                    Toast.makeText(login.this, "Wrong id or password", Toast.LENGTH_LONG).show();
                }
            }


        }
    }


    public void onClickRegis(View v){
        Intent redirect = new Intent(login.this, patient_register.class);
        startActivity(redirect);
    }
}

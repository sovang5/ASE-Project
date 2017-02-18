package com.example.hp.hospitalmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class patient_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);
    }
    public void onClickReg(View v){
        EditText editText_name=(EditText)findViewById(R.id.editText_name) ;
        EditText editText_emailid=(EditText)findViewById(R.id.editText_emailid) ;
        EditText editText_contact=(EditText)findViewById(R.id.editText_phoneNo);
        EditText editText_password=(EditText)findViewById(R.id.editText_password) ;
        EditText editText_address=(EditText)findViewById(R.id.editText_address) ;

        String email = editText_emailid.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern)&& email.length()>0)
        {
            Toast.makeText(getApplicationContext(),"valid email address", Toast.LENGTH_SHORT).show();
            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("name", editText_name.getText().toString());
            editor.putString("emailid",editText_emailid.getText().toString());
            editor.putString("contact",editText_contact.getText().toString());
            editor.putString("address",editText_address.getText().toString());
            editor.putString("password",editText_password.getText().toString());
            editor.commit();
            Intent redirect = new Intent(patient_register.this, login.class);
            startActivity(redirect);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
        }

    }
}








// onClick of button perform this simplest code.

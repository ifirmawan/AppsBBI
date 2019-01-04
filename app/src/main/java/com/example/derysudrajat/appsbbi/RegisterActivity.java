package com.example.derysudrajat.appsbbi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.derysudrajat.appsbbi.Quiz.Model.User;
import com.example.derysudrajat.appsbbi.Quiz.Network.Auth;
import com.example.derysudrajat.appsbbi.Quiz.Network.Status;

public class RegisterActivity extends Activity {
    Button btnSignup;
    EditText etUname,etfullName, etPassword, etPasswordUlang, etAsalSekolah ;
    ImageButton cbShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etUname = findViewById(R.id.etUname);
        etfullName = findViewById(R.id.etfullName);
        etAsalSekolah = findViewById(R.id.etAsalSekolah);
        etPassword = findViewById(R.id.etPassword);
        etPasswordUlang = findViewById(R.id.etPasswordUlang);
        btnSignup =  findViewById(R.id.btnSignup);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(etPassword.getText().toString().equals(etPasswordUlang.getText().toString())){
                    Auth a = new Auth(getApplicationContext(), new User(etUname.getText().toString(), etPassword.getText().toString(),etfullName.getText().toString(), etAsalSekolah.getText().toString()), new Status() {
                        @Override
                        public void onLoginDone(User user) {
                            Toast.makeText(getBaseContext(),  user.getNama() + " successfully registered.", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getBaseContext(),LoginActivity.class));
                            finish();
                        }
                    });
                    a.register();

                }
else{
                    Toast.makeText(getBaseContext(),"Password harus sama.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void goLogin(View view){
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }

}

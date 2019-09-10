package com.acampdev.busstop;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.acampdev.busstop.Helpers.DBHelper;

public class LoginActivity extends AppCompatActivity {
    DBHelper dbHelper;
    Button login,register;
    EditText txtemail,txtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper= new DBHelper(this);
        setContentView(R.layout.activity_login);
        txtemail=findViewById(R.id.txtEmailID);
        txtpass=findViewById(R.id.txtPasswordID);
        login=findViewById(R.id.btnLoginID);
        register=findViewById(R.id.btnRegisterID);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txtemail.getText().toString().trim();
                String pass=txtpass.getText().toString().trim();

                //String storePass=data.getSinglePassword(email);
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(getApplicationContext(),"Ingrese un email",Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(getApplicationContext(),"Ingrese un password",Toast.LENGTH_SHORT).show();
                }
                //check password verify

                if(dbHelper.checkUser(email,pass)){
                    //Intent intent=new Intent();
                    //intent.putExtra("EMAIL",email);
                    Intent accountIntent=new Intent(getApplicationContext(),MainActivity.class);
                    accountIntent.putExtra("KEY",email);
                    //emptyInputEditText();
                    startActivity(accountIntent);
                    //finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Email o Password Incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                finish();
            }
        });
    }

    private void  emptyInputEditText(){
        txtemail.setText(null);
        txtpass.setText(null);
    }


}

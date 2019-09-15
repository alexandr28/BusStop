package com.acampdev.busstop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.acampdev.busstop.Models.User;

public class RegisterActivity extends AppCompatActivity {
    User user;
    Data data;
    Button btnAccount,btnSignIn;
    EditText txtEmail,txtPass,txtConfPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtEmail=findViewById(R.id.txtEmailRegID);
        txtPass=findViewById(R.id.txtPasswordRegID);
        txtConfPass=findViewById(R.id.txtPasswordReRegID);
        btnAccount=findViewById(R.id.btnRegID);
        btnSignIn=findViewById(R.id.btnBackLoginID);
        btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=txtEmail.getText().toString();
                String pass=txtPass.getText().toString();
                String confpass=txtConfPass.getText().toString();
                // campos vacios
                if (email.equals("")||pass.equals("")||confpass.equals("")){
                    Toast.makeText(getApplicationContext(),"Campo Vacio",Toast.LENGTH_SHORT).show();
                    return;
                }
                // confirm password
                if(!pass.equals(confpass)){
                    Toast.makeText(getApplicationContext(),"Password Incorrect",Toast.LENGTH_SHORT).show();
                }else {
                    user= new User(SQLConstants.GENERAR_ID,email,pass);
                    data=new Data(getApplicationContext());
                    data.open();
                    data.insertUser(user);
                    Intent intent= new Intent(RegisterActivity.this,MainActivity.class);
                    intent.putExtra("KEY",email);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Usuario Creado",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }
}

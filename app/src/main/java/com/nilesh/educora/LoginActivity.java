package com.nilesh.educora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {


    TextInputLayout et,ep;
    TextInputEditText me, mp;
    Button lb;
    FirebaseAuth mAuth;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et = findViewById(R.id.email_layout);
        ep = findViewById(R.id.pass_layout);
        lb = findViewById(R.id.loginbtn);
        me = findViewById(R.id.edt);
        mp = findViewById(R.id.pdt);
        lb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                String e,p;
                e = me.getText().toString();
                p = mp.getText().toString();
                user = mAuth.getCurrentUser();

                if (user ==null){
                    mAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(LoginActivity.this,MainActivity.class));

                            }else{
                                Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }else {
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }
            }
        });





    }
}
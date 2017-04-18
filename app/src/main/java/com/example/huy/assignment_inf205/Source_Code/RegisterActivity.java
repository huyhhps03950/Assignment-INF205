package com.example.huy.assignment_inf205.Source_Code;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huy.assignment_inf205.Model.User;
import com.example.huy.assignment_inf205.R;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class RegisterActivity extends AppCompatActivity {
    Firebase root;
    Button btnAdd, btnCancel;
    EditText edtUN, edtPW, edtADD,edtNAME, edtSDT,edtDAY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Firebase.setAndroidContext(this);
        root = new Firebase("https://assignment-inf205.firebaseio.com/");
        getAllWidgets();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUN.getText().toString();
                String password = edtPW.getText().toString();
                String name = edtNAME.getText().toString();
                String address = edtADD.getText().toString();
                String sdt = edtSDT.getText().toString();
                String birthday = edtDAY.getText().toString();
                User newUser= new User(username, password, name, address, sdt, birthday);
                root.child("khach-hang").child(username).setValue(newUser,new Firebase.CompletionListener() {
                    @Override
                    public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                        Toast.makeText(RegisterActivity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    public void getAllWidgets() {
        edtUN = (EditText) findViewById(R.id.edtResUsername);
        edtPW = (EditText) findViewById(R.id.edtResPass);
        edtNAME = (EditText) findViewById(R.id.edtResName);
        edtADD = (EditText) findViewById(R.id.edtResAdd);
        edtSDT = (EditText) findViewById(R.id.edtResPhone);
        edtDAY = (EditText) findViewById(R.id.edtResDay);
        btnAdd = (Button) findViewById(R.id.btnResOk);
        btnCancel = (Button) findViewById(R.id.btnResCancel);
    }
}

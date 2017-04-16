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
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Login extends AppCompatActivity {
    Firebase root;
    EditText edtUsername, edtPass;
    TextView tvDK;
    Button btnL, btnC;
    User main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Firebase.setAndroidContext(this);
        root = new Firebase("https://assignment-inf205.firebaseio.com/Account");
        GetAllWidget();
        /*tvDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this,SignIn.class);
                startActivity(i);
            }
        });*/

        //Đăng nhập
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*final String name = edtUsername.getText().toString();
                final String pass = edtPass.getText().toString();
                if (name.trim().isEmpty()) {
                    edtUsername.setError("Vui lòng nhập tên đăng nhập");
                } else if (pass.trim().isEmpty()) {
                    edtPass.setError("Vui lòng nhập mật khẩu");
                } else {
                    root.child("User").child(name).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            try {
                                main = dataSnapshot.getValue(User.class);
                                if (pass.equals(main.getPassword())) {

                                    Toast.makeText(Login.this, "Thành công", Toast.LENGTH_SHORT).show();
                                    Intent i = new Intent(Login.this, MainActivity.class);
                                    Bundle b = new Bundle();
                                    b.putSerializable("data", main);
                                    i.putExtras(b);
                                    startActivity(i);
                                } else {
                                    edtPass.setText(null);
                                    edtPass.requestFocus();
                                    Toast.makeText(Login.this, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
                                }
                            }
                            catch (NullPointerException e) {
                                Toast.makeText(Login.this, "Không tồn tại user này", Toast.LENGTH_SHORT).show();
                                edtUsername.setText(null);
                                edtUsername.requestFocus();
                            }
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                }*/
                Toast.makeText(Login.this, "Thành công", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Login.this, MainActivity.class);
                Bundle b = new Bundle();
                //b.putSerializable("data", main);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }

    private void GetAllWidget(){
        edtUsername = (EditText) findViewById(R.id.edtUN);
        edtPass = (EditText) findViewById(R.id.edtPW);
        btnL = (Button) findViewById(R.id.btnLogin);
        btnC = (Button) findViewById(R.id.btnCancel);
        tvDK = (TextView) findViewById(R.id.tvRes);
    }
}

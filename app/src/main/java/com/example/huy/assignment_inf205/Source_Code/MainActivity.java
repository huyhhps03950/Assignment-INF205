package com.example.huy.assignment_inf205.Source_Code;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.huy.assignment_inf205.Model.User;
import com.example.huy.assignment_inf205.R;

public class MainActivity extends AppCompatActivity {
    Button logGuess, logManager;
    User main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetAllWidgets();
        main = (User) getIntent().getExtras().getSerializable("data");
        logGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, guestActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("data", main);
                i.putExtras(b);
                startActivity(i);
            }
        });

        logManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, storeActivity.class);
                startActivity(i);
            }
        });

    }

    private void GetAllWidgets(){
        logGuess = (Button) findViewById(R.id.logG);
        logManager = (Button) findViewById(R.id.logM);
    }
}

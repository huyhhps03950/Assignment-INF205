package com.example.huy.assignment_inf205.Source_Code;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.example.huy.assignment_inf205.Adapter.listBookAdapter;
import com.example.huy.assignment_inf205.Model.book;
import com.example.huy.assignment_inf205.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class storeActivity extends AppCompatActivity {
    ListView lsBook;
    Button btnAdd;
    listBookAdapter bookAdapter;
    Firebase root;
    ArrayList<book> listBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        Firebase.setAndroidContext(this);
        GetAllWidget();
        adapter();

    }
    private void GetAllWidget(){
        root = new Firebase("https://assignment-inf205.firebaseio.com/book");
        lsBook = (ListView) findViewById(R.id.listB);
        btnAdd = (Button) findViewById(R.id.btnThem);
    }
    public void adapter(){
        root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                listBook.add(dataSnapshot.getValue(book.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        bookAdapter = new listBookAdapter(storeActivity.this, R.layout.view1_book, listBook);
        bookAdapter.notifyDataSetChanged();
        lsBook.setAdapter(bookAdapter);
    }
}

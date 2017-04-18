package com.example.huy.assignment_inf205.Source_Code;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.huy.assignment_inf205.Adapter.listBookAdapter;
import com.example.huy.assignment_inf205.Model.User;
import com.example.huy.assignment_inf205.Model.book;
import com.example.huy.assignment_inf205.Model.order;
import com.example.huy.assignment_inf205.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class guestActivity extends AppCompatActivity {
    ListView lsBook;
    listBookAdapter bookAdapter;
    Firebase root;
    ArrayList<book> listBook = new ArrayList<>();
    ArrayList<order> listOrder= new ArrayList<>();
    User main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);
        Firebase.setAndroidContext(this);
        GetAllWidget();
        adapter();
    }
    private void GetAllWidget(){
        main = (User) getIntent().getExtras().getSerializable("data");
        root = new Firebase("https://assignment-inf205.firebaseio.com/");
        lsBook = (ListView) findViewById(R.id.listbookG);
        lsBook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                addOrder(i);
            }
        });
    }
    public void adapter(){
        root.child("book").addChildEventListener(new ChildEventListener() {
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
        bookAdapter = new listBookAdapter(guestActivity.this, R.layout.view1_book, listBook);
        bookAdapter.notifyDataSetChanged();
        lsBook.setAdapter(bookAdapter);
        getOrder();

    }
    public void getOrder(){
        root.child("order").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                listOrder.add(dataSnapshot.getValue(order.class));
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

    }
    public void addOrder(int i){
        String idOrder = "order"+listOrder.size();
        String user = main.getName();
        String idbook = listBook.get(i).getIdbook();
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        order newOrder = new order(idOrder, user, idbook , date, date);
        root.child("order").child(idOrder).setValue(newOrder, new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                Toast.makeText(guestActivity.this, "Thành Công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

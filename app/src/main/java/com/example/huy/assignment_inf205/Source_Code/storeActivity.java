package com.example.huy.assignment_inf205.Source_Code;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.huy.assignment_inf205.Adapter.listBookAdapter;
import com.example.huy.assignment_inf205.Model.book;
import com.example.huy.assignment_inf205.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class storeActivity extends AppCompatActivity {
    ListView lsBook;
    Button btnAdd;
    listBookAdapter bookAdapter;
    Firebase root;
    ArrayList<book> listBook = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        Firebase.setAndroidContext(this);
        root = new Firebase("https://assignment-inf205.firebaseio.com/book");
        GetAllWidget();
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot item:dataSnapshot.getChildren()) {
                    listBook.add(item.getValue(book.class));
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        adapter();
        bookAdapter.notifyDataSetChanged();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAdd();
            }
        });

    }
    private void GetAllWidget(){
        lsBook = (ListView) findViewById(R.id.listB);
        btnAdd = (Button) findViewById(R.id.btnThem);
        registerForContextMenu(lsBook);
    }
    public void adapter() {
            bookAdapter = new listBookAdapter(storeActivity.this, R.layout.view1_book, listBook);
            lsBook.setAdapter(bookAdapter);
    }
    public void toAdd(){
        Intent i = new Intent(storeActivity.this, AddActivity.class);
        Bundle b = new Bundle();
        b.putString("title","Thêm Sách");
        i.putExtras(b);
        startActivity(i);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.content,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = info.position;
        book bookFix = listBook.get(pos);
        switch (item.getItemId()){
            case R.id.fix:
                Intent i = new Intent(storeActivity.this, FixActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("data",bookFix);
                i.putExtras(b);
                startActivity(i);
                break;
            case R.id.del:
                root.child(bookFix.getIdbook()).removeValue();
                adapter();
                break;
        }
        return super.onContextItemSelected(item);
    }

}

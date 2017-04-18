package com.example.huy.assignment_inf205.Source_Code;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.huy.assignment_inf205.Model.book;
import com.example.huy.assignment_inf205.R;
import com.firebase.client.Firebase;
public class AddActivity extends AppCompatActivity {
    TextView tvtitle;
    Button btnAdd, btnCancel;
    EditText idbook, namebook, nametacgia, sluong;
    Spinner theloai, trangthai;
    String[] listtatus = {"Còn hàng", "Hết hàng"};
    String[] listTheloai = {"Sách giáo khoa","Sách khoa học","Sách Y học","Sách tiếng Anh","Sách Hóa học"};
    Firebase root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Firebase.setAndroidContext(this);
        GetAllWidgets();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addBook();
            }
        });
    }
    private void GetAllWidgets(){
        root = new Firebase("https://assignment-inf205.firebaseio.com/");
        String title = getIntent().getExtras().getString("title").toString();
        tvtitle = (TextView) findViewById(R.id.titletv);
        tvtitle.setText(title);
        idbook = (EditText) findViewById(R.id.edtDialogId);
        namebook = (EditText) findViewById(R.id.edtDialogName);
        nametacgia = (EditText) findViewById(R.id.edtDialogTacgia);
        sluong = (EditText) findViewById(R.id.edtDialogsl);
        theloai = (Spinner) findViewById(R.id.spinner1);
        trangthai = (Spinner) findViewById(R.id.spnDialogStatus);
        btnAdd = (Button) findViewById(R.id.btnadd);
        btnCancel = (Button) findViewById(R.id.btnHuy);
        spinnerAdapter();
    }
    public void spinnerAdapter(){
        ArrayAdapter<String> adapterS = new ArrayAdapter<>(AddActivity.this, android.R.layout.simple_spinner_item, listtatus);
        trangthai.setAdapter(adapterS);
        ArrayAdapter<String> adapterT = new ArrayAdapter<>(AddActivity.this, android.R.layout.simple_spinner_item, listTheloai);
        theloai.setAdapter(adapterT);

    }
    public void addBook(){
        boolean tt;
        String ma = idbook.getText().toString();
        String ten = namebook.getText().toString();
        String tg = nametacgia.getText().toString();
        int sl = Integer.parseInt(sluong.getText().toString());
        String tl = theloai.getSelectedItem().toString();
        int selectStatus = trangthai.getSelectedItemPosition();
        if(selectStatus == 0){
            tt = true;
        }else{
            tt = false;
        }
        book sach = new book(ma, tl, ten, tg, sl, tt);
        root.child("book").child(ma).setValue(sach);
    }
}

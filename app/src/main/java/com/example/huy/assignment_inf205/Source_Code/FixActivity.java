package com.example.huy.assignment_inf205.Source_Code;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.huy.assignment_inf205.Model.book;
import com.example.huy.assignment_inf205.R;
import com.firebase.client.Firebase;

public class FixActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_fix);
        Firebase.setAndroidContext(this);
        GetAllWidgets();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fixBook();
            }
        });
    }

    private void GetAllWidgets(){
        root = new Firebase("https://assignment-inf205.firebaseio.com/");
        tvtitle = (TextView) findViewById(R.id.titletv);
        idbook = (EditText) findViewById(R.id.edtFix1);
        namebook = (EditText) findViewById(R.id.edtFix2);
        nametacgia = (EditText) findViewById(R.id.edtFix3);
        sluong = (EditText) findViewById(R.id.edtFix4);
        theloai = (Spinner) findViewById(R.id.spnFix1);
        trangthai = (Spinner) findViewById(R.id.spnFix2);
        btnAdd = (Button) findViewById(R.id.btnFix1);
        btnCancel = (Button) findViewById(R.id.btnFix2);
        spinnerAdapter();
        showInfo();
    }
    public void showInfo(){
        book oldBook = (book) getIntent().getExtras().getSerializable("data");
        idbook.setText(oldBook.getIdbook());
        idbook.setEnabled(false);
        namebook.setText(oldBook.getNamebook());
        nametacgia.setText(oldBook.getTacgia());
        sluong.setText(String.valueOf(oldBook.getSl()));
        if(oldBook.isStatus()){
            trangthai.setSelection(0);
        }else{
            trangthai.setSelection(1);
        }
        for(int i = 0 ; i<listTheloai.length; i++){
            if(listTheloai[i].equals(oldBook.getTheloai())){
                theloai.setSelection(i);
            }
        }

    }
    public void spinnerAdapter(){
        ArrayAdapter<String> adapterS = new ArrayAdapter<>(FixActivity.this, android.R.layout.simple_spinner_item, listtatus);
        trangthai.setAdapter(adapterS);
        ArrayAdapter<String> adapterT = new ArrayAdapter<>(FixActivity.this, android.R.layout.simple_spinner_item, listTheloai);
        theloai.setAdapter(adapterT);

    }
    public void fixBook(){
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
        startActivity(new Intent(FixActivity.this,storeActivity.class));
    }
}

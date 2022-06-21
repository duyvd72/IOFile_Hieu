package com.example.qlcv_externalfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.qlcv_externalfile.model.Staff;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    EditText edtName, edtDoB;
    Button btnSearch;
    ListView lv;

    ArrayAdapter<Staff> lvAdapter;

    List<Staff> listStaff;
    String filename = "staff.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        edtName = findViewById(R.id.edt_name);
        edtDoB = findViewById(R.id.edt_dob);
        btnSearch = findViewById(R.id.btn_search);
        lv = findViewById(R.id.lv);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSearchListener();
            }
        });
    }

    private void btnSearchListener() {
        listStaff = IOFile.doc(this, filename);
        List<Staff> result = new ArrayList<>();
        String name = edtName.getText().toString();
        String dob = edtDoB.getText().toString();
        for (Staff staff : listStaff) {
            if (staff.getName().equalsIgnoreCase(name) && staff.getDob().equals(dob)) {
                result.add(staff);
            }
        }
        lvAdapter = new ArrayAdapter<Staff>(this, android.R.layout.simple_list_item_1, result);
        lv.setAdapter(lvAdapter);
    }
}
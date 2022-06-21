package com.example.qlcv_externalfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.example.qlcv_externalfile.model.Staff;

import java.util.ArrayList;
import java.util.List;

public class QLNVActivity extends AppCompatActivity {

    EditText edtName, edtDoB, edtCountry;
    Button btnAdd;
//    Spinner spnLevel;
    RadioGroup rdoGroup;
    ListView lvStaff;

    ArrayAdapter<String> spnAdapter;
    ArrayAdapter<Staff> lvAdapter;
    List<Staff> listStaff;
    String filename = "staff.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlnv);

        edtName = findViewById(R.id.edt_name);
        edtDoB = findViewById(R.id.edt_dob);
        edtCountry = findViewById(R.id.edt_country);
//        spnLevel = findViewById(R.id.spn_level);
        rdoGroup = findViewById(R.id.rdo_group);
        lvStaff = findViewById(R.id.lv_staff);
        btnAdd = findViewById(R.id.btn_add);

//        String[] data = {"Cao Dang", "Dai hoc", "sau dai hoc"};
//        spnAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
//        spnLevel.setAdapter(spnAdapter);

        loadData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddListener();
            }
        });

    }

    private void loadData() {
        listStaff = new ArrayList<>();
        listStaff = IOFile.doc(this, filename);
        lvAdapter = new ArrayAdapter<Staff>(this, android.R.layout.simple_list_item_1, listStaff);
        lvStaff.setAdapter(lvAdapter);
    }

    private void btnAddListener() {
        String name = edtName.getText().toString();
        String dob = edtDoB.getText().toString();
        String country = edtCountry.getText().toString();
//        String level = spnLevel.getSelectedItem().toString();
        RadioButton selected = findViewById(rdoGroup.getCheckedRadioButtonId());
        String level = selected.getText().toString();

        if (listStaff.size() > 0) {
            Staff.setSma(listStaff.get(listStaff.size() - 1).getId() + 1);
        }
        Staff s = new Staff(name, dob, country, level);
        listStaff.add(s);
        IOFile.ghi(this, filename, listStaff);
        loadData();

    }
}
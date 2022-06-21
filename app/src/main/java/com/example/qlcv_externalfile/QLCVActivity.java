package com.example.qlcv_externalfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.qlcv_externalfile.model.Position;
import com.example.qlcv_externalfile.model.Staff;
import com.example.qlcv_externalfile.model.StaffPosition;

import java.time.LocalDate;
import java.util.List;

public class QLCVActivity extends AppCompatActivity {

    Spinner spnStaff, spnPosition;
    Button btnAdd;
    ListView lv;

    ArrayAdapter<Staff> spn1Adapter;
    ArrayAdapter<Position> spn2Adapter;
    ArrayAdapter<StaffPosition> lvAdapter;

    List<Staff> listStaff;
    List<Position> listPosition;
    List<StaffPosition> listStaffPosition;

    String fileStaff = "staff.txt";
    String filePosition = "position.txt";
    String filename = "sp.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlcv);

        spnStaff = findViewById(R.id.spn_staff);
        spnPosition = findViewById(R.id.spn_position);
        btnAdd = findViewById(R.id.btn_add);
        lv = findViewById(R.id.lv);

        listStaff = IOFile.doc(this, fileStaff);
        spn1Adapter = new ArrayAdapter<Staff>(this, android.R.layout.simple_spinner_item, listStaff);
        spnStaff.setAdapter(spn1Adapter);

        listPosition = IOFile.doc(this, filePosition);
        spn2Adapter = new ArrayAdapter<Position>(this, android.R.layout.simple_spinner_item, listPosition);
        spnPosition.setAdapter(spn2Adapter);

        loadData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddListenre();
            }
        });
    }

    private void btnAddListenre() {
        Staff staff = (Staff) spnStaff.getSelectedItem();
        Position position = (Position) spnPosition.getSelectedItem();
        if (listStaffPosition.size() > 0) {
            StaffPosition.setSma(listStaffPosition.get(listStaffPosition.size() - 1).getId() + 1);
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            StaffPosition sp = new StaffPosition(LocalDate.now().toString(), "", staff, position);
            listStaffPosition.add(sp);
            IOFile.ghi(this, filename, listStaffPosition);
            loadData();
        }

    }

    private void loadData() {
        listStaffPosition = IOFile.doc(this, filename);
        lvAdapter = new ArrayAdapter<StaffPosition>(this, android.R.layout.simple_list_item_1, listStaffPosition);
        lv.setAdapter(lvAdapter);
    }
}
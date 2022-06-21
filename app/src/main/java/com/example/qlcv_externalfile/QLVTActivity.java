package com.example.qlcv_externalfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.qlcv_externalfile.model.Position;

import java.util.ArrayList;
import java.util.List;

public class QLVTActivity extends AppCompatActivity {

    EditText edtName, edtDes;
    Button btnAdd;
    ListView lvPosition;

    ArrayAdapter<Position> lvAdapter;

    List<Position> listPosition;

    String filename = "position.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlvt);

        edtName = findViewById(R.id.edt_name);
        edtDes = findViewById(R.id.edt_des);
        btnAdd = findViewById(R.id.btn_add);
        lvPosition = findViewById(R.id.lv_position);

        loadData();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddListener();
            }
        });
    }

    private void btnAddListener() {
        String name = edtName.getText().toString();
        String des = edtDes.getText().toString();
        if (listPosition.size() > 0) {
            Position.setSma(listPosition.get(listPosition.size() - 1).getId() + 1);
        }
        Position position = new Position(name, des);
        listPosition.add(position);
        IOFile.ghi(this, filename, listPosition);
        loadData();
    }

    private void loadData() {
        listPosition = new ArrayList<>();
        listPosition = IOFile.doc(this, filename);
        lvAdapter = new ArrayAdapter<Position>(this, android.R.layout.simple_list_item_1, listPosition);
        lvPosition.setAdapter(lvAdapter);
    }
}
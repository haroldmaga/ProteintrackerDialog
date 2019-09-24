package com.example.proteintracker50;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class listactivity extends AppCompatActivity {
    String[] items ={"Harold", "Erick", "Aru", "Brian", "Ryan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        ListView listView = findViewById(R.id.lvMhs);
        Spinner spinner = findViewById(R.id.mhsSpinner);

        listView.setAdapter(new ArrayAdapter<String>(listactivity.this, android.R.layout.simple_list_item_1,items));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(listactivity.this, android.R.layout.simple_spinner_item,items);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(listactivity.this, "Anda memilih = " + items [i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(listactivity.this, "Anda tidak memilih", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(listactivity.this, "Anda memilih = " +  items [i], Toast.LENGTH_SHORT).show();
            }
        });
    }


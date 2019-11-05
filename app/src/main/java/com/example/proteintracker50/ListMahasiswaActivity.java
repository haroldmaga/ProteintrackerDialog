package com.example.proteintracker50;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListMahasiswaActivity extends AppCompatActivity {
    String[] items ={"Harold", "Erick", "Aru", "Brian", "Ryan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        ListView listView = findViewById(R.id.lvMhs);
        Spinner spinner = findViewById(R.id.mhsSpinner);

        listView.setAdapter(new ArrayAdapter<String>(ListMahasiswaActivity.this, android.R.layout.simple_list_item_1,items));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(ListMahasiswaActivity.this, android.R.layout.simple_spinner_item,items);

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListMahasiswaActivity.this, "Anda memilih = " + items [i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(ListMahasiswaActivity.this, "Anda tidak memilih", Toast.LENGTH_SHORT).show();
            }
        });
        @Override
        public  void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
            super.onCreateContextMenu(menu, view, menuInfo);
            menu.setHeaderTitle("Silahkan pilih");
            menu.add(0,listView.getId(), 0,"Edit");
            menu.add(0,listView.getId(), 0, "Delete");
        }

        public boolean onContextItemSelected(MenuItem item){
            if (item.getTitle() == "Edit"){
                Toast.makeText(getApplicationContext(), "Di edit", Toast.LENGTH_SHORT).show();
            } else if(item.getTitle() == "Delete"){
                Toast.makeText(getApplicationContext(), "di hapus", Toast.LENGTH_SHORT).show();
            } else {
                return false;
            }
            return true;
        }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu1, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item) {
            if (item.getItemId() == R.id.item1) {
                Toast.makeText(getApplicationContext(), "fragmen di klick", Toast.LENGTH_SHORT).show();
            }
            if (item.getItemId() == R.id.item2) {
                Toast.makeText(getApplicationContext(), "list di klick", Toast.LENGTH_SHORT).show();
            } if (item.getItemId() == R.id.item3){
                Toast.makeText(getApplicationContext(), "protein tracker di klick", Toast.LENGTH_SHORT).show();
            }
            return true;
        }


/*private void addData(){
    dataMhsArrayList = new ArrayList<>();
    dataMhsArrayList.add(new DataMhs("Aru","72160029","Pria","Programmer","Usaha tidak menghianati hasil"));
    dataMhsArrayList.add(new DataMhs("Harold", "72160050", "Pria", "Pengusaha", "Hidup Santuy"));
    dataMhsArrayList.add(new DataMhs("Brian", "72160025", "Pria", "Pengusaha", "Kejarlah ilmu sampai keCina"));
    dataMhsArrayList.add(new DataMhs("Erick", "72160085", "Pria", "Programmer", "Hormati orang tua"));
}*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListMahasiswaActivity.this, "Anda memilih = " +  items [i], Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void GoToCreate(View view) {
        Intent intent = new Intent(ListMahasiswaActivity.this, CreateMhsActivity.class);
        startActivity(intent);
    }

    public void GoToUpdate(View view) {
        Intent intent = new Intent(ListMahasiswaActivity.this, UpdateMhsActivity.class);
        startActivity(intent);
    }
}

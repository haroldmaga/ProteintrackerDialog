package proteintracker.com;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proteintracker50.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //context Menu
        String ContMenu [] = {"ayam","Kuda","Ikan","Gajah"};
        ListView lv = (ListView) findViewById(R.id.lstView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>( this,android.R.layout.simple_list_item_1,ContMenu);
        lv.setAdapter(adapter);
        registerForContextMenu(lv);
        //Context Menu
    }
    //Context Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("Silahkan Pilih");
        menu.add(0,view.getId(),0,"simpan");
        menu.add(0,view.getId(),0,"Tidak");
    }
    public boolean onContextItemSelected(MenuItem item){
        if (item.getTitle() == "Simpan"){
            Toast.makeText(getApplicationContext(),"Ex : item disimpan",Toast.LENGTH_SHORT).show();
        }
        else if (item.getTitle() == "Tidak"){
            Toast.makeText(getApplicationContext(), "Tidak disimpan", Toast.LENGTH_SHORT).show();
        }
        else {
            return false;
        }
        return  true;
    }

    //Nampilin Icon Titik 3 Atas Kanan
    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;

    }
    // Menu Options
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.item1){
            Toast.makeText(getApplicationContext(), "Menu Pertama Yang di Klik", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.item2){
            Toast.makeText(getApplicationContext(),"Menu Kedua Di Klik",Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.item3){
            Toast.makeText(getApplicationContext(), "Menu Ketiga Yang di Klik", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() ==R.id.item4){
            Toast.makeText(getApplicationContext(),"Menu Ketiga Di Klik",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}

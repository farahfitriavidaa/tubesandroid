package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] daftar;
    ListView ListView01;
    Menu menu;
    protected Cursor cursor;
    Database dbapp;
    public static MainActivity ma;
    Button pindahButton;
    Button pindahPlay;
    Button pindahLogin;
    Button pindahFavorit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pindahButton = findViewById(R.id.pindahbuttonsatu);
        pindahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DuaActivity.class);
                startActivity(intent);
            }
        });

        pindahPlay = findViewById(R.id.button1);
        pindahPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registrasi.class);
                startActivity(intent);
            }
        });

        pindahLogin = findViewById(R.id.button2);
        pindahLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Play.class);
                startActivity(intent);
            }
        });

//        pindahFavorit = findViewById(R.id.button3);
//        pindahFavorit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Favorit.class);
//                startActivity(intent);
//            }
//        });
    }

    public void RefreshList() {
        SQLiteDatabase db = dbapp.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM akun", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int no = 0; no < cursor.getCount(); no++) {
            cursor.moveToPosition(no);
            daftar[no] = cursor.getString(1).toString();
        }
        ListView01 = findViewById(R.id.listView01);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
//                final CharSequence dialogitem = {"Lihat", "Update", "Hapus"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Pilihan");
//                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int pilihan) {
//                        switch (pilihan) {
//                            case 0:
//                                Intent i = new Intent(getApplica    tionContext(), Registrasi.class);
//                                i.putExtra("username", selection);
//                                break;
//                        }
//                    }
//            });
                builder.create().show();
        }
    });
        ((ArrayAdapter) ListView01.getAdapter()).notifyDataSetInvalidated();




}
}



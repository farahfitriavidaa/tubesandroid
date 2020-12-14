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
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] daftar;
    Menu menu;
    ListView listView01;
    protected Cursor cursor;
    Database dbapp;
    public static MainActivity ma;
    Button pindahButton;
    Button pindahPlay;
    Button pindahLogin;
    Button pindahEdit;
    Button pindahcari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pindahcari = findViewById(R.id.button4);
        pindahcari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cari.class);
                startActivity(intent);
            }
        });
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

        pindahEdit = findViewById(R.id.button3);
        pindahEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Edit.class);
                startActivity(intent);
            }
        });
    }

    public void RefreshList(){
        SQLiteDatabase db = dbapp.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM akun", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for(int no=0;no<cursor.getCount();no++){
            cursor.moveToPosition(no);
            daftar[no] = cursor.getString(1).toString();
        }
        listView01 = findViewById(R.id.yolist);
        listView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,daftar));
        listView01.setSelected(true);
        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0 , View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat","Update","Hapus"};
                AlertDialog.Builder builder  = new AlertDialog.Builder(MainActivity.ma);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch(which){
                            case 0:
                                Intent i = new Intent(getApplicationContext(),LihatAkun.class);
                                i.putExtra("username",selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(),LihatAkun.class);
                                in.putExtra("username",selection);
                                startActivity(in);
                                break;
                            case 2:
                                SQLiteDatabase db = dbapp.getWritableDatabase();
                                db.execSQL("delete from akun where username = '" + selection +  "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) listView01.getAdapter()).notifyDataSetInvalidated();
    }
}
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
    Button pindahButton;
    Button pindahPlay;
    Button pindahLogin;
    Button pindahEdit;
    Button pindahcari;
    Button pindahHome;
    Button pindahFavorit;
    Button pindahcaridua;
    Button pindahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pindahcaridua = findViewById(R.id.caridua);
        pindahcaridua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, caridua.class);
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

        pindahHome = findViewById(R.id.home);
        pindahHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Home.class);
                startActivity(intent);
            }
        });

        pindahFavorit = findViewById(R.id.favorit);
        pindahFavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Favorit.class);
                startActivity(intent);
            }
        });

        pindahList = findViewById(R.id.list);
        pindahList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,List.class);
                startActivity(intent);
            }
        });
    }


}
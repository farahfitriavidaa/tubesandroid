package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Registrasi extends Activity {
    protected Cursor cursor;
    Database dbapp;
    Button btn1,kembali;
    EditText email,user,pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi);

        dbapp = new Database(this);
        email = findViewById(R.id.email);
        user  = findViewById(R.id.username);
        pass  = findViewById(R.id.password);
        btn1  = findViewById(R.id.ButtonLogin);
        kembali = findViewById(R.id.back);

        //register
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEmail    = email.getText().toString();
                String strUsername = user.getText().toString();
                String strPassword = pass.getText().toString();
                Boolean daftar = dbapp.insertUser(strEmail,strUsername,strPassword);
                if(daftar == true){
                    Toast.makeText(getApplicationContext(),"Daftar Berhasil",Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(Registrasi.this, DuaActivity.class);
                    startActivity(loginIntent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Daftar Gagal",Toast.LENGTH_SHORT).show();
                }

            }
        });

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n = new Intent(Registrasi.this,Halaman2.class);
                startActivity(n);
            }
        });
    }
    }



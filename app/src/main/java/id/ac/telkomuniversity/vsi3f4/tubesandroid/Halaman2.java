package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class Halaman2 extends AppCompatActivity {
    Button regis,login,keluar;
    private MediaPlayer mp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.halaman2);

        mp = new MediaPlayer();
        mp = MediaPlayer.create(this, R.raw.lagu);

        /** Memutar Audio */
        mp.start();

        regis = findViewById(R.id.registrasi);
        login = findViewById(R.id.login);
        keluar = findViewById(R.id.keluar);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                Intent in = new Intent(Halaman2.this,Registrasi.class);
                startActivity(in);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                Intent inr = new Intent(Halaman2.this,DuaActivity.class);
                startActivity(inr);
            }
        });

        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                finish();
            }
        });
    }

}

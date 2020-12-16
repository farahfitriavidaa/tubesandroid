package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Notifikasi extends Activity {

    Button notif;
    Button pembaruan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifikasi);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        notif = findViewById(R.id.button10);
        pembaruan = findViewById(R.id.button11);

        pembaruan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notifikasi.this,Pembaruan.class);
                startActivity(intent);
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            Intent intent = new Intent(Notifikasi.this, Home.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_favorite:
                            Intent inten = new Intent(Notifikasi.this, Favorit.class);
                            startActivity(inten);
                            break;
                        case R.id.nav_notificaton:
                            Intent intens = new Intent(Notifikasi.this,Notifikasi.class);
                            startActivity(intens);
                            break;
                        case R.id.nav_profile:
                            Intent intern = new Intent(Notifikasi.this, Edit.class);
                            startActivity(intern);
                            break;
                        case R.id.nav_search:
                            Intent inte = new Intent(Notifikasi.this, caridua.class);
                            startActivity(inte);
                            break;
                    }
                    return false;
                }
            };
}


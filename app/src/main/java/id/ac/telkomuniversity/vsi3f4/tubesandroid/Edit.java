package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Edit extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            Intent intent = new Intent(Edit.this, Home.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_favorite:
                            Intent inten = new Intent(Edit.this, Favorit.class);
                            startActivity(inten);
                            break;
                        case R.id.nav_notificaton:
                            Intent intens = new Intent(Edit.this,Notifikasi.class);
                            startActivity(intens);
                            break;
                        case R.id.nav_profile:
                            Intent intern = new Intent(Edit.this, Edit.class);
                            startActivity(intern);
                            break;
                        case R.id.nav_search:
                            Intent inte = new Intent(Edit.this, caridua.class);
                            startActivity(inte);
                            break;
                    }
                    return true;
                }
            };
}

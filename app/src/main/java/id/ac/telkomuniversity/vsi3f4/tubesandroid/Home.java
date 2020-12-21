package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static android.media.MediaPlayer.create;

public class Home extends AppCompatActivity {
    Button list,profil;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
    MediaPlayer player;
    private static final String isPlay = "Pemutar Media";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        list = findViewById(R.id.button7);
        profil = findViewById(R.id.button8);
        btn1 = findViewById(R.id.button16);
        btn2 = findViewById(R.id.button17);
        btn3 = findViewById(R.id.button15);
        btn4 = findViewById(R.id.button11);
        btn5 = findViewById(R.id.button);
        btn6 = findViewById(R.id.button10);
        btn7 = findViewById(R.id.button9);
        btn8 = findViewById(R.id.button13);
        btn9 = findViewById(R.id.button12);
        btn10 = findViewById(R.id.button14);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn = new Intent(Home.this,List.class);
                startActivity(inn);
            }
        });

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rr = new Intent(Home.this,Edit.class);
                startActivity(rr);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(9);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(10);
            }
        });
    }

    private void playSound(int arg){
        try{
            if (player.isPlaying()){
                player.stop();
                player.release();
            }
        }catch (Exception e){
            Toast.makeText(this, "Masuk Lagu", Toast.LENGTH_LONG).show();
        }
        if (arg ==1){
            Toast.makeText(this, isPlay+ "Update 1", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.kenangan);
        }else if (arg ==2){
            Toast.makeText(this, isPlay+ "Update 2", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.its);
        }else if (arg ==3){
            Toast.makeText(this, isPlay+ "Update 3", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.justin);
        }else if (arg ==4){
            Toast.makeText(this, isPlay+ "Update 4", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.kumau);
        }else if (arg ==5){
            Toast.makeText(this, isPlay+ "Update 5", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.stuck);
        }else if (arg ==6){
            Toast.makeText(this, isPlay+ "Update 6", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.nanti);
        }else if (arg ==7) {
            Toast.makeText(this, isPlay + "Update 7", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.passion);
        }else if (arg ==8) {
            Toast.makeText(this, isPlay + "Update 8", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.luka);
        }else if (arg ==9) {
            Toast.makeText(this, isPlay + "Update 9", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.lostyou);
        }else if (arg ==10) {
            Toast.makeText(this, isPlay + "Update 10", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.boyfriend);
        }
        player.setLooping(true);
        player.start();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            player.stop();
                            Intent intent = new Intent(Home.this, Home.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_favorite:
                            player.stop();
                            Intent inten = new Intent(Home.this, Favorit.class);
                            startActivity(inten);
                            break;
                        case R.id.nav_notificaton:
                            player.stop();
                                Intent intens = new Intent(Home.this,Notifikasi.class);
                                startActivity(intens);
                            break;
                        case R.id.nav_profile:
                            player.stop();
                            Intent intern = new Intent(Home.this, Edit.class);
                            startActivity(intern);
                            break;
                        case R.id.nav_search:
                            player.stop();
                            Intent inte = new Intent(Home.this, caridua.class);
                            startActivity(inte);
                            break;
                    }
                    return false;
                }
            };

}



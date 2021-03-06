package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Favorit extends Activity {
    private static final String isPlay = "Pemutar Media Favorite";
    MediaPlayer player;
    Button button1,button2,button3,button4,button5,button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorit);
        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(1);
            }
        });
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(2);
            }
        });
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(3);
            }
        });
        button3 = (Button)findViewById(R.id.button4);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(4);
            }
        });
        button5 = (Button)findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(5);
            }
        });
        button6 = (Button)findViewById(R.id.button5);
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(6);
            }
        });
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }
    public void onPause(){
        try{
            super.onPause();
            player.pause();
        }catch (Exception e){
        }
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
            Toast.makeText(this, isPlay+ "Favorit 1", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.cinta);
        }else if (arg ==2){
            Toast.makeText(this, isPlay+ "Favorit 2", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.its);
        }else if (arg ==3){
            Toast.makeText(this, isPlay+ "Favorit 3", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.justin);
        }else if (arg ==4){
            Toast.makeText(this, isPlay+ "Favorit 4", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.kumau);
        }else if (arg ==5){
            Toast.makeText(this, isPlay+ "Favorit 5", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.luka);
        }else if (arg ==6){
            Toast.makeText(this, isPlay+ "Favorit 6", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.nanti);
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
                            Intent intent = new Intent(Favorit.this, Home.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_favorite:
                            Intent inten = new Intent(Favorit.this, Favorit.class);
                            startActivity(inten);
                            break;
                        case R.id.nav_notificaton:
                            Intent intens = new Intent(Favorit.this,Notifikasi.class);
                            startActivity(intens);
                            break;
                        case R.id.nav_profile:
                            Intent intern = new Intent(Favorit.this, Edit.class);
                            startActivity(intern);
                            break;
                        case R.id.nav_search:
                            Intent inte = new Intent(Favorit.this, caridua.class);
                            startActivity(inte);
                            break;
                    }
                    return false;
                }
            };
}

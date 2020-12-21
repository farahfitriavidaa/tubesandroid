package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    Animation Animasi1,Animasi2,Animasi3;
    ImageView logonya;
    TextView judul,slogan;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.splashscreen);


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Halaman2.class));
                finish();
            }
        }, 4000L); //3000 L = 3 detik

        Animasi1 = AnimationUtils.loadAnimation(this,R.anim.blink_anim);
        Animasi2 = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        Animasi3 = AnimationUtils.loadAnimation(this,R.anim.bounce);

        logonya = findViewById(R.id.logo);
        judul   = findViewById(R.id.namaaplikasi);
        slogan  = findViewById(R.id.slogan);

        logonya.setAnimation(Animasi2);
        judul.setAnimation(Animasi1);
        slogan.setAnimation(Animasi3);
    }
}

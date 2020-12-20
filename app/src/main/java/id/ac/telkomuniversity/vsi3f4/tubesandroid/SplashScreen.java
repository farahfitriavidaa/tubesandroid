package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;

public class SplashScreen extends Activity {
    Animation Animasi1,Animasi2,Animasi3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splashscreen);
    }
}

package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button pindahButton;
    Button pindahPlay;
    Button pindahLogin;
    Button pindahEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent intent = new Intent(MainActivity.this, Play.class);
                startActivity(intent);
            }
        });
    }

    //Haii aku farah
    //hallo

    //nannana

    //hshhs
}
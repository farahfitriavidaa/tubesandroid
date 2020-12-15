package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DuaActivity extends Activity {
        Database db;
        Button login,register;
        EditText username, password;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.loggin);

            db = new Database(this);
            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            login    = findViewById(R.id.ButtonLogin);


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String strUsername = username.getText().toString();
                    String strPassword = password.getText().toString();
                    Boolean masuk = db.checkLogin(strUsername,strPassword);
                    if(masuk == true) {
                        Boolean updateSession = db.upgradeSession("ada", 1);
                        if (updateSession == true) {
                            Toast.makeText(getApplicationContext(), "Berhasil Masuk", Toast.LENGTH_SHORT).show();
                            Intent mainIntent = new Intent(DuaActivity.this, MainActivity.class);
                            startActivity(mainIntent);
                            finish();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Masuk Gagal",Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
}
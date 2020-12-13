package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
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
    Button btn1;
    EditText email,user,pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrasi);

        dbapp = new Database(this);
        email = findViewById(R.id.email);
        user  = findViewById(R.id.username);
        pass  = findViewById(R.id.password);
        btn1  = findViewById(R.id.ButtonLogin);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbapp.getWritableDatabase();
                db.execSQL("insert into akun(email, username, password) values(''" +
                        email.getText().toString() + "','" +
                        user.getText().toString() + "','" +
                        pass.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}

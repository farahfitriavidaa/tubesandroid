package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LihatAkun extends Activity {
    protected Cursor cursor;
    Database dbapp;
    Button btn1;
    TextView text1, text2, text3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lihatakun);

        dbapp = new Database(this);
//        text1 = findViewById(R.id.textView);
//        SQLiteDatabase db = dbapp.getReadableDatabase();
//        cursor = db.rawQuery("SELECT * FROM akun WHERE username = '" +
//                getIntent().getStringExtra("username") + "'");
//        cursor.moveToFirst();

    }
}
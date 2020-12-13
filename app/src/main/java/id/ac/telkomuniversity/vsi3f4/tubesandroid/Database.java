package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "aplikasimusic.db";
    private static final int DATABASE_VERSION = 1;
    public Database(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String akun = "create table akun(username text primary key,email email null,  password text null)";
        String lagu = "create table lagu(idlagu integer primary key, judul text null, poster text null, lagu text null)";
        String lagufav = "create table lagufav(username text foreign key, idlagu integer foreign key)";
        Log.d("Data","OnCreate " + akun + lagu + lagufav);
        db.execSQL(akun);
        db.execSQL(lagu);
        db.execSQL(lagufav);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

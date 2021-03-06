package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class caridua extends ListActivity {

    //Aray list akan di simpan di dalam searchResults
    ArrayList<HashMap<String, Object>> searchResults;

    //ArrayList akan menyimpan data asli dari originalValues
    ArrayList<HashMap<String, Object>> originalValues;
    LayoutInflater inflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.caridua);
        final EditText kotakpencari = (EditText) findViewById(R.id.kotakpencari);
        ListView playersListView = (ListView) findViewById(android.R.id.list);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //mengambil LayoutInflater untuk inflating thcustomView
        //disini akan menggunakan custom adapter
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //disini data aray akan di deklarasikan
        //dan akan disimpan ke dalam Arraylist
        //tipe data string untuk textview integer untuk gambar icon
        String namabarangs[] = {"AFGAN", "ROCK", "ROSA", "RIZKY FEBIAN"};
        String hargabarangs[] = {"Terima Kasih Cinta", "Metal", "Terlalu Cinta", "Mantra Cinta"};
        Integer[] icons = {R.drawable.afgan, R.drawable.rock, R.drawable.rosa, R.drawable.iki};

        originalValues = new ArrayList<HashMap<String, Object>>();

        //hasmap akan menyimpan data sementara dalam listview
        HashMap<String, Object> temp;

        //jumlah baris dalam ListView
        int noOfPlayers = namabarangs.length;

        //pengulangan dalam Arraylist
        for (int i = 0; i < noOfPlayers; i++) {
            temp = new HashMap<String, Object>();

            temp.put("namabarang", namabarangs[i]);
            temp.put("hargabarang", hargabarangs[i]);
            temp.put("icon", icons[i]);

            //menambah kan baris ke dalam  ArrayList
            originalValues.add(temp);
        }
        //searchResults sama dengan OriginalValues
        searchResults = new ArrayList<HashMap<String, Object>>(originalValues);

        //membuat adapter
        //first param-the context
        //second param-the id of the layout file
        //you will be using to fill a row
        //third param-the set of values that
        //will populate the ListView
        final CustomAdapter adapter = new CustomAdapter(this, R.layout.daftar_caridua, searchResults);

        //menset adapter di dalam listview
        playersListView.setAdapter(adapter);
        kotakpencari.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //mengambil text di dalam  EditText
                String searchString = kotakpencari.getText().toString();
                int textLength = searchString.length();
                searchResults.clear();

                for (int i = 0; i < originalValues.size(); i++) {
                    String playerName = originalValues.get(i).get("namabarang").toString();
                    if (textLength <= playerName.length()) {
                        //membandingkan data String didalam EditText dengan namabarangs  di dalam ArrayList
                        if (searchString.equalsIgnoreCase(playerName.substring(0, textLength)))
                            searchResults.add(originalValues.get(i));
                    }
                }
                adapter.notifyDataSetChanged();
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            public void afterTextChanged(Editable s) {
            }
        });
    }

    //mendefinisikan custom adapter
    private class CustomAdapter extends ArrayAdapter<HashMap<String, Object>> {
        public CustomAdapter(Context context, int textViewResourceId,
                             ArrayList<HashMap<String, Object>> Strings) {


            super(context, textViewResourceId, Strings);
        }

        //class untuk menyimpan baris konten (cacheview) di listview
        private class ViewHolder {
            ImageView icon;
            TextView namabarang, hargabarang;
        }

        ViewHolder viewHolder;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.daftar_caridua, null);
                viewHolder = new ViewHolder();

                //isi konten (cache the views)
                viewHolder.icon = (ImageView) convertView.findViewById(R.id.icon);
                viewHolder.namabarang = (TextView) convertView.findViewById(R.id.namabarang);
                viewHolder.hargabarang = (TextView) convertView.findViewById(R.id.hargabarang);

                //menghubungkan cached views ke dalam convertview
                convertView.setTag(viewHolder);
            } else
                viewHolder = (ViewHolder) convertView.getTag();
            int iconId = (Integer) searchResults.get(position).get("icon");

            //menset data untuk ditampilkan
            viewHolder.icon.setImageDrawable(getResources().getDrawable(iconId));
            viewHolder.namabarang.setText(searchResults.get(position).get("namabarang").toString());
            viewHolder.hargabarang.setText(searchResults.get(position).get("hargabarang").toString());
            //mengembalikan view untuk ditampilkan
            return convertView;
        }
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        super.onListItemClick(l, v, position, id);//menggunakan method onliistitemclick dan mencarinya
        //berdasarkan posisi
        String str = searchResults.get(position).get("namabarang").toString();
        try {
            if (str == "AFGAN") {
                Toast.makeText(getApplicationContext(), "Terima Kasih Cinta", Toast.LENGTH_SHORT).show();
                //menampilkan pesan text toast saat nama barang diklik kalian bisa mengganti intent di baris ini
            }
            if (str == "ROCK") {
                Toast.makeText(getApplicationContext(), "Metal", Toast.LENGTH_SHORT).show();
            }
            if (str == "ROSA") {
                Toast.makeText(getApplicationContext(), "Terlalu Cinta", Toast.LENGTH_SHORT).show();
            }
            if (str == "RIZKY FEBIAN") {
                Toast.makeText(getApplicationContext(), "Mantra Cinta", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            Intent intent = new Intent(caridua.this, Home.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_favorite:
                            Intent inten = new Intent(caridua.this, Favorit.class);
                            startActivity(inten);
                            break;
                        case R.id.nav_notificaton:
                            Intent intens = new Intent(caridua.this,Notifikasi.class);
                            startActivity(intens);
                            break;
                        case R.id.nav_profile:
                            Intent intern = new Intent(caridua.this, Edit.class);
                            startActivity(intern);
                            break;
                        case R.id.nav_search:
                            Intent inte = new Intent(caridua.this, caridua.class);
                            startActivity(inte);
                            break;
                    }
                    return false;
                }
            };
}
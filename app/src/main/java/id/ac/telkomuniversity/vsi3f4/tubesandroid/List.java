package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class List extends Activity {
    private static final String isPlay = "List Play Music";
    MediaPlayer player;
    ImageButton lg1, lg2, lg3, lg4, lg5, lg6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        lg1 = (ImageButton) findViewById(R.id.lg1);
        lg1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(1);
            }
        });
        lg2 = (ImageButton) findViewById(R.id.lg2);
        lg2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(2);
            }
        });
        lg3 = (ImageButton) findViewById(R.id.lg3);
        lg3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(3);
            }
        });
        lg4 = (ImageButton) findViewById(R.id.lg4);
        lg4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(4);
            }
        });
        lg5 = (ImageButton) findViewById(R.id.lg5);
        lg5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                playSound(5);
            }
        });
        lg6 = (ImageButton) findViewById(R.id.lg6);
        lg6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View arg0){
                Intent in = new Intent(List.this,Play.class);
                startActivity(in);
            }
        });
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
            Toast.makeText(this, "List Lagu", Toast.LENGTH_LONG).show();
        }
        if (arg ==1){
            Toast.makeText(this, isPlay+ "Lagu 1", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.cinta);
        }else if (arg ==2){
            Toast.makeText(this, isPlay+ "Lagu 2", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.its);
        }else if (arg ==3){
            Toast.makeText(this, isPlay+ "Lagu 3", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.justin);
        }else if (arg ==4){
            Toast.makeText(this, isPlay+ "Lagu 4", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.kumau);
        }else if (arg ==5){
            Toast.makeText(this, isPlay+ "Lagu 5", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.luka);
        }else if (arg ==6){
            Toast.makeText(this, isPlay+ "Lagu 6", Toast.LENGTH_LONG).show();
            player = MediaPlayer.create(this, R.raw.nanti);
        }
        player.setLooping(true);
        player.start();
    }
}



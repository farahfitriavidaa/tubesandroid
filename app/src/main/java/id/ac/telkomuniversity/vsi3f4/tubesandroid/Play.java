package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Play extends Activity {
    private Button btn_Play;
    private Button btn_pause;
    private Button btn_stop;
    private MediaPlayer mp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        mp = new MediaPlayer();

        btn_Play = (Button) findViewById(R.id.button1);
        btn_pause = (Button) findViewById(R.id.button2);
        btn_stop = (Button) findViewById(R.id.button3);

        stateAwal();

        btn_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
                btn_Play.setEnabled(false);
                btn_pause.setEnabled(true);
                btn_stop.setEnabled(true);
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pause();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop();
            }
        });
    }

    /** State Awal / Pertama  */
    public void stateAwal(){
        btn_Play.setEnabled(true);
        btn_pause.setEnabled(false);
        btn_stop.setEnabled(false);
    }

    /** Dijalankan Tombol Play */
    private void play() {
        /** Memanggil File MP3 "lagu.mp3" */
        mp = MediaPlayer.create(this, R.raw.lagu);

        try {
            mp.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Memutar Audio */
        mp.start();

        /**  Suara Berakhir */
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    /**  Tombol Pause */
    public void pause(){
        if(mp.isPlaying()){
            if(mp!=null){
                mp.pause();

            }
        } else {
            if(mp!=null){
                mp.start();

            }
        }
    }

    /** Dijalankan Oleh Tombol Stop */
    public void stop(){
        mp.stop();

        try{
            mp.prepare();
            mp.seekTo(0);
        }catch (Throwable t) {
            t.printStackTrace();
        }

        stateAwal();
    }
}
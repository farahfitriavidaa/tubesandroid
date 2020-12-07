package id.ac.telkomuniversity.vsi3f4.tubesandroid;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class Play extends Activity {
    Button btn_Play, btn_pause, btn_stop;
    MediaPlayer mplayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        btn_Play = (Button) findViewById(R.id.button1);
        btn_pause = (Button) findViewById(R.id.button2);
        btn_stop = (Button) findViewById(R.id.button3);
        stateAwal();
        btn_pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pause();
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                stop();
            }
        });
    }
    public void stateAwal() {
        btn_Play.setEnabled(true);
        btn_pause.setEnabled(false);
        btn_stop.setEnabled(false);
    }

    private void play() {
        mplayer = MediaPlayer.create(this,R.raw.lagu);
        try {
            mplayer.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mplayer.start();

        mplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion (MediaPlayer mediaPlayer){
                stateAwal();
            }
        });
    }

    public void pause(){
        if (mplayer.isPlaying())
            if (mplayer!=null){
                mplayer.pause();
            }else{
                if (mplayer!=null){
                    mplayer.start();
                }
            }
    }

    public void stop(){
        mplayer.stop();
        try {
            mplayer.prepare();
            mplayer.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();
    }
}

package co.devbeerloper.sound_serviceapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class AudioService extends Service {


    int posicion = 0;
    MediaPlayer player;









    public AudioService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this,R.raw.song1);
        //TODO write your own code



//        player.setLooping(true);

        // start the player
        player.start();
        Toast.makeText(this, "Service Started :) ", Toast.LENGTH_LONG).show();

        return START_STICKY;

    }



    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        // Stopping the player when service is destroyed
        player.stop();
        Toast.makeText(this, " :( Service Stopped!!!", Toast.LENGTH_LONG).show();
    }

    public void nextSong(){
        if (player != null && player.isPlaying() == false) {
            player.seekTo(posicion);
            player.start();
        }
    }

}

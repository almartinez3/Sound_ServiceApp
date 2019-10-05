package co.devbeerloper.sound_serviceapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    public int posicion;
    MediaPlayer vector []= new MediaPlayer[3];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vector[0]= MediaPlayer.create(this,R.raw.song1);
        vector[1]= MediaPlayer.create(this,R.raw.song2);
        vector[2]= MediaPlayer.create(this,R.raw.song3);

    }




    public void startServiceOnClick (View view){


        vector[posicion].start();

    }


    public void stopServiceOnClick (View view){
        if( vector[posicion] != null){
            vector[posicion].stop();
            vector[0]= MediaPlayer.create(this,R.raw.song1);
            vector[1]= MediaPlayer.create(this,R.raw.song2);
            vector[2]= MediaPlayer.create(this,R.raw.song3);
            posicion=0;
        }




    }


    public void next(View view){
        if(posicion < vector.length-1){
            if(vector[posicion].isPlaying()){
                vector[posicion].stop();
                posicion++;
                vector[posicion].start();
            }else{
                posicion++;
                Toast.makeText(this, " no ha mas canciones", Toast.LENGTH_LONG).show();
                posicion =2;

            }
        }

    }

    public void pause(View view){
        if(vector[posicion].isPlaying()){
            vector[posicion].pause();
        }
    }
    public void prevew (View view){
        if (posicion>=1){
            vector[posicion].stop();
            vector[0]= MediaPlayer.create(this,R.raw.song1);
            vector[1]= MediaPlayer.create(this,R.raw.song2);
            vector[2]= MediaPlayer.create(this,R.raw.song3);
            posicion--;
            vector[posicion].start();



        }
        else{
            posicion--;
            Toast.makeText(this, " no hay canciones anteriores", Toast.LENGTH_LONG).show();
            posicion=0;
        }

    }


}

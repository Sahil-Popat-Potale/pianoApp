package sahil.popat.pianoApp;


import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import static sahil.popat.pianoApp.MainActivity.mFileName1;
import static sahil.popat.pianoApp.MainActivity.mFileName2;
import static sahil.popat.pianoApp.MainActivity.mFileName3;
import static sahil.popat.pianoApp.MainActivity.mFileName4;
import static sahil.popat.pianoApp.MainActivity.mFileName5;
import static sahil.popat.pianoApp.MainActivity.mFileName6;

public class PlayingActivity extends AppCompatActivity {

    private MediaPlayer mPlayer;
    private Button record1,record2,record3,record4,record5,record6;


    // boolean variables

    private boolean isplaying1;
    private boolean isplaying2;
    private boolean isplaying3;
    private boolean isplaying4;
    private boolean isplaying5;
    private boolean isplaying6;


    private boolean isplaying;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        record1 = (Button) findViewById(R.id.button);
        record2 = (Button) findViewById(R.id.button2);
        record3 = (Button) findViewById(R.id.button3);
        record4 = (Button) findViewById(R.id.button4);
        record5 = (Button) findViewById(R.id.button5);
        record6 = (Button) findViewById(R.id.button6);


        record1.setBackgroundResource(R.drawable.playsongshape);
        record2.setBackgroundResource(R.drawable.playsongshape);
        record3.setBackgroundResource(R.drawable.playsongshape);
        record4.setBackgroundResource(R.drawable.playsongshape);
        record5.setBackgroundResource(R.drawable.playsongshape);
        record6.setBackgroundResource(R.drawable.playsongshape);

        isplaying = false;

        isplaying1 = false;
        isplaying2 = false;
        isplaying3 = false;
        isplaying4 = false;
        isplaying5 = false;
        isplaying6 = false;

    }



    public void play1(View view){

        if (!isplaying1&&!isplaying){
            record1.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(1);
            isplaying = true;
            isplaying1 = true;

        }else if(!isplaying1&&!isplaying){
            stopPlaying();

            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isplaying1 = false;
            isplaying2 = false;
            isplaying3 = false;
            isplaying4 = false;
            isplaying5 = false;
            isplaying6 = false;

            record1.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(1);
            isplaying1 = true;

        }else {

            record1.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying1 = false;
            isplaying = false;

        }

    }

    public void play2(View view){

        if (!isplaying2&&!isplaying){
            record2.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(2);
            isplaying = true;
            isplaying2 = true;

        }else if(!isplaying2&&!isplaying){
            stopPlaying();

            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isplaying1 = false;
            isplaying2 = false;
            isplaying3 = false;
            isplaying4 = false;
            isplaying5 = false;
            isplaying6 = false;

            record2.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(2);
            isplaying2 = true;

        }else {

            record2.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying2 = false;
            isplaying = false;

        }

    }

    public void play3(View view){

        if (!isplaying3&&!isplaying){
            record3.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(3);
            isplaying = true;
            isplaying3 = true;

        }else if(!isplaying3&&!isplaying){
            stopPlaying();

            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isplaying1 = false;
            isplaying2 = false;
            isplaying3 = false;
            isplaying4 = false;
            isplaying5 = false;
            isplaying6 = false;

            record3.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(3);
            isplaying3 = true;

        }else {

            record3.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying3 = false;
            isplaying = false;

        }

    }


    public void play4(View view){

        if (!isplaying4&&!isplaying){
            record4.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(4);
            isplaying = true;
            isplaying4 = true;

        }else if(!isplaying4&&!isplaying){
            stopPlaying();

            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isplaying1 = false;
            isplaying2 = false;
            isplaying3 = false;
            isplaying4 = false;
            isplaying5 = false;
            isplaying6 = false;

            record4.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(4);
            isplaying4 = true;

        }else {

            record4.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying4 = false;
            isplaying = false;

        }

    }

    public void play5(View view){

        if (!isplaying5&&!isplaying){
            record5.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(5);
            isplaying = true;
            isplaying5 = true;

        }else if(!isplaying5&&!isplaying){
            stopPlaying();

            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isplaying1 = false;
            isplaying2 = false;
            isplaying3 = false;
            isplaying4 = false;
            isplaying5 = false;
            isplaying6 = false;

            record5.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(5);
            isplaying5 = true;

        }else {

            record5.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying5 = false;
            isplaying = false;

        }

    }
    public void play6(View view){

        if (!isplaying6&&!isplaying){
            record6.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(6);
            isplaying = true;
            isplaying6 = true;

        }else if(!isplaying6&&!isplaying){
            stopPlaying();

            record1.setBackgroundResource(R.drawable.playsongshape);
            record2.setBackgroundResource(R.drawable.playsongshape);
            record3.setBackgroundResource(R.drawable.playsongshape);
            record4.setBackgroundResource(R.drawable.playsongshape);
            record5.setBackgroundResource(R.drawable.playsongshape);
            record6.setBackgroundResource(R.drawable.playsongshape);

            isplaying1 = false;
            isplaying2 = false;
            isplaying3 = false;
            isplaying4 = false;
            isplaying5 = false;
            isplaying6 = false;

            record6.setBackgroundResource(R.drawable.playsongshapepressed);
            startplaying(6);
            isplaying6 = true;

        }else {

            record6.setBackgroundResource(R.drawable.playsongshape);
            stopPlaying();
            isplaying6 = false;
            isplaying = false;

        }

    }





    private void startplaying(int recordingno) {

        mPlayer = new MediaPlayer();

        try{

            switch (recordingno){

                case 1:
                    mPlayer.setDataSource(mFileName1);
                    break;
                case 2:
                    mPlayer.setDataSource(mFileName2);
                    break;

                case 3:
                    mPlayer.setDataSource(mFileName3);
                    break;

                case 4:
                    mPlayer.setDataSource(mFileName4);
                    break;

                case 5:
                    mPlayer.setDataSource(mFileName5);
                    break;
                case 6:
                    mPlayer.setDataSource(mFileName6);
                    break;
            }

            mPlayer.prepare();
            mPlayer.start();


        }catch (IOException e){

            Log.e("failed","Failes");
        }


    }

    private void stopPlaying(){


        mPlayer.release();
        mPlayer = null;

    }

    @Override
    protected void onPause() {
        super.onPause();

        if(mPlayer!=null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(mPlayer!=null){
            mPlayer.release();
            mPlayer = null;
        }
    }
}

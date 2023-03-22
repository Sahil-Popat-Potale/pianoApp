package sahil.popat.pianoApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    /// The code for the recording of the audio of Piano Keys


    private MediaRecorder mediaRecorder;
    public static String mFileName1 = null;
    public static String mFileName2 = null;
    public static String mFileName3 = null;
    public static String mFileName4 = null;
    public static String mFileName5 = null;
    public static String mFileName6 = null;



    boolean mStartRecording = true;


    public int recordingno;



    private SoundPool soundPool;


    Button left_navigation, right_navigation, recordbutton, playbutton;


    private int c3, c3black, d3, d3black, e3, f3, f3black, g3, g3black, a3, a3black, b3;
    private int c4, c4black, d4, d4black, e4, f4, f4black, g4, g4black, a4, a4black, b4;
    private int c5, c5black, d5, d5black, e5, f5, f5black, g5, g5black, a5, a5black, b5;
    private int c6, c6black, d6, d6black, e6, f6, f6black, g6, g6black, a6, a6black, b6;
    private int c7, c7black, d7, d7black, e7, f7, f7black, g7, g7black, a7, a7black, b7;


    private HorizontalScrollView scrollView;

    private Button buttonC3;
    private Button buttonC3black;

    private Button buttonD3;
    private Button buttonD3black;

    private Button buttonE3;

    private Button buttonF3;
    private Button buttonF3black;

    private Button buttonG3;
    private Button buttonG3black;

    private Button buttonA3;
    private Button buttonA3black;

    private Button buttonB3;

    private Button buttonC4;
    private Button buttonC4black;

    private Button buttonD4;
    private Button buttonD4black;

    private Button buttonE4;

    private Button buttonF4;
    private Button buttonF4black;

    private Button buttonG4;
    private Button buttonG4black;

    private Button buttonA4;
    private Button buttonA4black;

    private Button buttonB4;


    private Button buttonC5;
    private Button buttonC5black;

    private Button buttonD5;
    private Button buttonD5black;

    private Button buttonE5;

    private Button buttonF5;
    private Button buttonF5black;

    private Button buttonG5;
    private Button buttonG5black;

    private Button buttonA5;
    private Button buttonA5black;

    private Button buttonB5;

    private Button buttonC6;
    private Button buttonC6black;

    private Button buttonD6;
    private Button buttonD6black;

    private Button buttonE6;

    private Button buttonF6;
    private Button buttonF6black;

    private Button buttonG6;
    private Button buttonG6black;

    private Button buttonA6;
    private Button buttonA6black;

    private Button buttonB6;

    private Button buttonC7;
    private Button buttonC7black;

    private Button buttonD7;
    private Button buttonD7black;

    private Button buttonE7;

    private Button buttonF7;
    private Button buttonF7black;

    private Button buttonG7;
    private Button buttonG7black;

    private Button buttonA7;
    private Button buttonA7black;

    private Button buttonB7;

    // variables for TextViews

    private TextView tc3;
    private TextView td3;
    private TextView te3;
    private TextView tf3;
    private TextView tg3;
    private TextView ta3;
    private TextView tb3;

    private TextView tc4;
    private TextView td4;
    private TextView te4;
    private TextView tf4;
    private TextView tg4;
    private TextView ta4;
    private TextView tb4;

    private TextView tc5;
    private TextView td5;
    private TextView te5;
    private TextView tf5;
    private TextView tg5;
    private TextView ta5;
    private TextView tb5;

    private TextView tc6;
    private TextView td6;
    private TextView te6;
    private TextView tf6;
    private TextView tg6;
    private TextView ta6;
    private TextView tb6;

    private TextView tc7;
    private TextView td7;
    private TextView te7;
    private TextView tf7;
    private TextView tg7;
    private TextView ta7;
    private TextView tb7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Intilize the scrool view
        scrollView = findViewById(R.id.scrollView);

        // Intilize the navigations button


        // Method for all PianoKey Buttons
        intilizeAllPianoKeys();

        // Method for all PianoKey Lables TextViews
        intilizeTextViewLablesOnPianoKeys();


        // code for the soundpool

        soundPool = new SoundPool.Builder()
                .setMaxStreams(6)
                .build();


        c3 = soundPool.load(this, R.raw.c3, 1);
        c3black = soundPool.load(this, R.raw.c3black, 1);
        d3 = soundPool.load(this, R.raw.d3, 1);
        d3black = soundPool.load(this, R.raw.d3black, 1);
        e3 = soundPool.load(this, R.raw.e3, 1);
        f3 = soundPool.load(this, R.raw.f3, 1);
        f3black = soundPool.load(this, R.raw.f3black, 1);
        g3 = soundPool.load(this, R.raw.g3, 1);
        g3black = soundPool.load(this, R.raw.g3black, 1);
        a3 = soundPool.load(this, R.raw.a3, 1);
        a3black = soundPool.load(this, R.raw.a3black, 1);
        b3 = soundPool.load(this, R.raw.b3, 1);


        c4 = soundPool.load(this, R.raw.c4, 1);
        c4black = soundPool.load(this, R.raw.c4black, 1);
        d4 = soundPool.load(this, R.raw.d4, 1);
        d4black = soundPool.load(this, R.raw.d4black, 1);
        e4 = soundPool.load(this, R.raw.e4, 1);
        f4 = soundPool.load(this, R.raw.f4, 1);
        f4black = soundPool.load(this, R.raw.f4black, 1);
        g4 = soundPool.load(this, R.raw.c4, 1);
        g4black = soundPool.load(this, R.raw.g4black, 1);
        a4 = soundPool.load(this, R.raw.a4, 1);
        a4black = soundPool.load(this, R.raw.a4black, 1);
        b4 = soundPool.load(this, R.raw.b4, 1);

        c5 = soundPool.load(this, R.raw.c5, 1);
        c5black = soundPool.load(this, R.raw.c5black, 1);
        d5 = soundPool.load(this, R.raw.d5, 1);
        d5black = soundPool.load(this, R.raw.d5black, 1);
        e5 = soundPool.load(this, R.raw.e5, 1);
        f5 = soundPool.load(this, R.raw.f5, 1);
        f5black = soundPool.load(this, R.raw.f5black, 1);
        g5 = soundPool.load(this, R.raw.c5, 1);
        g5black = soundPool.load(this, R.raw.g5black, 1);
        a5 = soundPool.load(this, R.raw.a5, 1);
        a5black = soundPool.load(this, R.raw.a5black, 1);
        b5 = soundPool.load(this, R.raw.b5, 1);

        c6 = soundPool.load(this, R.raw.c6, 1);
        c6black = soundPool.load(this, R.raw.c6black, 1);
        d6 = soundPool.load(this, R.raw.d6, 1);
        d6black = soundPool.load(this, R.raw.d6black, 1);
        e6 = soundPool.load(this, R.raw.e6, 1);
        f6 = soundPool.load(this, R.raw.f6, 1);
        f6black = soundPool.load(this, R.raw.f6black, 1);
        g6 = soundPool.load(this, R.raw.g6, 1);
        g6black = soundPool.load(this, R.raw.g6black, 1);
        a6 = soundPool.load(this, R.raw.a6, 1);
        a6black = soundPool.load(this, R.raw.a6black, 1);
        b6 = soundPool.load(this, R.raw.b6, 1);

        c7 = soundPool.load(this, R.raw.c7, 1);
        c7black = soundPool.load(this, R.raw.c7black, 1);
        d7 = soundPool.load(this, R.raw.d7, 1);
        d7black = soundPool.load(this, R.raw.d7black, 1);
        e7 = soundPool.load(this, R.raw.e7, 1);
        f7 = soundPool.load(this, R.raw.f7, 1);
        f3black = soundPool.load(this, R.raw.f3black, 1);
        g7 = soundPool.load(this, R.raw.g7, 1);
        g7black = soundPool.load(this, R.raw.g7black, 1);
        a7 = soundPool.load(this, R.raw.a7, 1);
        a7black = soundPool.load(this, R.raw.a7black, 1);
        b7 = soundPool.load(this, R.raw.b7, 1);


        // The recording code for the piano keys

        mFileName1 = getExternalCacheDir().getAbsolutePath();
        mFileName1 += "/audiorecordtest1.3gp";
        mFileName2 = getExternalCacheDir().getAbsolutePath();
        mFileName2 += "/audiorecordtest2.3gp";
        mFileName3 = getExternalCacheDir().getAbsolutePath();
        mFileName3 += "/audiorecordtest3.3gp";
        mFileName4 = getExternalCacheDir().getAbsolutePath();
        mFileName4 += "/audiorecordtest4.3gp";
        mFileName5 = getExternalCacheDir().getAbsolutePath();
        mFileName5 += "/audiorecordtest5.3gp";
        mFileName6 = getExternalCacheDir().getAbsolutePath();
        mFileName6 += "/audiorecordtest6.3gp";

        SharedPreferences prefs = getSharedPreferences("FILENO", MODE_PRIVATE);
        recordingno = prefs.getInt("fileno", 1);






        // Initialize the Record button,Play Button and navigation button

        left_navigation = findViewById(R.id.bt_left_navigation);
        right_navigation =findViewById(R.id.bt_right_navigation);
        recordbutton =findViewById(R.id.bt_record);
        playbutton =findViewById(R.id.bt_play_recording);


        left_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scrollView.scrollTo((int) scrollView.getScrollX() - 30, (int) scrollView.getScrollX());
            }
        });

        right_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scrollView.scrollTo((int) scrollView.getScrollX() + 30, (int) scrollView.getScrollY());
            }
        });

    }



    void intilizeTextViewLablesOnPianoKeys() {

        tc3 = (TextView) findViewById(R.id.tc3);
        tc3.setOnClickListener(this);
        td3 = (TextView) findViewById(R.id.td3);
        td3.setOnClickListener(this);
        te3 = (TextView) findViewById(R.id.te3);
        te3.setOnClickListener(this);
        tf3 = (TextView) findViewById(R.id.tf3);
        tf3.setOnClickListener(this);
        tg3 = (TextView) findViewById(R.id.tg3);
        tg3.setOnClickListener(this);
        ta3 = (TextView) findViewById(R.id.ta3);
        ta3.setOnClickListener(this);
        tb3 = (TextView) findViewById(R.id.tb3);
        tb3.setOnClickListener(this);

        tc4 = (TextView) findViewById(R.id.tc4);
        tc4.setOnClickListener(this);
        td4 = (TextView) findViewById(R.id.td4);
        td4.setOnClickListener(this);
        te4 = (TextView) findViewById(R.id.te4);
        te4.setOnClickListener(this);
        tf4 = (TextView) findViewById(R.id.tf4);
        tf4.setOnClickListener(this);
        tg4 = (TextView) findViewById(R.id.tg4);
        tg4.setOnClickListener(this);
        ta4 = (TextView) findViewById(R.id.ta4);
        ta4.setOnClickListener(this);
        tb4 = (TextView) findViewById(R.id.tb4);
        tb4.setOnClickListener(this);

        tc5 = (TextView) findViewById(R.id.tc5);
        tc5.setOnClickListener(this);
        td5 = (TextView) findViewById(R.id.td5);
        td5.setOnClickListener(this);
        te5 = (TextView) findViewById(R.id.te5);
        te5.setOnClickListener(this);
        tf5 = (TextView) findViewById(R.id.tf5);
        tf5.setOnClickListener(this);
        tg5 = (TextView) findViewById(R.id.tg5);
        tg5.setOnClickListener(this);
        ta5 = (TextView) findViewById(R.id.ta5);
        ta5.setOnClickListener(this);
        tb5 = (TextView) findViewById(R.id.tb5);
        tb5.setOnClickListener(this);


        tc6 = (TextView) findViewById(R.id.tc6);
        tc6.setOnClickListener(this);
        td6 = (TextView) findViewById(R.id.td6);
        td6.setOnClickListener(this);
        te6 = (TextView) findViewById(R.id.te6);
        te6.setOnClickListener(this);
        tf6 = (TextView) findViewById(R.id.tf6);
        tf6.setOnClickListener(this);
        tg6 = (TextView) findViewById(R.id.tg6);
        tg6.setOnClickListener(this);
        ta6 = (TextView) findViewById(R.id.ta6);
        ta6.setOnClickListener(this);
        tb6 = (TextView) findViewById(R.id.tb6);
        tb6.setOnClickListener(this);


        tc7 = (TextView) findViewById(R.id.tc7);
        tc7.setOnClickListener(this);
        td7 = (TextView) findViewById(R.id.td7);
        td7.setOnClickListener(this);
        te7 = (TextView) findViewById(R.id.te7);
        te7.setOnClickListener(this);
        tf7 = (TextView) findViewById(R.id.tf7);
        tf7.setOnClickListener(this);
        tg7 = (TextView) findViewById(R.id.tg7);
        tg7.setOnClickListener(this);
        ta7 = (TextView) findViewById(R.id.ta7);
        ta7.setOnClickListener(this);
        tb7 = (TextView) findViewById(R.id.tb7);
        tb7.setOnClickListener(this);


    }


    void intilizeAllPianoKeys() {

        buttonC3 = (Button) findViewById(R.id.p1);
        buttonC3.setOnClickListener(this);
        buttonC3black = (Button) findViewById(R.id.b1);
        buttonC3black.setOnClickListener(this);
        buttonD3 = (Button) findViewById(R.id.p2);
        buttonD3.setOnClickListener(this);
        buttonD3black = (Button) findViewById(R.id.b2);
        buttonD3black.setOnClickListener(this);
        buttonE3 = (Button) findViewById(R.id.p3);
        buttonE3.setOnClickListener(this);
        buttonF3 = (Button) findViewById(R.id.p4);
        buttonF3.setOnClickListener(this);
        buttonF3black = (Button) findViewById(R.id.b3);
        buttonF3black.setOnClickListener(this);
        buttonG3 = (Button) findViewById(R.id.p5);
        buttonG3.setOnClickListener(this);
        buttonG3black = (Button) findViewById(R.id.b4);
        buttonG3black.setOnClickListener(this);
        buttonA3 = (Button) findViewById(R.id.p6);
        buttonA3.setOnClickListener(this);
        buttonA3black = (Button) findViewById(R.id.b5);
        buttonA3black.setOnClickListener(this);
        buttonB3 = (Button) findViewById(R.id.p7);
        buttonB3.setOnClickListener(this);


        buttonC4 = (Button) findViewById(R.id.p8);
        buttonC4.setOnClickListener(this);
        buttonC4black = (Button) findViewById(R.id.b6);
        buttonC4black.setOnClickListener(this);
        buttonD4 = (Button) findViewById(R.id.p9);
        buttonD4.setOnClickListener(this);
        buttonD4black = (Button) findViewById(R.id.b7);
        buttonD4black.setOnClickListener(this);
        buttonE4 = (Button) findViewById(R.id.p10);
        buttonE4.setOnClickListener(this);
        buttonF4 = (Button) findViewById(R.id.p11);
        buttonF4.setOnClickListener(this);
        buttonF4black = (Button) findViewById(R.id.b8);
        buttonF4black.setOnClickListener(this);
        buttonG4 = (Button) findViewById(R.id.p12);
        buttonG4.setOnClickListener(this);
        buttonG4black = (Button) findViewById(R.id.b9);
        buttonG4black.setOnClickListener(this);
        buttonA4 = (Button) findViewById(R.id.p13);
        buttonA4.setOnClickListener(this);
        buttonA4black = (Button) findViewById(R.id.b10);
        buttonA4black.setOnClickListener(this);
        buttonB4 = (Button) findViewById(R.id.p14);
        buttonB4.setOnClickListener(this);


        buttonC5 = (Button) findViewById(R.id.p15);
        buttonC5.setOnClickListener(this);
        buttonC5black = (Button) findViewById(R.id.b11);
        buttonC5black.setOnClickListener(this);
        buttonD5 = (Button) findViewById(R.id.p16);
        buttonD5.setOnClickListener(this);
        buttonD5black = (Button) findViewById(R.id.b12);
        buttonD5black.setOnClickListener(this);
        buttonE5 = (Button) findViewById(R.id.p17);
        buttonE5.setOnClickListener(this);
        buttonF5 = (Button) findViewById(R.id.p18);
        buttonF5.setOnClickListener(this);
        buttonF5black = (Button) findViewById(R.id.b13);
        buttonF5black.setOnClickListener(this);
        buttonG5 = (Button) findViewById(R.id.p19);
        buttonG5.setOnClickListener(this);
        buttonG5black = (Button) findViewById(R.id.b14);
        buttonG5black.setOnClickListener(this);
        buttonA5 = (Button) findViewById(R.id.p20);
        buttonA5.setOnClickListener(this);
        buttonA5black = (Button) findViewById(R.id.b15);
        buttonA5black.setOnClickListener(this);
        buttonB5 = (Button) findViewById(R.id.p21);
        buttonB5.setOnClickListener(this);


        buttonC6 = (Button) findViewById(R.id.p22);
        buttonC6.setOnClickListener(this);
        buttonC6black = (Button) findViewById(R.id.b16);
        buttonC6black.setOnClickListener(this);
        buttonD6 = (Button) findViewById(R.id.p23);
        buttonD6.setOnClickListener(this);
        buttonD6black = (Button) findViewById(R.id.b17);
        buttonD6black.setOnClickListener(this);
        buttonE6 = (Button) findViewById(R.id.p24);
        buttonE6.setOnClickListener(this);
        buttonF6 = (Button) findViewById(R.id.p25);
        buttonF6.setOnClickListener(this);
        buttonF6black = (Button) findViewById(R.id.b18);
        buttonF6black.setOnClickListener(this);
        buttonG6 = (Button) findViewById(R.id.p26);
        buttonG6.setOnClickListener(this);
        buttonG6black = (Button) findViewById(R.id.b19);
        buttonG6black.setOnClickListener(this);
        buttonA6 = (Button) findViewById(R.id.p27);
        buttonA6.setOnClickListener(this);
        buttonA6black = (Button) findViewById(R.id.b20);
        buttonA6black.setOnClickListener(this);
        buttonB6 = (Button) findViewById(R.id.p28);
        buttonB6.setOnClickListener(this);


        buttonC7 = (Button) findViewById(R.id.p29);
        buttonC7.setOnClickListener(this);
        buttonC7black = (Button) findViewById(R.id.b21);
        buttonC7black.setOnClickListener(this);
        buttonD7 = (Button) findViewById(R.id.p30);
        buttonD7.setOnClickListener(this);
        buttonD7black = (Button) findViewById(R.id.b22);
        buttonD7black.setOnClickListener(this);
        buttonE7 = (Button) findViewById(R.id.p31);
        buttonE7.setOnClickListener(this);
        buttonF7 = (Button) findViewById(R.id.p32);
        buttonF7.setOnClickListener(this);
        buttonF7black = (Button) findViewById(R.id.b23);
        buttonF7black.setOnClickListener(this);
        buttonG7 = (Button) findViewById(R.id.p33);
        buttonG7.setOnClickListener(this);
        buttonG7black = (Button) findViewById(R.id.b24);
        buttonG7black.setOnClickListener(this);
        buttonA7 = (Button) findViewById(R.id.p34);
        buttonA7.setOnClickListener(this);
        buttonA7black = (Button) findViewById(R.id.b25);
        buttonA7black.setOnClickListener(this);
        buttonB7 = (Button) findViewById(R.id.p35);
        buttonB7.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.tc3:
            case R.id.p1:
                soundPool.play(c3,1,1,0,0,1);
                break;

            case R.id.b1:
                soundPool.play(c3black,1,1,0,0,1);
                break;

            case R.id.td3:
            case R.id.p2:
                soundPool.play(d3,1,1,0,0,1);
                break;

            case R.id.b2:
                soundPool.play(d3black,1,1,0,0,1);
                break;


            case R.id.te3:
            case R.id.p3:
                soundPool.play(e3,1,1,0,0,1);
                break;


            case R.id.tf3:
            case R.id.p4:
                soundPool.play(f3,1,1,0,0,1);
                break;


            case R.id.b3:
                soundPool.play(f3black,1,1,0,0,1);
                break;


            case R.id.tg3:
            case R.id.p5:
                soundPool.play(g3,1,1,0,0,1);
                break;

            case R.id.b4:
                soundPool.play(g3black,1,1,0,0,1);
                break;


            case R.id.ta3:
            case R.id.p6:
                soundPool.play(a3,1,1,0,0,1);
                break;

            case R.id.b5:
                soundPool.play(a3black,1,1,0,0,1);
                break;

            case R.id.tb3:
            case R.id.p7:
                soundPool.play(b3,1,1,0,0,1);
                break;



            case R.id.tc4:
            case R.id.p8:
                soundPool.play(c4,1,1,0,0,1);
                break;

            case R.id.b6:
                soundPool.play(c4black,1,1,0,0,1);
                break;

            case R.id.td4:
            case R.id.p9:
                soundPool.play(d4,1,1,0,0,1);
                break;

            case R.id.b7:
                soundPool.play(d4black,1,1,0,0,1);
                break;


            case R.id.te4:
            case R.id.p10:
                soundPool.play(e4,1,1,0,0,1);
                break;


            case R.id.tf4:
            case R.id.p11:
                soundPool.play(f4,1,1,0,0,1);
                break;


            case R.id.b8:
                soundPool.play(f4black,1,1,0,0,1);
                break;


            case R.id.tg4:
            case R.id.p12:
                soundPool.play(g4,1,1,0,0,1);
                break;

            case R.id.b9:
                soundPool.play(g4black,1,1,0,0,1);
                break;


            case R.id.ta4:
            case R.id.p13:
                soundPool.play(a4,1,1,0,0,1);
                break;

            case R.id.b10:
                soundPool.play(a4black,1,1,0,0,1);
                break;

            case R.id.tb4:
            case R.id.p14:
                soundPool.play(b4,1,1,0,0,1);
                break;





            case R.id.tc5:
            case R.id.p15:
                soundPool.play(c5,1,1,0,0,1);
                break;

            case R.id.b11:
                soundPool.play(c5black,1,1,0,0,1);
                break;

            case R.id.td5:
            case R.id.p16:
                soundPool.play(d5,1,1,0,0,1);
                break;

            case R.id.b12:
                soundPool.play(d5black,1,1,0,0,1);
                break;


            case R.id.te5:
            case R.id.p17:
                soundPool.play(e5,1,1,0,0,1);
                break;


            case R.id.tf5:
            case R.id.p18:
                soundPool.play(f5,1,1,0,0,1);
                break;


            case R.id.b13:
                soundPool.play(f5black,1,1,0,0,1);
                break;


            case R.id.tg5:
            case R.id.p19:
                soundPool.play(g5,1,1,0,0,1);
                break;

            case R.id.b14:
                soundPool.play(g5black,1,1,0,0,1);
                break;


            case R.id.ta5:
            case R.id.p20:
                soundPool.play(a5,1,1,0,0,1);
                break;

            case R.id.b15:
                soundPool.play(a5black,1,1,0,0,1);
                break;

            case R.id.tb5:
            case R.id.p21:
                soundPool.play(b5,1,1,0,0,1);
                break;




            case R.id.tc6:
            case R.id.p22:
                soundPool.play(c6,1,1,0,0,1);
                break;

            case R.id.b16:
                soundPool.play(c6black,1,1,0,0,1);
                break;

            case R.id.td6:
            case R.id.p23:
                soundPool.play(d6,1,1,0,0,1);
                break;

            case R.id.b17:
                soundPool.play(d6black,1,1,0,0,1);
                break;


            case R.id.te6:
            case R.id.p24:
                soundPool.play(e6,1,1,0,0,1);
                break;


            case R.id.tf6:
            case R.id.p25:
                soundPool.play(f6,1,1,0,0,1);
                break;


            case R.id.b18:
                soundPool.play(f6black,1,1,0,0,1);
                break;


            case R.id.tg6:
            case R.id.p26:
                soundPool.play(g6,1,1,0,0,1);
                break;

            case R.id.b19:
                soundPool.play(g6black,1,1,0,0,1);
                break;


            case R.id.ta6:
            case R.id.p27:
                soundPool.play(a6,1,1,0,0,1);
                break;

            case R.id.b20:
                soundPool.play(a6black,1,1,0,0,1);
                break;

            case R.id.tb6:
            case R.id.p28:
                soundPool.play(b6,1,1,0,0,1);
                break;



            case R.id.tc7:
            case R.id.p29:
                soundPool.play(c7,1,1,0,0,1);
                break;

            case R.id.b21:
                soundPool.play(c7black,1,1,0,0,1);
                break;

            case R.id.td7:
            case R.id.p30:
                soundPool.play(d7,1,1,0,0,1);
                break;

            case R.id.b22:
                soundPool.play(d7black,1,1,0,0,1);
                break;


            case R.id.te7:
            case R.id.p31:
                soundPool.play(e7,1,1,0,0,1);
                break;


            case R.id.tf7:
            case R.id.p32:
                soundPool.play(f7,1,1,0,0,1);
                break;


            case R.id.b23:
                soundPool.play(f7black,1,1,0,0,1);
                break;


            case R.id.tg7:
            case R.id.p33:
                soundPool.play(g7,1,1,0,0,1);
                break;

            case R.id.b24:
                soundPool.play(g7black,1,1,0,0,1);
                break;


            case R.id.ta7:
            case R.id.p34:
                soundPool.play(a7,1,1,0,0,1);
                break;

            case R.id.b25:
                soundPool.play(a7black,1,1,0,0,1);
                break;

            case R.id.tb7:
            case R.id.p35:
                soundPool.play(b7,1,1,0,0,1);
                break;

        }
    }



    public void play(View view) {

        Intent intent = new Intent(MainActivity.this,PlayingActivity.class);
        startActivity(intent);

    }


    public void record(View view) {
        onRecord(mStartRecording);
        if (mStartRecording) {
            recordbutton.setText("Finish");
        }else {
            recordbutton.setText("Record");
        }
        mStartRecording = !mStartRecording;
    }

    /*
     *   The startRecording() method code :::
     *
     * */

    private void startRecording() {

        mediaRecorder = new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        switch (recordingno) {


            case 1:
                mediaRecorder.setOutputFile(mFileName1);
                recordingno++;
                if (recordingno == 7)
                    recordingno = 1;
                break;
            case 2:
                mediaRecorder.setOutputFile(mFileName2);
                recordingno++;
                if (recordingno == 7)
                    recordingno = 1;
                break;
            case 3:
                mediaRecorder.setOutputFile(mFileName3);
                recordingno++;
                if (recordingno == 7)
                    recordingno = 1;
                break;
            case 4:
                mediaRecorder.setOutputFile(mFileName4);
                recordingno++;
                if (recordingno == 7)
                    recordingno = 1;
                break;
            case 5:
                mediaRecorder.setOutputFile(mFileName5);
                recordingno++;
                if (recordingno == 7)
                    recordingno = 1;
                break;
            case 6:
                mediaRecorder.setOutputFile(mFileName6);
                recordingno++;
                if (recordingno == 7)
                    recordingno = 1;
                break;
        }

        SharedPreferences.Editor editor = getSharedPreferences("FILENO", MODE_PRIVATE).edit();
        editor.putInt("fileno", recordingno);
        editor.commit();
        // mediaRecorder.setOutputFile(mFileName);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            Log.e("prepare fail", "prepare() failed");
        }
        Log.d("recorder has started", "recorder has started");
        mediaRecorder.start();
    }


    private void stopRecording() {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
    }



    private void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
            if (recordingno == 1) {
                Toast recordingmsg = Toast.makeText(getApplicationContext(),
                        "Song " + 6 + " saved", Toast.LENGTH_SHORT);

                recordingmsg.show();
            } else {
                int temprecordingno = recordingno - 1;
                Toast recordingmsg = Toast.makeText(getApplicationContext(),
                        "Song " + temprecordingno + " Saved", Toast.LENGTH_LONG);
                recordingmsg.show();
            }
        }
    }

}

package hkcc.assignment1;



import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class summary extends MainActivity {

    TextToSpeech texttospeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        final TextView summaryview = (TextView)findViewById(R.id.summaryview);




        scoretext= new StringBuilder();
        scoretext.append("              Summary\n");
        scoretext.append("\n");
        scoretext.append("Number of question is");
        scoretext.append("10");
        scoretext.append("\n");
        scoretext.append("\n");
        scoretext.append("\n");
        scoretext.append(st1);
        final String txt1 = getIntent().getStringExtra("key3");
        scoretext.append(getIntent().getStringExtra("key3"));
        scoretext.append("\n");
        scoretext.append("\n");
        scoretext.append("\n");
        scoretext.append(st2);
        final String txt2 =getIntent().getStringExtra("key1");
        scoretext.append(getIntent().getStringExtra("key1"));
        scoretext.append("\n");
        scoretext.append("\n");
        scoretext.append("\n");
        scoretext.append(st3);
        scoretext.append(getIntent().getStringExtra("key2"));
        final String txt3 =getIntent().getStringExtra("key2");
        scoretext.append("\n");
        scoretext.append("\n");
        scoretext.append("\n");


        texttospeech= new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                {
                    texttospeech.setLanguage(Locale.ENGLISH);
                    texttospeech.setSpeechRate(1);
                  //  texttospeech.speak("Summary                Number of question is 10           "+st1+ txt1 +st2 + txt2 +st3 + txt3, TextToSpeech.QUEUE_ADD,null);

                    texttospeech.speak("Summary              ", TextToSpeech.QUEUE_ADD,null);
                    texttospeech.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null);
                    texttospeech.speak(" Number of question is ,10       ", TextToSpeech.QUEUE_ADD,null);
                    texttospeech.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null);
                    texttospeech.speak(st1, TextToSpeech.QUEUE_ADD,null);

                    texttospeech.speak(txt1, TextToSpeech.QUEUE_ADD,null);
                    texttospeech.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null);
                    texttospeech.speak(st2 , TextToSpeech.QUEUE_ADD,null);

                    texttospeech.speak( txt2 , TextToSpeech.QUEUE_ADD,null);
                    texttospeech.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null);
                    texttospeech.speak(st3 , TextToSpeech.QUEUE_ADD,null);

                    texttospeech.speak(txt3, TextToSpeech.QUEUE_ADD,null);


                }
            }
        });
        summaryview.setText(scoretext);
        //TTS.speak("Summary                Number of question is 10           "+st1+ txt1 +st2 + txt2 +st3 + txt3, TextToSpeech.QUEUE_FLUSH,null);



    }


}

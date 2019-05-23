package hkcc.assignment1;



import android.content.Intent;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random myRandom;

    int x,y,z;
    int ans;
    int correctnum;
    int wrongnum;
    int blanknum;
    int randomtime = 1;
    long currenttime;
    CountDownTimer realtimer;
    private long timeleft = 300000;
    int current ;



    StringBuilder g = new StringBuilder();
    StringBuilder scoretext= new StringBuilder();
    String sign = new String();
    String st1= new String();
    String st2= new String();
    String st3 = new String();
    String myscore= new String();
    TextView countdowntimer;
    TextToSpeech TTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     countdowntimer= (TextView)findViewById(R.id.countdowntimer);
        final TextView question = (TextView) findViewById(R.id.question);
        final EditText ansfield = (EditText) findViewById(R.id.ansfield);
        final TextView score = (TextView)findViewById(R.id.score);
        Button btnclear = (Button) findViewById(R.id.btnclear);


        realtimer= new CountDownTimer(timeleft ,1000)
        {       @Override

            public void onTick(long l )
            {
                currenttime= l;
                    timeleft=l;

               update();
          
               }


            public void onFinish()
            {
                    if(currenttime<1000) {
                        Toast.makeText(MainActivity.this, "Time is up!!! ", Toast.LENGTH_SHORT).show();
                        summary();
                    }











            }

        }.start();








        Button btnsubmit = (Button) findViewById(R.id.btnsubmit);

        TTS= new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR)
                {
                    TTS.setLanguage(Locale.ENGLISH);
                    TTS.setSpeechRate(1);
                }
            }
        });
        //Button btnregen = (Button)findViewById(R.id.btnregen);
       /* btnregen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                random();
            }
        } );*/
        st1="Question you have given up =  ";
        st2="Correct answer = ";
        st3="Incorrect answer = ";
        btnsubmit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {
                if(ansfield.getText().toString().equals(""))
                {


                    blanknum++;
                    randomtime++;
                    if(randomtime== 11)
                    {
                        summary();
                    }
                    scoretext= new StringBuilder();
                    scoretext.append("Number of question is");
                    if(randomtime==11)
                        randomtime=10;
                    scoretext.append(randomtime);
                    scoretext.append("\n");
                    scoretext.append(st1);
                    scoretext.append(blanknum);
                    scoretext.append("\n");
                    scoretext.append(st2);
                    scoretext.append(correctnum);
                    scoretext.append("\n");
                    scoretext.append(st3);
                    scoretext.append(wrongnum);
                    scoretext.append("\n");

                    scoretext.append("The correct answer of last question is");
                    scoretext.append(ans);
                    scoretext.append("\n");


                    score.setText(scoretext);

                    random();

                }
                else{


                    if (!(TextUtils.isDigitsOnly(ansfield.getText()))) {
                        Toast.makeText(v.getContext(), "Please only input numerical data which is a positive integer ", Toast.LENGTH_LONG).show();
                        ansfield.setText("");
                        return;
                    }
                    if (ansfield.getText().toString().equals(Integer.toString(ans))) {
                        Toast.makeText(v.getContext(), "Your answer is correct", Toast.LENGTH_LONG).show();
                        TTS.speak("Your answer is correct", TextToSpeech.QUEUE_FLUSH,null);
                        correctnum++;
                        randomtime++;
                        if (randomtime == 11) {
                            summary();
                        }

                        scoretext = new StringBuilder();
                        scoretext.append("Number of question is");
                        if(randomtime==11)
                            randomtime=10;
                        scoretext.append(randomtime);
                        scoretext.append("\n");
                        scoretext.append(st1);
                        scoretext.append(blanknum);
                        scoretext.append("\n");
                        scoretext.append(st2);
                        scoretext.append(correctnum);
                        scoretext.append("\n");
                        scoretext.append(st3);
                        scoretext.append(wrongnum);
                        scoretext.append("\n");
                        scoretext.append("The correct answer of last question is");
                        scoretext.append(ans);
                        scoretext.append("\n");
                        score.setText(scoretext);
                        random();
                        ansfield.setText("");
                    } else {
                        wrongnum++;
                        randomtime++;
                        if (randomtime == 11) {
                            summary();
                        }

                        Toast.makeText(v.getContext(), "Your answer is incorrect", Toast.LENGTH_LONG).show();

                        String realanswer= String.valueOf(ans);

                        TTS.speak("Your answer is incorrect ", TextToSpeech.QUEUE_ADD,null);

                        TTS.playSilentUtterance(500, TextToSpeech.QUEUE_ADD, null);
                        TTS.speak("the correct answer is", TextToSpeech.QUEUE_ADD,null);

                        TTS.speak(realanswer, TextToSpeech.QUEUE_ADD,null);
                        scoretext = new StringBuilder();
                        scoretext.append("Number of question is");
                        if(randomtime==11)
                            randomtime=10;
                        scoretext.append(randomtime);
                        scoretext.append("\n");
                        scoretext.append(st1);
                        scoretext.append(blanknum);
                        scoretext.append("\n");
                        scoretext.append(st2);
                        scoretext.append(correctnum);
                        scoretext.append("\n");
                        scoretext.append(st3);
                        scoretext.append(wrongnum);
                        scoretext.append("\n");
                        scoretext.append("The correct answer of last question is");
                        scoretext.append(ans);
                        scoretext.append("\n");
                        score.setText(scoretext);
                        random();
                        ansfield.setText("");
                    }
                }
            }


        } );
        btnclear.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v)
            {


                if(ansfield.getText().toString().equals(""))
                {


                    blanknum++;
                    randomtime++;
                    if(randomtime== 11)
                    {
                        summary();
                    }
                    scoretext= new StringBuilder();
                    scoretext.append("Number of question is");
                    if(randomtime==11)
                        randomtime=10;
                    scoretext.append(randomtime);
                    scoretext.append("\n");
                    scoretext.append(st1);
                    scoretext.append(blanknum);
                    scoretext.append("\n");
                    scoretext.append(st2);
                    scoretext.append(correctnum);
                    scoretext.append("\n");
                    scoretext.append(st3);
                    scoretext.append(wrongnum);
                    scoretext.append("\n");

                    scoretext.append("The correct answer of last question is");
                    scoretext.append(ans);
                    scoretext.append("\n");


                    score.setText(scoretext);

                    random();

                }
            }


        } );






        random();

    }

    public void update()
    {

        int minutes=(int) timeleft/60000;
        int seconds = (int)timeleft % 60000/1000;

        String timeLeftText;
        timeLeftText = ""+ minutes;
        timeLeftText+=":";
        if(seconds < 10) timeLeftText +="0";
        timeLeftText+=seconds;
        countdowntimer.setText(timeLeftText);

    }


    public void randomcoming()
    {
        myRandom = new Random();
        y=myRandom.nextInt(4)+1;

        x=myRandom.nextInt(100)+1;

        z=myRandom.nextInt(100)+1;
        if(y==3) {
            x = myRandom.nextInt(20) + 1;
            z = myRandom.nextInt(20) + 1;
        }

        if(y== 1) {
            sign = "+";
            ans = x+z;
        }
        if(y== 2) {
            sign = "-";
            ans = x   -   z;
        }
        if(y== 3) {
            sign = "*";
            ans = x*z;
        }
        if(y== 4) {
            sign = "/";
            ans = x/z;
        }


    }

    public void summary()
    {

        Intent intent = new Intent(getBaseContext(), summary.class);
        intent.putExtra("key1", String.valueOf(correctnum));
        intent.putExtra("key2", String.valueOf(wrongnum));
        intent.putExtra("key3", String.valueOf(blanknum));

        startActivity(intent);
    }

    public void random()
    {

        x=0;
        y=0;
        z=0;
        sign="";
        ans=0;
        g=new StringBuilder();
        boolean restart =false;
        randomcoming();

        TextView question = (TextView) findViewById(R.id.question);
        EditText ansfield = (EditText) findViewById(R.id.ansfield);



        if(y==2) {
            do {
                if (z > x) {
                    x=myRandom.nextInt(100)+1;

                    z=myRandom.nextInt(100)+1;
                    ans = x   -   z;
                }


            } while (z > x);
        }
        if(y==4)
        {
            do
            {
                if(z>x || x%z > 0)
                {
                    x=myRandom.nextInt(100)+1;

                    z=myRandom.nextInt(100)+1;
                    ans = x/z;

                }


            } while(z>x|| x%z > 0);
        }


        g=new StringBuilder();


        if(y==2)

        {
            g.append(x);
            g.append("    ");
            g.append(sign);
            g.append("  ");
            g.append(z);
            g.append("    =?");
        }



        else{
            g.append(x);
            g.append("    ");
            g.append(sign);
            g.append("  ");
            g.append(z);
            g.append("    =  ?");
        }

        question.setText(g);


    }

}

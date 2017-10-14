
package com.pixelatorstudios.scarnesdice2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView myText1;
    TextView myText2;
    TextView myText3;
    TextView myText4;
    TextView myText5;
    Button Roll;
    Button Hold;
    Button Reset;
    ImageView diceimg;

    int[] ImageArray={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
    int k;
    int PlayerScore=0;
    int PlayerTempScore=0;
    int CompScore=0;
    int CompTempScore=0;

    //final int score = random.nextInt(6)+1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myText1 = (TextView)findViewById(R.id.textView);
		myText2 = (TextView)findViewById(R.id.textView3);
		myText3 = (TextView)findViewById(R.id.textView6);
		myText4 = (TextView)findViewById(R.id.textView7);
		myText5 = (TextView)findViewById(R.id.textView9);
        
        Roll = (Button)findViewById(R.id.button);
        Hold = (Button)findViewById(R.id.button2);
        Reset = (Button)findViewById(R.id.button3);
        diceimg = (ImageView)findViewById(R.id.imageView2);
        Roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    final int score = random.nextInt(6)+1;
                    diceimg.setImageDrawable(getResources().getDrawable(ImageArray[score-1]));
                    if (score >= 2 && score <= 6) {
                        PlayerTempScore = PlayerTempScore+score;
                        diceimg.setImageDrawable(getResources().getDrawable(ImageArray[score-1]));
                        myText3.setText("Player Turn Score : " + PlayerTempScore);

                    }
                    else
                    {
                        diceimg.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                        PlayerTempScore=0;
                        myText3.setText("Player Turn Score : " + PlayerTempScore);
                        k=ComputerTurn();
                        if(k==1) {
                            myText5.setText("Computer Wins");
                            Roll.setEnabled(false);
                            Hold.setEnabled(false);
                        }
                    }
                    if(PlayerScore>=100){
                        myText5.setText("You Win");
                        Roll.setEnabled(false);
                        Hold.setEnabled(false);
                        //Re.setEnabled(false);
                    }


            }
        });
        Hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayerScore = PlayerScore + PlayerTempScore;
                myText1.setText("Your Score : " + PlayerScore);
                PlayerTempScore=0;
                myText3.setText("Player Turn Score : " + PlayerTempScore);
                k=ComputerTurn();
                if(k==1) {
                    myText5.setText("Computer Wins");
                    Roll.setEnabled(false);
                    Hold.setEnabled(false);
                }
                //Insert Computer Turn

            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayerScore=0;
                CompScore=0;
                myText3.setText("Player Turn Score : 0");
                myText1.setText("Your Score : 0");
                myText2.setText("Computer Score : 0");
                myText4.setText("Computer Turn Score : 0");
                diceimg.setImageDrawable(getResources().getDrawable(R.drawable.dice1));
                Roll.setEnabled(true);
                Hold.setEnabled(true);
                myText5.setText("");
            }
        });
    }
    public int ComputerTurn(){

        do {
            if (cscore >= 2 && cscore <= 6) {
                CompTempScore = cscore;
                diceimg.setImageDrawable(getResources().getDrawable(ImageArray[cscore - 1]));
                myText4.setText("Computer Turn Score : " + CompTempScore);
                CompScore = CompScore + CompTempScore;
                myText2.setText("Computer Score : " + CompScore);
            } 
            if(CompScore>=100){
                return 1;
            }
        }while(CompScore<20);
        return 0;
    }
}

package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    String scoreMessage;

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private Button checkedButton1;
    private Button checkedButton2;
    private Button checkedButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton1();

        addListenerOnButton2();

        addListenerOnButton3();


    }

    public void addListenerOnButton1(){
        radioGroup1 = (RadioGroup) findViewById(R.id.radiogroup_q1);
        checkedButton1 = (Button) findViewById(R.id.radiobutton2_q1);

        checkedButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedAnswerQ1 = radioGroup1.getCheckedRadioButtonId();

                radioButton1 = findViewById(selectedAnswerQ1);

                if (radioButton1.getText().equals("32")){
                    score += 1;
                }
                //Toast.makeText(MainActivity.this,
                //        radioButton1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addListenerOnButton2(){
        radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup_q2);
        checkedButton2 = (Button) findViewById(R.id.radiobutton1_q2);

        checkedButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedAnswerQ2 = radioGroup2.getCheckedRadioButtonId();

                radioButton2 = findViewById(selectedAnswerQ2);

                if (radioButton2.getText().equals("16")){
                    score += 1;
                }
                //Toast.makeText(MainActivity.this,
                //        radioButton1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void addListenerOnButton3(){
        radioGroup3 = (RadioGroup) findViewById(R.id.radiogroup_q3);
        checkedButton3 = (Button) findViewById(R.id.radiobutton2_q3);

        checkedButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedAnswerQ3 = radioGroup3.getCheckedRadioButtonId();

                radioButton1 = findViewById(selectedAnswerQ3);

                if (radioButton1.getText().equals("June")){
                    score += 1;
                }
                //Toast.makeText(MainActivity.this,
                //        radioButton1.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }




    /**
     * Used to display score of user
     * @param message number of correct scores of user
     */
    public void displayScore(String message) {
        TextView scoreView = (TextView) findViewById(R.id.totalscore_textview) ;
        scoreView.setText(String.valueOf(message));
    }

    /**
     * Displays the total score
     * @param view shows the total score of user
     */
    public void totalScore(View view) {
        // Collects user input for Name
        EditText userName = (EditText) findViewById(R.id.username);
        String name = userName.getText().toString();

        EditText answerToQ4 = (EditText) findViewById(R.id.edittext_q4);
        String answerQ4 = answerToQ4.getText().toString();

        if (answerQ4.equals("Germany")) {
            score += 1;
        }

        if (score == 4){
            // Outputs the name of user and score
            scoreMessage = "Congratulations " + name;
            scoreMessage += "! You got all correct and your total Score is \n" ;
            scoreMessage +=  score;
            displayScore(scoreMessage);
        } else if (score == 3){
            // Outputs the name of user and score
            scoreMessage = "Well done " + name;
            scoreMessage += "! You almost had all, your score \n" + score;
        } else if (score <= 2){
            // Outputs the name of user and score
            scoreMessage = "You did well " + name;
            scoreMessage += "! You can do better, your score \n" + score;
        } else {
            // Outputs the name of user and score
            scoreMessage = "Too bad " + name;
            scoreMessage += "! Your score isn't impressive , your score \n" + score;
        }

        displayScore(scoreMessage);
    }

    public void resetScore(View view) {
        score = 0;
        scoreMessage = "";

        RadioGroup resetQ1 = findViewById(R.id.radiogroup_q1);
        resetQ1.clearCheck();

        RadioGroup resetQ2 = findViewById(R.id.radiogroup_q2);
        resetQ2.clearCheck();

        RadioGroup resetQ3 = findViewById(R.id.radiogroup_q3);
        resetQ3.clearCheck();

        displayScore(scoreMessage);
    }
}

package com.test.myquiz.myquiz;

import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.view.View;
import android.content.Intent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.Objects;
import java.util.Random;

public class EndQuiz extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //Extract the answers array
        Bundle extras = getIntent().getExtras();
        ArrayList<Boolean> answers = new ArrayList<Boolean>();
        answers = (ArrayList<Boolean>) extras.get("Answers");

        TextView FinalResults = (TextView) findViewById(R.id.textView_results);
        //counter for correct answers count
        int Corrects = 0;

        FinalResults.setText("Your results : \n\n");
        for ( int i = 0; i < answers.size(); i++  )
        {

            if (answers.get(i)) {

                Corrects++;
                FinalResults.append("Question " + String.valueOf(i+1) + "\t\t : \t\t Correct !\n");
            }
            else
            {
                FinalResults.append("Question " + String.valueOf(i+1) + "\t\t : \t\t Wrong !\n");
            }
        }


        TextView FinalScore = (TextView) findViewById(R.id.textView_score);

        FinalScore.setText("Final SCORE : " + String.valueOf(Corrects) + " / 10 ");


    }
}
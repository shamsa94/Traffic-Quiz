package com.test.myquiz.myquiz;

import android.content.Intent;
import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;

import java.util.Random;

public class TrafficQuiz extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_quiz);

        final Button goQuiz = (Button) findViewById(R.id.GoButton);
        goQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                //Add 10 false answers to the answers array, every question has one answer in this array ( True or False )
                ArrayList<Boolean> Answers = new ArrayList<Boolean>();
                Boolean Wrong = false;
                Answers.add(Wrong);
                Answers.add(Wrong);
                Answers.add(Wrong);
                Answers.add(Wrong);
                Answers.add(Wrong);
                Answers.add(Wrong);
                Answers.add(Wrong);
                Answers.add(Wrong);
                Answers.add(Wrong);
                Answers.add(Wrong);

                //Add the 10 questions Classes to the Questions bank array ...
                ArrayList<Class> activityList = new ArrayList<>();
                activityList.add(StartQuiz.class);
                activityList.add(Question02.class);
                activityList.add(Question03.class);
                activityList.add(Question04.class);
                activityList.add(Question05.class);
                activityList.add(Question06.class);
                activityList.add(Question07.class);
                activityList.add(Question08.class);
                activityList.add(Question09.class);
                activityList.add(Question10.class);

                //Create a random number to pick the next Question
                Random generator = new Random();
                int number = generator.nextInt(10) + 1;

                //Class to save the next question object
                Class activity = null;

                // Here, we are checking to see what the output of the random was
                // We remove the next question from the questions bank array
                switch(number) {
                    case 1:
                        activity = StartQuiz.class;
                        // We are adding the number of the activity to the list
                        activityList.remove(StartQuiz.class);
                        break;
                    case 2:
                        activity = Question02.class;
                        activityList.remove(Question02.class);
                        break;
                    case 3:
                        activity = Question03.class;
                        activityList.remove(Question03.class);
                        break;
                    case 4:
                        activity = Question04.class;
                        activityList.remove(Question04.class);
                        break;
                    case 5:
                        activity = Question05.class;
                        activityList.remove(Question05.class);
                        break;
                    case 6:
                        activity = Question06.class;
                        activityList.remove(Question06.class);
                        break;
                    case 7:
                        activity = Question07.class;
                        activityList.remove(Question07.class);
                        break;
                    case 8:
                        activity = Question08.class;
                        activityList.remove(Question08.class);
                        break;
                    case 9:
                        activity = Question09.class;
                        activityList.remove(Question09.class);
                        break;
                    default:
                        activity = Question10.class;
                        activityList.remove(Question10.class);
                        break;
                }

                // We use intents to start activities
                Intent intent = new Intent(getBaseContext(), activity);
                // intent.putExtra(...)` is used to pass on extra information to the next activity
                // we pass the remaining questions and answers to the next activity
                intent.putExtra("ACTIVITY_LIST", activityList);
                intent.putExtra("Answers", Answers);

                startActivity(intent);

                }

        });
    }
}
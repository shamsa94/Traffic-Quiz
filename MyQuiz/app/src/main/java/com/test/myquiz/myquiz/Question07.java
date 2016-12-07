package com.test.myquiz.myquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Question07 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question07);


        Button myButton = (Button) findViewById(R.id.next02);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton correctAnswer = (RadioButton) findViewById(R.id.correctAns);
                RadioGroup MyRadioGroup = (RadioGroup) findViewById(R.id.RG);

                if(MyRadioGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Please select an answer !", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }


                ArrayList<Class> activityList = new ArrayList<>();
                Bundle extras = getIntent().getExtras();
                activityList = (ArrayList<Class>) extras.get("ACTIVITY_LIST");

                //Set the question status
                ArrayList<Boolean> answers = new ArrayList<Boolean>();
                answers = (ArrayList<Boolean>) extras.get("Answers");
                if (correctAnswer.isChecked())
                {
                    answers.set( answers.size() - activityList.size() - 1 ,  true);

                }


                if (activityList.size() == 0) {
                    // Do something when after all activities have been opened
                    //doSomeAction();
                    //Open a new activity with PASS or FAILED
                    ArrayList<Boolean> Answers = new ArrayList<Boolean>();
                    Answers = (ArrayList<Boolean>) extras.get("Answers");

                    Class activity = EndQuiz.class;
                    Intent intent = new Intent(getBaseContext(), activity);
                    intent.putExtra("Answers", Answers);
                    startActivity(intent);
                } else {



                    // Now, the random number is generated between 1 and however many
                    // activities we have remaining
                    Random generator = new Random();
                    int number = generator.nextInt(activityList.size()) + 1;

                    Class activity = null;

                    // Here, we are checking to see what the output of the random was
                    switch (number) {
                        case 1:
                            // We will open the first remaining activity of the list
                            activity = activityList.get(0);
                            // We will now remove that activity from the list
                            activityList.remove(0);
                            break;
                        case 2:
                            // We will open the second remaining activity of the list
                            activity = activityList.get(1);
                            activityList.remove(1);
                            break;
                        case 3:
                            // We will open the third remaining activity of the list
                            activity = activityList.get(2);
                            activityList.remove(2);
                            break;
                        case 4:
                            // We will open the fourth remaining activity of the list
                            activity = activityList.get(3);
                            activityList.remove(3);
                            break;
                        case 5:
                            // We will open the fourth remaining activity of the list
                            activity = activityList.get(4);
                            activityList.remove(4);
                            break;
                        case 6:
                            // We will open the fourth remaining activity of the list
                            activity = activityList.get(5);
                            activityList.remove(5);
                            break;
                        case 7:
                            // We will open the fourth remaining activity of the list
                            activity = activityList.get(6);
                            activityList.remove(6);
                            break;
                        case 8:
                            // We will open the fourth remaining activity of the list
                            activity = activityList.get(7);
                            activityList.remove(7);
                            break;
                        case 9:
                            // We will open the fourth remaining activity of the list
                            activity = activityList.get(8);
                            activityList.remove(8);
                            break;
                        default:
                            // We will open the fifth remaining activity of the list
                            activity = activityList.get(9);
                            activityList.remove(9);
                            break;
                    }




                    // Starting the activity, and passing on the remaining number of activities
                    // to the next one that is opened
                    Intent intent = new Intent(getBaseContext(), activity);
                    intent.putExtra("ACTIVITY_LIST", activityList);
                    intent.putExtra("Answers", answers);
                    startActivity(intent);
                }
            }
        });
    }
}

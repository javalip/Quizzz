package com.example.android.quizzzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/***
 * Questions from follwoign site. http://www.sciencekids.co.nz/quizzes/biology.html
 * Some solutions from stackoverflow
 * Rest of the learning from Udacity :)
 */

public class MainActivity extends AppCompatActivity {
    String answer1 ;
    String answer2 ;
    String answer3 ;
    String answer4 ;
    String answer5 ;
    String answer6 ;
    String answer7 ;
    String answer8 ;
    String answer9 ;
    String answer10 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer1 = answer1 + getString(R.string.answer1);
        answer2 = answer2 + getString(R.string.answer2);
        answer3 = answer3 + getString(R.string.answer3);
        answer4 = answer4 + getString(R.string.answer4);
        answer5 = answer5 + getString(R.string.answer5);
        answer6 = answer6 + getString(R.string.answer6);
        answer7 = answer7 + getString(R.string.answer7);
        answer8 = answer8 + getString(R.string.answer8);
        answer9 = answer9 + getString(R.string.answer9);
        answer10 = answer10 + getString(R.string.answer10);
    }

    List<Boolean> correctAnswers = new ArrayList<>();
    String[] answers = {answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10};

    String[] a = {"Plants And Animals", "Botony And Zooalogy", "Mycology", "Chromosome", "Charles Darwin", "Extinction", "Mutation", "Photosynthesis", "Genetics", "False"};

    public void submitResults(View view) {
        List<Boolean> correctAnswers = new LinkedList<Boolean>();
        CheckBox[] correctAnswerToQuestion1 = {findViewById(R.id.question1_option1), findViewById(R.id.question1_option3)};
        CheckBox[] inCorrectAnswersToQuestion1 = {findViewById(R.id.question1_option2), findViewById(R.id.question1_option4)};
        boolean isAnswertoQuestion1Correct = correctAnswerToQuestion1[0].isChecked() && correctAnswerToQuestion1[1].isChecked()
                && !inCorrectAnswersToQuestion1[0].isChecked() && !inCorrectAnswersToQuestion1[1].isChecked();
        if (isAnswertoQuestion1Correct) {
            correctAnswers.add(true);
        }
        CheckBox[] correctAnswerToQuestion2 = {findViewById(R.id.question2_option1), findViewById(R.id.question2_option2)};
        CheckBox[] inCorrectAnswerToQuestion2 = {findViewById(R.id.question2_option3), findViewById(R.id.question2_option4)};
        boolean isAnswerToQuestion2Correct = correctAnswerToQuestion2[0].isChecked() && correctAnswerToQuestion2[1].isChecked()
                && !inCorrectAnswerToQuestion2[0].isChecked() && !inCorrectAnswerToQuestion2[1].isChecked();
        if (isAnswerToQuestion2Correct) {
            correctAnswers.add(true);
        }

        RadioButton correctAnswerToQuestion3 = findViewById(R.id.question3_option1);
        boolean isAnswerToQuestion3Correct = correctAnswerToQuestion3.isChecked();
        if (isAnswerToQuestion3Correct) {
            correctAnswers.add(true);
        }


        RadioButton correctAnswerToQuestion4 = findViewById(R.id.question4_option4);
        boolean isAnswerToQuestion4Correct = correctAnswerToQuestion4.isChecked();
        if (isAnswerToQuestion4Correct) {
            correctAnswers.add(true);

        }
        RadioButton correctAnswerToQuestion5 = findViewById(R.id.question5_option3);
        boolean isAnswerToQuestion5Correct = correctAnswerToQuestion5.isChecked();
        if (isAnswerToQuestion5Correct) {
            correctAnswers.add(true);

        }
        RadioButton correctAnswerToQuestion6 = findViewById(R.id.question6_option2);
        boolean isAnswerToQuestion6Correct = correctAnswerToQuestion6.isChecked();
        if (isAnswerToQuestion6Correct) {
            correctAnswers.add(true);
        }

        EditText answerToQuestion7 = findViewById(R.id.question7_option1);
        String userAnswerToQuestion7 = answerToQuestion7.getText().toString();
        String answer7 = "Mutation";
        boolean isAnswerToQuestion7Correct = answer7.equalsIgnoreCase(userAnswerToQuestion7);

        if (isAnswerToQuestion7Correct) {
            correctAnswers.add(true);
        }

        EditText answerToQuestion8 = findViewById(R.id.question8_option1);
        String userAnswerToQuestion8 = answerToQuestion8.getText().toString();
        String answer8 = "Photosynthesis";
        boolean isAnswerToQuestion8Correct = answer8.equalsIgnoreCase(userAnswerToQuestion8);
        if (isAnswerToQuestion8Correct) {
            correctAnswers.add(true);

        }

        EditText answerToQuestion9 = findViewById(R.id.question9_option1);
        String userAnswerToQuestion9 = answerToQuestion9.getText().toString();
        String answer9 = "Genetics";
        boolean isAnswerToQuestion9Correct = answer9.equalsIgnoreCase(userAnswerToQuestion9);
        if (isAnswerToQuestion9Correct) {
            correctAnswers.add(true);
        }

        RadioButton correctAnswerToQuestion10 = findViewById(R.id.question10_option2);
        boolean isAnswerToQuestion10Correct = correctAnswerToQuestion10.isChecked();
        if (isAnswerToQuestion10Correct) {
            correctAnswers.add(true);
        }
        String message = displayAnswers(view);
        displayResults(correctAnswers.size(), message);
    }


    public void displayResults(int score, String message) {
        if (score == 0) {
            Toast.makeText(this, "0 out of 10 are correct." + "\n Correct answers are: " + message, Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, score + " out of 10 are correct." + "\n  Correct answers are: " + message, Toast.LENGTH_LONG).show();
        }
    }


    public void reset(View view) {
        CheckBox[] checkboxesForAnswer1 = {findViewById(R.id.question1_option1), findViewById(R.id.question1_option2), findViewById(R.id.question1_option3), findViewById(R.id.question1_option4)};
        for (int i = 0; i < checkboxesForAnswer1.length; i++) {
            checkboxesForAnswer1[i].setChecked(false);
        }
        CheckBox[] checkboxesForAnswer2 = {findViewById(R.id.question2_option1), findViewById(R.id.question2_option2), findViewById(R.id.question2_option3), findViewById(R.id.question2_option4)};
        for (int i = 0; i < checkboxesForAnswer2.length; i++) {
            checkboxesForAnswer2[i].setChecked(false);
        }
        RadioButton[] radioButtonsForAnswers3 = {findViewById(R.id.question3_option1), findViewById(R.id.question3_option2), findViewById(R.id.question3_option3), findViewById(R.id.question3_option4)};
        for (int i = 0; i < radioButtonsForAnswers3.length; i++) {
            radioButtonsForAnswers3[i].setChecked(false);
        }
        RadioButton[] radioButtonsForAnswer4 = {findViewById(R.id.question4_option1), findViewById(R.id.question4_option2), findViewById(R.id.question4_option3), findViewById(R.id.question4_option4)};
        for (int i = 0; i < radioButtonsForAnswer4.length; i++) {
            radioButtonsForAnswer4[i].setChecked(false);
        }

        RadioButton[] radioButtonsForAnswer5 = {findViewById(R.id.question5_option1), findViewById(R.id.question5_option2), findViewById(R.id.question5_option3), findViewById(R.id.question5_option4)};
        for (int i = 0; i < radioButtonsForAnswer5.length; i++) {
            radioButtonsForAnswer5[i].setChecked(false);
        }

        RadioButton[] radioButtonsForAnswer6 = {findViewById(R.id.question6_option1), findViewById(R.id.question6_option2), findViewById(R.id.question6_option3), findViewById(R.id.question6_option4)};
        for (int i = 0; i < radioButtonsForAnswer6.length; i++) {
            radioButtonsForAnswer6[i].setChecked(false);
        }
        EditText editTextForAnswer7 = findViewById(R.id.question7_option1);
        editTextForAnswer7.setText("");

        EditText editTextForAnswer8 = findViewById(R.id.question8_option1);
        editTextForAnswer8.setText("");

        EditText editTextForAnswer9 = findViewById(R.id.question9_option1);
        editTextForAnswer9.setText("");

        RadioButton[] radioButtonsForAnswer10 = {findViewById(R.id.question10_option1), findViewById(R.id.question10_option2)};
        for (int i = 0; i < radioButtonsForAnswer10.length; i++) {
            radioButtonsForAnswer10[i].setChecked(false);
        }
        RadioGroup radioGroupForQuestion10 = findViewById(R.id.question10_group);
        radioGroupForQuestion10.clearCheck();
        correctAnswers.clear();
    }

    public String displayAnswers(View view) {
        String message = "1. " + answers[0];
        for (int i = 1; i < answers.length; i++) {
            int number = i + 1;
            message = message + ", " + number + ". " + answers[i];
        }
        return message;
    }
}

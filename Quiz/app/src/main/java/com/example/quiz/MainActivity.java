package com.example.quiz;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "Hello In My QuiZ", Toast.LENGTH_SHORT).show();

    }

    public void Submit(View view) {
        EditText namefield = (EditText) findViewById(R.id.name_field);
        String name = namefield.getText().toString();
        CheckBox Egyptian = (CheckBox) findViewById(R.id.Egyptian_checkbox);
        boolean isEgyptian = Egyptian.isChecked();
        CheckBox American = (CheckBox) findViewById(R.id.American_checkbox);
        boolean isAmerican = American.isChecked();
        CheckBox Japanies = (CheckBox) findViewById(R.id.Japanese_checkbox);
        boolean isJapanies = Japanies.isChecked();
        EditText answer1field = (EditText) findViewById(R.id.answer1_field);
        String answer1 = answer1field.getText().toString();
        CheckBox Gharbia = (CheckBox) findViewById(R.id.Gharbia_checkbox);
        boolean inGharbia = Gharbia.isChecked();
        CheckBox Alxandria = (CheckBox) findViewById(R.id.Alxandria_checkbox);
        boolean inAlxandria = Alxandria.isChecked();
        CheckBox Cairo = (CheckBox) findViewById(R.id.Cairo_checkbox);
        boolean inCairo = Cairo.isChecked();
        EditText answer2field = (EditText) findViewById(R.id.answer2_field);
        String answer2 = answer2field.getText().toString();
        RadioButton Yes1 = (RadioButton) findViewById(R.id.yes1_button);
        boolean istrue = Yes1.isChecked();
        EditText answer3field = (EditText) findViewById(R.id.answer3_field);
        String answer3 = answer3field.getText().toString();
        RadioButton Yes2 = (RadioButton) findViewById(R.id.yes2_button);
        boolean istrue2 = Yes2.isChecked();
        EditText answer4field = (EditText) findViewById(R.id.answer4_field);
        String answer4 = answer4field.getText().toString();
        String Message = creatSummary(name, isEgyptian, isAmerican, isJapanies, answer1, inGharbia, inAlxandria, inCairo, answer2, istrue, answer3, istrue2, answer4);
        displayMessage(Message);
    }

    private String creatSummary(String name, boolean isEgyptian, boolean isAmerican, boolean isJapanies, String answer1, boolean inGharbia, boolean inAlxandria, boolean inCairo, String answer2, boolean istrue, String answer3, boolean istrue2, String answer4) {
        String Answers = " Thanks Four Your Answers " + "\n" + name;
        int Score = 0;
        int inCorrect = 0;
        /**if statements*/
        if (isEgyptian && isAmerican && isJapanies == false) {
            Answers += "\n1- True";
            Score += +1;
        } else {
            Answers += "\n1- False " + "\nThe Correct Is Egyptian And American";
            inCorrect += 1;
            Answers += "\nYour Answer " + answer1 + "Is False";
        }
        if (inGharbia && inAlxandria && inCairo == false) {
            Score += +1;
            Answers += "\n2- True";

        } else {
            Answers += "\n2- False " + "\nThe Correct Is Gharbia And Alxandria";
            inCorrect += 1;
            Answers += "\nYour Answer " + answer2 + "Is False";
        }
        if (istrue) {
            Answers += "\n3- True";
            Score += +1;
        } else {
            Answers += "\n3- False " + "\nThe Correct Answer Is True";
            inCorrect += 1;
            Answers += "\nYour Answer " + answer3 + "Is False";
        }
        if (istrue2) {
            Answers += "\n4- True";
            Score += +1;
        } else {
            Answers += "\n4- False " + "\nThe Correct Answer Is True";
            inCorrect += 1;
            Answers += "\nYour Answer " + answer3 + "Is False";
        }
        /** this toast */
        Context context = getApplicationContext();
        CharSequence text = "Score " + Score + " Point From 4";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Answers += "\nYour Score : " + Score + " From 4";
        Answers += "\nIn Correct Answers :" + inCorrect + " From 4";
        return Answers;
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.sumary_view);
        orderSummaryTextView.setText(message);
    }
}

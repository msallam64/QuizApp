package com.example.mohamedsallam.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        score = 0;
        int x = checkanswer();
        if (score == 7) {
            Toast.makeText(this, "AWESOME,Your Score is : " + x + " From 7 Questions . ", Toast.LENGTH_LONG).show();
        } else if (score <= 2) {
            Toast.makeText(this, "Bad,Your Score is : " + x + " From 7 Questions . ", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, "Normal,Your Score is : " + x + " From 7 Questions . ", Toast.LENGTH_LONG).show();
    }

    public int checkanswer() {
        RadioButton rbq1t = (RadioButton) findViewById(R.id.rb_q1tr);
        CheckBox cbq2tv = (CheckBox) findViewById(R.id.cb_q2tv);
        CheckBox cbq2iv = (CheckBox) findViewById(R.id.cb_q2iv);
        CheckBox cbq2bu = (CheckBox) findViewById(R.id.cb_q2b);
        RadioButton q4 = (RadioButton) findViewById(R.id.rb_q5fal);
        RadioButton rcq5t = (RadioButton) findViewById(R.id.rb_q5tr);
        RadioButton q6 = (RadioButton) findViewById(R.id.rb_q6tr);
        RadioButton q7 = (RadioButton) findViewById(R.id.rb_q7fal);
        EditText e = (EditText) findViewById(R.id.et_q7);
        String value = e.getText().toString().trim();
        if (!TextUtils.isEmpty(value)) {
            int finalValue = Integer.parseInt(value);
            if (finalValue == 0) {
                score = score + 1;
            }
        }

        boolean q1 = rbq1t.isChecked();
        boolean q2 = cbq2tv.isChecked();
        boolean q22 = cbq2iv.isChecked();
        boolean q222 = cbq2bu.isChecked();
        boolean qq4 = q4.isChecked();
        boolean q5 = rcq5t.isChecked();
        boolean qq6 = q6.isChecked();
        boolean qq7 = q7.isChecked();
        if (q2 == true && q22 == true && q222 == false) {
            score = score + 1;
        }
        boolean[] answer = {q1, qq4, q5, qq6, qq7};
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == true) {
                score = score + 1;
            }
        }
        return score;
    }
}

package com.example.gricsan.lv_exam;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;


public class ExamScreen extends ActionBarActivity {

    ArrayList<ExamQuestion> mQuestionPool;
    String[] mQuestions;
    TextView mQuestionText;
    TextView mQuestionAnswerText;
    TextView mQuestionNumber;
    private int mCurrQ;
    private int mTotalQNum;
    private View mNextQuestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_screen);

        mQuestionPool = new ArrayList<>();
        mQuestionText = (TextView) findViewById(R.id.question_text);
        mQuestionAnswerText = (TextView) findViewById(R.id.answer_text);
        mQuestionNumber = (TextView) findViewById(R.id.question_num);
        mQuestions = getResources().getStringArray(R.array.questions);
        mNextQuestionButton = findViewById(R.id.show_nextq_button);

        for (int i = 0; i <= mQuestions.length - 1; i++) {
            mQuestionPool.add(new ExamQuestion(mQuestions[i]));
        }
        Collections.shuffle(mQuestionPool);
        mQuestionText.setText(mQuestionPool.get(0).getQuestionText());
        mNextQuestionButton.setEnabled(false);
        mTotalQNum = mQuestionPool.size();
        mCurrQ = 1;
        mQuestionNumber.setText(mCurrQ + "/" + mTotalQNum);

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Yeah, right... NOW FINISH IT!! BEYATCH!", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_answer_button:
                mQuestionAnswerText.setText(mQuestionPool.get(0).getRightAnswer());
                mNextQuestionButton.setEnabled(true);
                break;
            case R.id.show_nextq_button:
                mQuestionPool.remove(0);
                mCurrQ++;
                if (!mQuestionPool.isEmpty()) {
                    mQuestionNumber.setText(mCurrQ + "/" + mTotalQNum);
                    mQuestionText.setText(mQuestionPool.get(0).getQuestionText());
                } else {
                    finish();
                }
                mQuestionAnswerText.setText("");
                mNextQuestionButton.setEnabled(false);
                break;
//            case R.id.show_hint_button:
//                mQuestionAnswerText.setText(mQuestionPool.get(0).getRightAnswer().charAt(0)+"....");
//                break;
            default:
                break;
        }
    }
}

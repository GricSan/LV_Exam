package com.example.gricsan.lv_exam;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class ExamScreen extends ActionBarActivity {

    ArrayList<ExamQuestion> mQuestionPool;
    String[] mQuestions;
    TextView mQuestionText;
    TextView mQuestionAnswerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_screen);

        mQuestionPool = new ArrayList<>();
        mQuestionText = (TextView) findViewById(R.id.question_text);
        mQuestionAnswerText = (TextView) findViewById(R.id.answer_text);
        mQuestions = getResources().getStringArray(R.array.questions);

        for(int i = 0; i <= mQuestions.length-1; i++){
            mQuestionPool.add(new ExamQuestion(mQuestions[i]));
        }
        Collections.shuffle(mQuestionPool);
        mQuestionText.setText(mQuestionPool.get(0).getQuestionText());

    }

    public void onClick(View view) {
        switch(view.getId()){
            case R.id.show_answer_button:
                mQuestionAnswerText.setText(mQuestionPool.get(0).getRightAnswer());
                break;
            case R.id.show_nextq_button:
                mQuestionPool.remove(0);
                if(!mQuestionPool.isEmpty()){
                    mQuestionText.setText(mQuestionPool.get(0).getQuestionText());
                }else{
                    finish();
                }
                    mQuestionAnswerText.setText("");
                break;
//            case R.id.show_hint_button:
//                mQuestionAnswerText.setText(mQuestionPool.get(0).getRightAnswer().charAt(0)+"....");
//                break;
            default:
                break;
        }
    }
}

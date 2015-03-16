package com.example.gricsan.lv_exam;

/**
 * Created by GricSan on 3/13/2015.
 */
public class ExamQuestion {

    private String mQuestionText;
    private String mQuestionAnswer;

    public ExamQuestion(String questionText){
        int pointOfDivide = questionText.indexOf("?")+1;
        mQuestionText = questionText.substring(0, pointOfDivide);
        mQuestionAnswer = questionText.substring(pointOfDivide);
    }

    public String getQuestionText(){
        return  mQuestionText;
    }

    public String getRightAnswer(){
        return mQuestionAnswer;
    }
}

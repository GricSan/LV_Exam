package com.example.gricsan.lv_exam;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainScreen extends ActionBarActivity {

    Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        mStartButton = (Button) findViewById(R.id.start_button);
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_button:
                startActivity(new Intent(this, ExamScreen.class));
                break;
            default:
                break;
        }
    }
}

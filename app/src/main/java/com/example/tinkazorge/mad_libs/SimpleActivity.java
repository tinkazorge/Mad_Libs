package com.example.tinkazorge.mad_libs;

/*
 * This class saves the input a user gives for the simple story and pushes
 * it on to the next activity. When the user clicks go,
 * the next one will start.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tinkazorge.mad_libs.R;

public class SimpleActivity extends AppCompatActivity {

    //declare widgets and edittexts
    TextView madlibText;
    EditText adjectiveText;
    EditText jobText;
    Button continueButton;

    @Override
    //make sure the user can click anywhere in the screen to lose the focus on the EditText
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_);

        //Find TextView and EditTexts
        madlibText = (TextView) findViewById(R.id.textview_madlib);
        adjectiveText = (EditText) findViewById(R.id.adjective_word);
        jobText = (EditText) findViewById(R.id.job_word);
        continueButton = (Button) findViewById(R.id.continue_button);

        //if continueButton is clicked
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //retrieve user input
                String job = jobText.getText().toString();
                String adjective = adjectiveText.getText().toString();

                //define next activity
                Intent simplestory = new Intent(SimpleActivity.this, SimpleStory.class);

                //push  input to next activity
                simplestory.putExtra("input_adjective", adjective);
                simplestory.putExtra("input_job", job);

                //start next activity
                startActivity(simplestory);
            }
        });
    }
}

package com.example.tinkazorge.mad_libs;

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

/*
 * This class saves the input a user gives for the circus story and pushes
 * it on to the next activity. When the user clicks go,
 * the next one will start.
 */
public class CircusActivity extends AppCompatActivity {

    //declare widgets and edittexts
    TextView CircusText;
    EditText Adjective1Text;
    EditText Adjective2Text;
    EditText AnimalText;
    EditText BodypartText;
    EditText Noun1Text;
    EditText Noun2Text;
    EditText Pluralnoun1Text;
    EditText Pluralnoun2Text;
    Button goButton;

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
        setContentView(R.layout.activity_circus);

        //Find TextView and EditTexts
        CircusText = (TextView) findViewById(R.id.textview_circus);
        Adjective1Text = (EditText) findViewById(R.id.adjective_1);
        Adjective2Text = (EditText) findViewById(R.id.adjective_2);
        Pluralnoun1Text = (EditText) findViewById(R.id.plural_noun_1);
        Pluralnoun2Text = (EditText) findViewById(R.id.plural_noun_2);
        BodypartText = (EditText) findViewById(R.id.body_part);
        AnimalText = (EditText) findViewById(R.id.animal);
        Noun1Text = (EditText) findViewById(R.id.noun_1);
        Noun2Text = (EditText) findViewById(R.id.noun_2);
        goButton = (Button) findViewById(R.id.go_button);

        //when gobutton is clicked
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //retrieve input from users
                String adjective1 = Adjective1Text.getText().toString();
                String adjective2 = Adjective2Text.getText().toString();
                String pluralnoun1 = Pluralnoun1Text.getText().toString();
                String pluralnoun2 = Pluralnoun2Text.getText().toString();
                String noun1 = Noun1Text.getText().toString();
                String noun2 = Noun2Text.getText().toString();
                String animal = AnimalText.getText().toString();
                String bodypart = BodypartText.getText().toString();

                //define next activity
                Intent circusstory = new Intent(CircusActivity.this, CircusStory.class);

                //push  input to next activity
                circusstory.putExtra("adjective1", adjective1);
                circusstory.putExtra("adjective2", adjective2);
                circusstory.putExtra("animal", animal);
                circusstory.putExtra("bodypart", bodypart);
                circusstory.putExtra("pluralnoun1", pluralnoun1);
                circusstory.putExtra("pluralnoun2", pluralnoun2);
                circusstory.putExtra("noun1", noun1);;
                circusstory.putExtra("noun2", noun2);

                //start next activity
                startActivity(circusstory);
            }
        });

    }
}

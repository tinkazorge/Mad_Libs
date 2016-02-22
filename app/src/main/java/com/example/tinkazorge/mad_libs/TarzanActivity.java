package com.example.tinkazorge.mad_libs;

/*
 * This class saves the input a user gives for the tarzan story and pushes
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

public class TarzanActivity extends AppCompatActivity {

    //declare widgets and edittexts
    TextView MadlibText;
    EditText Adjective1Text;
    EditText Adjective2Text;
    EditText Adjective3Text;
    EditText Adjective4Text;
    EditText PluralNoun1Text;
    EditText PluralNoun2Text;
    EditText PluralNoun3Text;
    EditText Noun1Text;
    EditText Noun2Text;
    EditText Noun3Text;
    EditText PlaceText;
    EditText PersonsNameText;
    EditText FunnyNoiseText;
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
        setContentView(R.layout.activity_tarzan);

        //Find TextView and EditTexts
        MadlibText = (TextView) findViewById(R.id.textview_madlib);
        Adjective1Text = (EditText) findViewById(R.id.adjective_1);
        Adjective2Text = (EditText) findViewById(R.id.adjective_2);
        Adjective3Text = (EditText) findViewById(R.id.adjective_3);
        Adjective4Text = (EditText) findViewById(R.id.adjective_4);
        PluralNoun1Text = (EditText) findViewById(R.id.plural_noun);
        PluralNoun2Text = (EditText) findViewById(R.id.plural_noun_2);
        PluralNoun3Text = (EditText) findViewById(R.id.plural_noun_3);
        Noun1Text = (EditText) findViewById(R.id.noun_1);
        Noun2Text = (EditText) findViewById(R.id.noun_2);
        Noun3Text = (EditText) findViewById(R.id.noun_3);
        PlaceText = (EditText) findViewById(R.id.place_1);
        PersonsNameText = (EditText) findViewById(R.id.persons_name);
        FunnyNoiseText = (EditText) findViewById(R.id.funny_noise);
        goButton = (Button) findViewById(R.id.go_button);

        //when button is clicked
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //retrieve input from EditTexts
                String adjective1 = Adjective1Text.getText().toString();
                String adjective2 = Adjective2Text.getText().toString();
                String adjective3 = Adjective3Text.getText().toString();
                String adjective4 = Adjective4Text.getText().toString();
                String pluralnoun1 = PluralNoun1Text.getText().toString();
                String pluralnoun2 = PluralNoun2Text.getText().toString();
                String pluralnoun3 = PluralNoun3Text.getText().toString();
                String noun1 = Noun1Text.getText().toString();
                String noun2 = Noun2Text.getText().toString();
                String noun3 = Noun3Text.getText().toString();
                String place = PlaceText.getText().toString();
                String personsname = PersonsNameText.getText().toString();
                String funnynoise = FunnyNoiseText.getText().toString();

                //define next activity
                Intent tarzanstory = new Intent(TarzanActivity.this, TarzanStory.class);

                //push  input to next activity
                tarzanstory.putExtra("adjective1", adjective1);
                tarzanstory.putExtra("adjective2", adjective2);
                tarzanstory.putExtra("adjective3", adjective3);
                tarzanstory.putExtra("adjective4", adjective4);
                tarzanstory.putExtra("pluralnoun1", pluralnoun1);
                tarzanstory.putExtra("pluralnoun2", pluralnoun2);;
                tarzanstory.putExtra("pluralnoun3", pluralnoun3);
                tarzanstory.putExtra("noun1", noun1);
                tarzanstory.putExtra("noun2", noun2);
                tarzanstory.putExtra("noun3", noun3);
                tarzanstory.putExtra("place", place);
                tarzanstory.putExtra("personsname", personsname);
                tarzanstory.putExtra("funnynoise", funnynoise);

                //start next activity
                startActivity(tarzanstory);
            }
        });




    }
}

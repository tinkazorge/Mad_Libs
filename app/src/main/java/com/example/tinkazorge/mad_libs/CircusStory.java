package com.example.tinkazorge.mad_libs;
/*
 * This class retrieves the input that was pushed from the CircusActivity for the circus
 * story and sets the text of the story. When the user clicks "again!", it redirects to MainActivity.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CircusStory extends AppCompatActivity {

    //declare widgets and edittexts
    TextView circusstoryText;
    Button againButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circus_story);

        //Find TextView and EditTexts
        circusstoryText = (TextView) findViewById(R.id.circus_story);
        againButton = (Button) findViewById(R.id.again_button);

        //get the intent that started the activity
        Intent circusstory = getIntent();

        //retrieve input pushed from previous activity
        Bundle adjective1 = circusstory.getExtras();
        String story_adjective1 = (String) adjective1.get("adjective1");
        Bundle adjective2 = circusstory.getExtras();
        String story_adjective2 = (String) adjective2.get("adjective2");
        Bundle pluralnoun1 = circusstory.getExtras();
        String story_pluralnoun1 = (String) pluralnoun1.get("pluralnoun1");
        Bundle pluralnoun2 = circusstory.getExtras();
        String story_pluralnoun2 = (String) pluralnoun2.get("pluralnoun2");
        Bundle noun1 = circusstory.getExtras();
        String story_noun1 = (String) noun1.get("noun1");
        Bundle noun2 = circusstory.getExtras();
        String story_noun2 = (String) noun2.get("noun2");
        Bundle animal = circusstory.getExtras();
        String story_animal = (String) animal.get("animal");
        Bundle bodypart = circusstory.getExtras();
        String story_bodypart = (String) bodypart.get("bodypart");

        //print the story
        circusstoryText.setText(getString(R.string.circus_story_text) + story_pluralnoun1 + "! The circus is back in town! To your right, we see the " + story_adjective1 + " Man, who is famous for his " + story_adjective2 + " " + story_bodypart + ". And there are the acrobats, whose job is quite dangerous. Last week one of them tripped over a " + story_noun1 + " and badly hurt his " + story_noun2 + ". He thought he was a " + story_animal + " for three days! Luckily the clowns cheered him up by throwing " + story_pluralnoun2 + " at him. Haha!");

        //go back to start with againbutton
        againButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_activity = new Intent(CircusStory.this, MainActivity.class);
                startActivity(main_activity);
            }
        });

    }
}

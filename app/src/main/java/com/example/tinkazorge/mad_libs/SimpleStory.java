package com.example.tinkazorge.mad_libs;

/*
 * This class retrieves the input that was pushed from the SimpleActivity for the simple
 * story and sets the text of the story. When the user clicks "again!", it redirects to MainActivity.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tinkazorge.mad_libs.R;

public class SimpleStory extends AppCompatActivity {

    //declare widgets and edittexts
    TextView simplestoryText;
    Button againButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_story);

        //Find TextView and EditTexts
        simplestoryText = (TextView) findViewById(R.id.simplestory_text);
        againButton = (Button) findViewById(R.id.again_button);

        //get the intent that dtarted the activity
        Intent simplestory = getIntent();

        //retrieve input pushed from previous activity
        Bundle adjectives = simplestory.getExtras();
        String story_adjective = (String) adjectives.get("input_adjective");
        Bundle jobs = simplestory.getExtras();
        String story_job = (String) jobs.get("input_job");

        //Print the story
        simplestoryText.setText(getString(R.string.simple_story_text) + story_job + " when I grow up. Just like my dad. Life is " + story_adjective + " like that!");

        //go back to start with againbutton
        againButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_activity = new Intent(SimpleStory.this, MainActivity.class);
                startActivity(main_activity);
            }
        });

    }
}

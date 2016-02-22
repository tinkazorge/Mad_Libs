package com.example.tinkazorge.mad_libs;

/*
 * This class retrieves the input that was pushed from the TarzanActivity for the tarzan
 * story and sets the text of the story. When the user clicks "again!", it redirects to MainActivity.
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class TarzanStory extends AppCompatActivity {

    //declare widgets and edittexts
    TextView tarzanstoryText;
    Button againButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarzan_story);

        //Find TextView and EditTexts
        tarzanstoryText = (TextView) findViewById(R.id.tarzanstory_text);
        againButton = (Button) findViewById(R.id.again_button);

        //get the intent that started the activity
        Intent tarzanstory = getIntent();

        //retrieve input pushed from previous activity
        Bundle adjective1 = tarzanstory.getExtras();
        String story_adjective1 = (String) adjective1.get("adjective1");
        Bundle adjective2 = tarzanstory.getExtras();
        String story_adjective2 = (String) adjective2.get("adjective2");
        Bundle adjective3 = tarzanstory.getExtras();
        String story_adjective3 = (String) adjective3.get("adjective3");
        Bundle adjective4 = tarzanstory.getExtras();
        String story_adjective4 = (String) adjective4.get("adjective4");
        Bundle pluralnoun1 = tarzanstory.getExtras();
        String story_pluralnoun1 = (String) pluralnoun1.get("pluralnoun1");
        Bundle pluralnoun2 = tarzanstory.getExtras();
        String story_pluralnoun2 = (String) pluralnoun2.get("pluralnoun2");
        Bundle pluralnoun3 = tarzanstory.getExtras();
        String story_pluralnoun3 = (String) pluralnoun3.get("pluralnoun3");
        Bundle noun1 = tarzanstory.getExtras();
        String story_noun1 = (String) noun1.get("noun1");
        Bundle noun2 = tarzanstory.getExtras();
        String story_noun2 = (String) noun2.get("noun2");
        Bundle noun3 = tarzanstory.getExtras();
        String story_noun3 = (String) noun3.get("noun3");
        Bundle place = tarzanstory.getExtras();
        String story_place = (String) place.get("place");
        Bundle personsname = tarzanstory.getExtras();
        String story_personsname = (String) personsname.get("personsname");
        Bundle funnynoise = tarzanstory.getExtras();
        String story_funnynoise = (String) funnynoise.get("funnynoise");

        //print the story
        tarzanstoryText.setText(getString(R.string.tarzan_story_text) + story_adjective1 + " characters in fiction is named \"Tarzan of the " + story_pluralnoun1 + "\". Tarzan was raised by a/an " + story_noun1 + " and lives in the" + story_adjective2 + " jungle in the heart of darkest " + story_place + ". He spends most of his time eating " + story_pluralnoun2 + " and swinging from tree to " + story_noun2 + ". Whenever he gets angry, he beats on his chest and says, \"" + story_funnynoise + "\" This is his war cry. Tarzan always dresses in " + story_adjective3 + "shorts made from the skin of a/an " + story_noun3 + " and his best friend is a/an" + story_adjective4 + " chimpanzee named Cheetah. He is supposed to be able to speak to elephants and " + story_pluralnoun3 + ". In the movies, Tarzan is played by " + story_personsname + ".");

        //go back to start with againbutton
        againButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_activity = new Intent(TarzanStory.this, MainActivity.class);
                startActivity(main_activity);}
        });

    }

}

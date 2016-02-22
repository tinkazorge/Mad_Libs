package com.example.tinkazorge.mad_libs;

/*
 * This class represents the Main Activity. When the user clicks one of the three buttons,
 * they will be redirected to another activity.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare widgets and edittexts
    TextView madlibText;
    Button circusButton;
    Button simpleButton;
    Button tarzanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find TextView and EditTexts
        madlibText = (TextView) findViewById(R.id.textview_madlib);
        circusButton = (Button) findViewById(R.id.circus_button);
        simpleButton = (Button) findViewById(R.id.simple_button);
        tarzanButton = (Button) findViewById(R.id.tarzan_button);

        //if circusbutton is clicked
        circusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start CircusActivity
                Intent circus_activity = new Intent(MainActivity.this, CircusActivity.class);
                startActivity(circus_activity);}
        });
        //if simplebutton is clicked
        simpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start SimpleActivity
                Intent simple_activity = new Intent(MainActivity.this, SimpleActivity.class);
                startActivity(simple_activity);}
        });
        //if tarzanbutton is clicked
        tarzanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start tarzanActivity
                Intent tarzan_activity = new Intent(MainActivity.this, TarzanActivity.class);
                startActivity(tarzan_activity);}
        });
    }
}


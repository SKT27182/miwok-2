package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTitle(R.string.category_numbers);
        setContentView(R.layout.activity_numbers);
//        This is the Array
//        String [] words = new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};


        //This is an ArrayList
        ArrayList<String> words = new ArrayList<String>();
        words.add("One");
        words.add("Two");
        words.add("Three");
        words.add("Four");
        words.add("Five");
        words.add("Six");
        words.add("Seven");
        words.add("Eight");
        words.add("Nine");
        words.add("Ten");


        //added LinearLayout and TextView from java
        // Find the root view so we can add child views to it
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        // Create a variable to keep track of the current index position
        int index = 0;

        // Keep looping until we've reached the end of the list (which means keep looping
        // as long as the current index position is less than the length of the list)
        while (index < words.size()) {
            // Create a new TextView
            TextView wordView = new TextView(this);

            // Set the text to be word at the current index
            wordView.setText(words.get(index));
            // Add this TextView as another child to the root view of this layout
            rootView.addView(wordView);

            // Increment the index variable by 1
            index++;
        }



        //Log Message to show the value of words[0] in logcat
//        Log.v("NumbersActivity","Word at index 0: "+ words[0]);
    }
}
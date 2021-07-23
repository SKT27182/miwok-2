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

        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
        TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView((wordView));

        //Log Message to show the value of words[0] in logcat
//        Log.v("NumbersActivity","Word at index 0: "+ words[0]);
    }
}
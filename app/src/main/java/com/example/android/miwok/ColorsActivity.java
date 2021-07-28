package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.category_colors);
        setContentView(R.layout.activity_numbers);

//        This is the Array
//        String [] words = new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};


        //This is an ArrayList
        ArrayList<Word> words = new ArrayList<Word>();

        /**
         * Word w = new Word("ONE","UNO");
         * words/add(w);
         */

        words.add(new Word("red","weṭeṭṭ",  R.drawable.color_red));
        words.add(new Word("green","chokokk", R.drawable.color_green));
        words.add(new Word("brown","ṭakaakk",R.drawable.color_brown));
        words.add(new Word("gray","ṭopoppi", R.drawable.color_gray));
        words.add(new Word("black","kulull", R.drawable.color_black));
        words.add(new Word("white","kelell",R.drawable.color_white));
        words.add(new Word("dusty yellow","ṭopiisә", R.drawable.color_dusty_yellow));
        words.add(new Word("mustard yellow","chiwiiṭә", R.drawable.color_mustard_yellow));





        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter = new WordAdapter(this,  words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);
    }
}
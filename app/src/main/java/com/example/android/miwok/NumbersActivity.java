package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setTitle(R.string.category_numbers);
        setContentView(R.layout.activity_numbers);


//        This is the Array
//        String [] words = new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        //This is an ArrayList
        ArrayList<Word> words = new ArrayList<Word>();

        /**
         * Word w = new Word("ONE","UNO");
         * words/add(w);
         */

        words.add(new Word("one","lutt",  R.drawable.number_one));
        words.add(new Word("two","otiiko ", R.drawable.number_two));
        words.add(new Word("three","tolookosu",R.drawable.number_three));
        words.add(new Word("four","oyyisa", R.drawable.number_four));
        words.add(new Word("five","massokka", R.drawable.number_five));
        words.add(new Word("six","temmokka",R.drawable.number_six));
        words.add(new Word("seven","kenekaku", R.drawable.number_seven));
        words.add(new Word("eight","kawinta", R.drawable.number_eight));
        words.add(new Word("nine","wo’e",R.drawable.number_nine));
        words.add(new Word("ten","na’aacha", R.drawable.number_ten));






        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter = new WordAdapter(this,  words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, R.raw.filhaal);
                mMediaPlayer.start();

            }
        });




    }
}
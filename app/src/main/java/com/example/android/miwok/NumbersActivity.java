package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
        ArrayList<Word> words = new ArrayList<Word>();

        /**
         * Word w = new Word("ONE","UNO");
         * words/add(w);
         */
        words.add(new Word("ONE","UNO"));
        words.add(new Word("TWO","DOS"));
        words.add(new Word("THREE","TRES"));
        words.add(new Word("FOUR","CUATRO"));
        words.add(new Word("FIVE","CINCO"));
        words.add(new Word("SIX","SEIS"));
        words.add(new Word("SEVEN","SIETE"));
        words.add(new Word("EIGHT","OCHO"));
        words.add(new Word("NINE","NUEVE"));
        words.add(new Word("TEN","DIEZ"));
        words.add(new Word("ELEVEN","ONCE"));
        words.add(new Word("TWELVE","DOCE"));
        words.add(new Word("THIRTEEN","TRECE"));
        words.add(new Word("FOURTEEN","CATORCE"));
        words.add(new Word("FIFTEEN","QUINCE"));
        words.add(new Word("SIXTEEN","DIECISÉIS"));
        words.add(new Word("SEVENTEEN","DE DIECISIETE"));
        words.add(new Word("EIGHTEEN","DIECIOCHO"));
        words.add(new Word("NINETEEN","DIECINUEVE"));
        words.add(new Word("TWENTY","VEINTE"));
        words.add(new Word("TWENTY ONE","VEINTIUNO"));
        words.add(new Word("TWENTY TWO","VEINTIDÓS"));



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
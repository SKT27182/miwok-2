package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {


    //releases the memory as soon as we switch to another app
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                //Pause Playback
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }else if (focusChange == AudioManager.AUDIOFOCUS_GAIN){
                //Resume Playing
                mMediaPlayer.start();
            }else if (focusChange == AudioManager.AUDIOFOCUS_LOSS){
                //Stop Playing and release the resources
                releaseMediaPlayer();
            }
        }
    };

    //Checks whether the Media is completed or not if completed then run the onCompletion
    //This listener gets trigger when Media Player has completed playing audio
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.category_family);
        setContentView(R.layout.activity_numbers);

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

//        This is the Array
//        String [] words = new String[]{"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        final ArrayList<Word> words = new ArrayList<Word>();

        /**
         * Word w = new Word("ONE","UNO");
         * words/add(w);
         */

        words.add(new Word("father","әpә ",  R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother","әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son","angs",R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daughter","tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother","taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother","chalitt",R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister","teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister","kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother","ama",R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather","paapa ", R.drawable.family_grandfather, R.raw.family_grandfather));






        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter = new WordAdapter(this,  words , R.color.category_family);

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
                Word word= words.get(position);

                //Releases the memory as the new word is clicked
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result== AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioResourceId());
                    mMediaPlayer.start();

                    //Setup a listener on the Media Player , so that we can stop and release the memory
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }


            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer () {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            //Abandon audio focus when playback is complete
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}
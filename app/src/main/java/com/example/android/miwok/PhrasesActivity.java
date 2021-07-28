package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<word> words = new ArrayList<word>();
        words.add(new word("Where are you going", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new word("What is your name", "tinne oyaase'ne", R.raw.phrase_what_is_your_name));
        words.add(new word("My Name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new word("How are you feeling", "micheses", R.raw.phrase_how_are_you_feeling));
        words.add(new word("I'm feeling good", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new word("Are you coming?", "eenes'aa", R.raw.phrase_are_you_coming));
        words.add(new word("Yes, I'm coming.", "hee'eenem", R.raw.phrase_yes_im_coming));
        words.add(new word("I'm coming.", "eenem", R.raw.phrase_im_coming));
        words.add(new word("Let's go", "yoowutis", R.raw.phrase_lets_go));
        words.add(new word("Come here", "enni'nem", R.raw.phrase_come_here));

//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
//
//        for(int index=0; index<words.size(); index++)
//        {
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(index));
//            rootView.addView(wordView);
//        }

        WordAdapter adapter =
                new WordAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(NumbersActivity.this, "List in item", Toast.LENGTH_SHORT).show();
                word word = words.get(position);

                releaseMediaPlayer();

                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    /**
     * Clean up the media player by releasing its resources.
     */
    @Override
    protected void onStop(){
        super.onStop();

        //release the data
        releaseMediaPlayer();
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
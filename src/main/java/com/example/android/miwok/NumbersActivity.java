package com.owen.miworkapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    //declare the media player API file
    private MediaPlayer mMediaPlayer;

    //create an On Completion Listener to check if the son is done playing;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaResources();
        }
    };

    // Declare a variable to hold the Audion Manager
    private AudioManager mAudioManager;

    //declare the audioFocus Listner
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focus)
        {
            //check on the focus so as to know where to start from
            if (focus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK || focus == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT)
            {
                //pause and start from begining
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if (focus == AudioManager.AUDIOFOCUS_GAIN)
            {
                mMediaPlayer.start();
            }
            else if (focus == AudioManager.AUDIOFOCUS_LOSS)
            {
                releaseMediaResources();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        //instanciate the Audio Manger
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

      final   ArrayList<Word> words = new ArrayList<>();

//        Word w = new Word("Lutti","One");
//        words.add(w);
        words.add(new Word("Ndala", "One",R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Chipli", "Two",R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Chitaru", "Three",R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Chinne", "Four",R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Charano", "Five",R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Lutti", "Six",R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Lutti", "Seven",R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Lutti", "Eight",R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Lutti", "Nine",R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Lutti", "Ten",R.drawable.number_ten, R.raw.number_ten));
        words.add(new Word("Ndala", "One",R.drawable.number_one, R.raw.number_one));
        words.add(new Word("Chipli", "Two",R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Chitaru", "Three",R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Chinne", "Four",R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Charano", "Five",R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Lutti", "Six",R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Lutti", "Seven",R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Lutti", "Eight",R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Lutti", "Nine",R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Lutti", "Ten",R.drawable.number_ten, R.raw.number_ten));



        WordAdapter  adapter = new WordAdapter(this,  words, R.color.category_numbers);

        ListView listView = findViewById(R.id.listRoot);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaResources();

                Word word = words.get(position);

                //Request audio Focus  and play the music.
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                //check f reques has been granted
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmSoundPronunciation());

                    //start playing the media song. No need to prepare as it is automatic
                    mMediaPlayer.start();

                    mMediaPlayer.setOnCompletionListener(onCompletionListener);
                }
            }
        });
    }

    //Release the media Resource of onStop Life  Circle


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaResources();
    }

    private void releaseMediaResources()
    {
        if (mMediaPlayer != null)
        {
            mMediaPlayer.release();
        }
        mMediaPlayer = null;

        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_navigate, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.navigateback:
                startActivity(new Intent(NumbersActivity.this, MainActivity.class));
                return true;
            case R.id.add_language:
                //cal admin method to add languages to the application.
                startActivity(new Intent(getApplicationContext(), AdminActivity.class));
                return true;
            case R.id.exit_app:
                //exit the application method
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

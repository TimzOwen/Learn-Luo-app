
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);

        ArrayList<Word> words= new ArrayList<Word>();

        words.add(new Word("Achiel","one"));
        words.add(new Word("Ariyo","Two"));
        words.add(new Word("Adek","Three"));
        words.add(new Word("Ang'wen","Four"));
        words.add(new Word("Abich","five"));
        words.add(new Word("Auchiel","six"));
        words.add(new Word("Abiriyo","Seven"));
        words.add(new Word("Aboro","Eight"));
        words.add(new Word("Ochiko","Nine"));
        words.add(new Word("Apar","Ten"));

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list_numbers_view);


        listView.setAdapter(adapter);


    }
}

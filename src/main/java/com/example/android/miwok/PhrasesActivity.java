
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
        setContentView(R.layout.activity_phrases);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("How are You");
        arrayList.add("where do you live");
        arrayList.add("my name is ");
        arrayList.add("I am going");
        arrayList.add("he is running");
        arrayList.add("i am doing great");
        arrayList.add("have you eaten?");
        arrayList.add("where do you school at?");
        arrayList.add("Goodnight");
        arrayList.add("ask me why");
        arrayList.add("when i am going to job");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        ListView listView = (ListView) findViewById(R.id.list_phrases);

        listView.setAdapter(arrayAdapter);
    }
}

package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<String> colors = new ArrayList<>();

        colors.add("Black");
        colors.add("Blue");
        colors.add("Pink");
        colors.add("Yellow");
        colors.add("Red");
        colors.add("Green");
        colors.add("Purple");
        colors.add("Amber");
        colors.add("Grey");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, colors);

        ListView listView = (ListView) findViewById(R.id.list_colors);

        listView.setAdapter(adapter);
    }
}

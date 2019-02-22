
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList <String> familyMembers = new ArrayList<>();

        familyMembers.add("Father");
        familyMembers.add("Mother");
        familyMembers.add("Son");
        familyMembers.add("Daughter");
        familyMembers.add("Cousin");
        familyMembers.add("brother");
        familyMembers.add("Sister");
        familyMembers.add("uncle");
        familyMembers.add("Grand Pa");
        familyMembers.add("Gran Ma");
        familyMembers.add("Nephew");
        familyMembers.add("Elder sister");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, familyMembers);

        ListView famList = (ListView) findViewById(R.id.list_family);

        famList.setAdapter(adapter);
    }
}

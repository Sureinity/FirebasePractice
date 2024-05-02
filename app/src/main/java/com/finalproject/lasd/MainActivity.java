package com.finalproject.lasd;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.finalproject.lasd.Adapter.JournalsAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JournalsAdapter journalsAdapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view_story);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        databaseReference = FirebaseDatabase.getInstance().getReference("Journals");

        journalsAdapter = new JournalsAdapter(databaseReference);
        recyclerView.setAdapter(journalsAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        journalsAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        journalsAdapter.stopListening();
    }
}
package com.finalproject.lasd.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.finalproject.lasd.R;
import com.google.firebase.database.DataSnapshot;

public class JournalsAdapter extends RecyclerView.Adapter<JournalsAdapter.TitleDescriptionViewHolder> {

    private DataSnapshot dataSnapshot;

    public JournalsAdapter(DataSnapshot dataSnapshot) {
        this.dataSnapshot = dataSnapshot;
    }

    @NonNull
    @Override
    public TitleDescriptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.journals_item, parent, false);
        return new TitleDescriptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TitleDescriptionViewHolder holder, int position) {
        if (dataSnapshot.getChildrenCount() == 0) {
            // Handle the case where there are no journal items
            return;
        }

        DataSnapshot journalSnapshot = dataSnapshot.getChildren().iterator().next();

        String title = journalSnapshot.child("title").getValue(String.class);
        String description = journalSnapshot.child("description").getValue(String.class);

        holder.titleTextView.setText(title);
        holder.descriptionTextView.setText(description);
    }

    @Override
    public int getItemCount() {
        return (int) dataSnapshot.getChildrenCount();
    }

    public static class TitleDescriptionViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView descriptionTextView;

        public TitleDescriptionViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
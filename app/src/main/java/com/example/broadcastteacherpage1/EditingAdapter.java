package com.example.broadcastteacherpage1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EditingAdapter extends RecyclerView.Adapter<EditingAdapter.CardViewHolder>  {

    ArrayList<Editing> edit;
  

    public EditingAdapter(ArrayList<Editing> edit) {
        this.edit=edit;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit, parent, false);
        CardViewHolder cvh = new CardViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Editing currentCards = this.edit.get(position);
        holder.editingbutton.setImageResource(currentCards.getEditingButton());
        holder.editingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount()
    { return edit.size(); }


    


    public class CardViewHolder extends RecyclerView.ViewHolder {

        public ImageView editingbutton;


        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            editingbutton = itemView.findViewById(R.id.edit);



        }

    }
}

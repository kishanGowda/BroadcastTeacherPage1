package com.example.broadcastteacherpage1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupWindow;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        ConstraintLayout constraintOne,constraintTwo,constraintLayout;
            ArrayList<Editing> edit;
    RecyclerView recyclerView;

    ImageButton imageButton;

RecyclerView.Adapter adapter;
int counter;

    RecyclerView.LayoutManager cardLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintOne=findViewById(R.id.constraint_parent);
        constraintTwo=findViewById(R.id.constraint_for_visible);
        constraintLayout=findViewById(R.id.constraint_parent);
        imageButton=findViewById(R.id.more_ivb);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater lInflater = (LayoutInflater) getApplication().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View popup_view = lInflater.inflate(R.layout.cust_toast_layout, null);
                final PopupWindow popup = new PopupWindow(popup_view,400,400,true);
                popup.setFocusable(true);
                popup.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));;
                popup.showAsDropDown(imageButton,-415,210);
                


            }
        });

        createEdit();
        builRecyclerView();
        counter=0;




        constraintOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if(counter%2==0){
                    constraintTwo.setVisibility(View.GONE);
                } else {
                    constraintTwo.setVisibility(View.VISIBLE);

                }

            }
        }) ;

    }

    public void createEdit() {
        edit=new ArrayList<>();
        edit.add(new Editing(R.drawable.pencil));
        edit.add(new Editing(R.drawable.red));
        edit.add(new Editing(R.drawable.rectangle));
        edit.add(new Editing(R.drawable.pencil));
        edit.add(new Editing(R.drawable.pencil));
        edit.add(new Editing(R.drawable.pencil2));
        edit.add(new Editing(R.drawable.group));
        edit.add(new Editing(R.drawable.pencil));

    }
    public void builRecyclerView(){
        recyclerView=findViewById(R.id._recyclerView);
        recyclerView.setHasFixedSize(true);
        cardLayoutManager = new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(cardLayoutManager);
        adapter = new EditingAdapter(edit);
        recyclerView.setAdapter(adapter);

    }
}
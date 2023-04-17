package com.example.mobileemail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElement> elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("#0194C6","Juana","Colombia","Inactive"));
        elements.add(new ListElement("#AC01B2","Luisa","Argentina","Active"));
        elements.add(new ListElement("#B2014C","Kelly","Bolivia","Inactive"));
        elements.add(new ListElement("#34B201","Camilo","Argentina","Active"));
        elements.add(new ListElement("#A5B201","Julian","Colombia","Active"));
        elements.add(new ListElement("#01B27F","Yuliana","Venezuela","Inactive"));
        elements.add(new ListElement("#0116B2","Oscar","Colombia","Inactive"));



        ListAdapter listAdapter = new ListAdapter(elements, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    public void moveToDescription(ListElement item){
        Intent intent = new Intent(this,descriptionActivity.class);
        intent.putExtra("List",item);
        startActivity(intent);
    }
}
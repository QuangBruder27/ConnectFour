package com.quangbruder.connectfour.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.quangbruder.connectfour.R;
import com.quangbruder.connectfour.models.BoardColumn;

import java.util.ArrayList;

public class Game1Activity extends AppCompatActivity {

    ArrayList<BoardColumn> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        // Lookup the recyclerview in activity layout
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvBoardColumn);

        recyclerView.setNestedScrollingEnabled(false);
        // Initialize contacts
        list = BoardColumn.createBoardColumnList();
        // Create adapter passing in the sample user data
        BoardColumnsAdapter adapter = new BoardColumnsAdapter(list, true);

        // Attach the adapter to the recyclerview to populate items
        recyclerView.setAdapter(adapter);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

    }





}

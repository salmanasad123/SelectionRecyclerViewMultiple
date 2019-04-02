package com.example.selectionrecyclerviewmultiple;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    Activity activity = MainActivity.this;
    RecyclerView rv;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayoutManager lm = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        adapter = new ItemAdapter(this);

        rv = findViewById(R.id.rcView);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(lm);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), lm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);

        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1"));
        items.add(new Item("Item 2"));
        items.add(new Item("Item 3"));
        items.add(new Item("Item 4"));
        items.add(new Item("Item 5"));
        items.add(new Item("Item 6"));
        items.add(new Item("Item 7"));
        items.add(new Item("Item 8"));
        items.add(new Item("Item 9"));

        adapter.addAll(items);
    }

    public void selectAll(View v) {
        adapter.selectAll();
    }

    public void deselectAll(View v) {
        adapter.clearSelected();
    }

    public void doAction(View v) {
        Toast.makeText(activity, String.format("Selected %d items", adapter.getSelected().size()), Toast.LENGTH_SHORT).show();
    }
}


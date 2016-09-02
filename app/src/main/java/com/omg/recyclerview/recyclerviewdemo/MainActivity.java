package com.omg.recyclerview.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> mDataset;
    private ImageView mAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mAdd = (ImageView) findViewById(R.id.addItem) ;

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDataset = new ArrayList<>();
        mDataset.add("Item 1");
        mDataset.add("Item 2");
        mDataset.add("Item 3");
        mDataset.add("Item 4");
        mDataset.add("Item 5");
        mDataset.add("Item 6");
        mDataset.add("Item 7");


        // specify an adapter (see also next example)
        mAdapter = new DemoAdapter(mDataset);
        mRecyclerView.setAdapter(mAdapter);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataset.add(mDataset.size(), "Item " + mDataset.size());
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}

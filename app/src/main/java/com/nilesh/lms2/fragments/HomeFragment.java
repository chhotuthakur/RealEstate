package com.nilesh.lms2.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nilesh.lms2.R;
import com.nilesh.lms2.models.PlotModel;
import com.nilesh.lms2.utils.PlotAdapter;


public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    PlotAdapter plotAdapter;
    DatabaseReference mbase;



    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =  inflater.inflate(R.layout.fragment_home, container, false);

        Glide.with(getContext())
                .setDefaultRequestOptions(new RequestOptions().placeholder(R.drawable.ic_launcher_foreground))
                .applyDefaultRequestOptions(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL))
                .applyDefaultRequestOptions(RequestOptions.skipMemoryCacheOf(true));

        mbase = FirebaseDatabase.getInstance().getReference("plots");

        recyclerView = v.findViewById(R.id.rec_post);

        // To display the Recycler view linearly
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));

        // It is a class provide by the FirebaseUI to make a
        // query in the database to fetch appropriate data
        FirebaseRecyclerOptions<PlotModel> options
                = new FirebaseRecyclerOptions.Builder<PlotModel>()
                .setQuery(mbase, PlotModel.class)
                .build();
        // Connecting object of required Adapter class to
        // the Adapter class itself
        plotAdapter = new PlotAdapter(options);
        // Connecting Adapter class with the Recycler view*/
        recyclerView.setAdapter(plotAdapter);
        plotAdapter.startListening();







        return v;
    }
}
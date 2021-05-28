package com.example.sep4_android.views.mainapp.assistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sep4_android.R;
import com.example.sep4_android.adapters.GardenAdapter;
import com.example.sep4_android.models.Garden;
import com.example.sep4_android.viewmodels.assistant.GardenListViewModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class GardenListFragment extends Fragment implements GardenAdapter.OnItemClickListener {
    private View view;
    private GardenListViewModel viewModel;
    private FirebaseRecyclerOptions<Garden> options;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_garden_list, container, false);
        viewModel = new ViewModelProvider(this).get(GardenListViewModel.class);
        loadData();
        prepareRecyclerView();
        return view;
    }

    private void loadData(){
        options = new FirebaseRecyclerOptions.Builder<Garden>().setQuery(viewModel.getAllGardens(), Garden.class).build();
    }

    private void prepareRecyclerView(){
        RecyclerView recyclerView = view.findViewById(R.id.garden_recycler);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        GardenAdapter adapter = new GardenAdapter(options, this);
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onSendRequestClick(String gardenName) {
        viewModel.sendAssistantRequest(gardenName);
    }

    @Override
    public void onCancelAssistance(String gardenName, String assistantGoogleId) {
        viewModel.removeRequest(gardenName, assistantGoogleId);
    }
}
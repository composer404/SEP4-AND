package com.example.sep4_android.viewmodels.gardener;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.sep4_android.models.ConnectionStatus;
import com.example.sep4_android.models.Garden;
import com.example.sep4_android.repositories.GardenRepository;
import com.example.sep4_android.repositories.UserRepository;
import com.google.firebase.auth.FirebaseUser;

public class AddNewGardenViewModel extends AndroidViewModel {
    private final GardenRepository gardenRepository;
    private final UserRepository userRepository;

    public AddNewGardenViewModel(Application application) {
        super(application);
        userRepository = UserRepository.getInstance(application);
        gardenRepository = GardenRepository.getInstance(application);
    }

    public LiveData<ConnectionStatus> getCreationStatus() {
        return gardenRepository.getCreatingStatus();
    }

    public void addNewGarden(Garden garden) {
        gardenRepository.createGarden(garden);
    }

    public LiveData<FirebaseUser> getCurrentUser() {
        return userRepository.getCurrentUser();
    }
}

package com.example.sep4_android.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sep4_android.models.Garden;

@Dao
public interface GardenDAO {
    @Insert
    void createGarden(Garden garden);

    @Query("DELETE FROM GARDEN WHERE name=:gardenName")
    void removeGarden(String gardenName);

    @Query("SELECT * FROM Garden WHERE name=:gardenName")
    LiveData<Garden> getGarden(String gardenName);

    @Query("SELECT * FROM Garden WHERE ownerGoogleId=:userGoogleId")
    LiveData<Garden> getOwnGarden(String userGoogleId);

    @Query("SELECT EXISTS(SELECT * FROM Garden WHERE name=:gardenName)")
    boolean checkIfGardenExist(String gardenName);
}

package com.example.bikeibmec.ui.programa_milhas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProgramaMilhasViewModel extends ViewModel {
    private final MutableLiveData<String> mPoints;

    public ProgramaMilhasViewModel() {
        mPoints = new MutableLiveData<>();
        mPoints.setValue("1.236");
    }

    public LiveData<String> getPoints() {
        return mPoints;
    }
}
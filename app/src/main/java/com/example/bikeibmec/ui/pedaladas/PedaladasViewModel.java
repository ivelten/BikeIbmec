package com.example.bikeibmec.ui.pedaladas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PedaladasViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public PedaladasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pedaladas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
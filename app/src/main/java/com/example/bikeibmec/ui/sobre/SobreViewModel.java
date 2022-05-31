package com.example.bikeibmec.ui.sobre;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SobreViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public SobreViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Sobre fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
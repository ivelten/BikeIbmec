package com.example.bikeibmec.ui.missao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MissaoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MissaoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is missao fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
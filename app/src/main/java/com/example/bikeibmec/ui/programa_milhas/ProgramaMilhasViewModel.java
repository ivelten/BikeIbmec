package com.example.bikeibmec.ui.programa_milhas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProgramaMilhasViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ProgramaMilhasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Programa Milhas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
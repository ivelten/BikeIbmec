package com.example.bikeibmec.ui.agendamentos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AgendamentosViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public AgendamentosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Agendamento fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
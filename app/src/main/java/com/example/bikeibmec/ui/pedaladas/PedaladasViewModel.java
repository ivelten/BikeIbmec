package com.example.bikeibmec.ui.pedaladas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PedaladasViewModel extends ViewModel {
    private final MutableLiveData<PedaladasModel> mPedaladas;

    public PedaladasViewModel() {
        mPedaladas = new MutableLiveData<>();
    }

    public PedaladasViewModel(PedaladasModel pedaladas) {
        mPedaladas = new MutableLiveData<>(pedaladas);
    }

    public LiveData<PedaladasModel> getPedaladas() { return mPedaladas; }

    public void setPedaladas(PedaladasModel pedaladas) { mPedaladas.setValue(pedaladas); }
}
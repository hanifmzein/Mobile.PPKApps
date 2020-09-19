package com.uinsk.mobileppkapps.ui.mahasiswa;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MahasiswaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MahasiswaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mahasiswa fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
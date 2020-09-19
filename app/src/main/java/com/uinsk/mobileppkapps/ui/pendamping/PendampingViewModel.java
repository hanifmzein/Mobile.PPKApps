package com.uinsk.mobileppkapps.ui.pendamping;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PendampingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PendampingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pendamping fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
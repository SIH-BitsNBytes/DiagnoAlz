package com.example.diagnoalz.ui.gametest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GametestViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public GametestViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Welcome To DiagnoAlz");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
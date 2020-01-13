package com.example.diagnoalz.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("TEST WOULD BE UPLOADED SOON");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
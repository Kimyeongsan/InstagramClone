package com.example.instagramclone.ui.liking;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LikingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LikingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is liking fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
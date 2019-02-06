package app.mobilebrainz.testnavigation.viewmodels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import app.mobilebrainz.testnavigation.viewmodels.event.SingleLiveEvent;


public class UserProfilePagerAVM extends ViewModel {

    public MutableLiveData<Integer> tabPosition = new MutableLiveData<>();

    public SingleLiveEvent<String> onArtist = new SingleLiveEvent<>();
 }

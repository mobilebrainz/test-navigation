package app.mobilebrainz.testnavigation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.mobilebrainz.testnavigation.R;
import app.mobilebrainz.testnavigation.viewmodels.UserCollectionsVM;


public class UserCollectionsFragment extends BaseFragment {

    private static final String TAG = "UserCollectionsFragment";

    private UserCollectionsVM viewModel;

    public static UserCollectionsFragment newInstance() {
        return new UserCollectionsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflate(R.layout.user_collections_fragment, container);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = getViewModel(UserCollectionsVM.class);
    }

}

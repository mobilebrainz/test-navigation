package app.mobilebrainz.testnavigation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.mobilebrainz.testnavigation.R;
import app.mobilebrainz.testnavigation.viewmodels.AboutVM;


public class AboutFragment extends BaseFragment {

    private static final String TAG = "AboutFragment";

    private AboutVM viewModel;

    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflate(R.layout.about_fragment, container);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = getViewModel(AboutVM.class);
    }

}

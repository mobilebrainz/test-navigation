package app.mobilebrainz.testnavigation.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;
import app.mobilebrainz.testnavigation.R;
import app.mobilebrainz.testnavigation.viewmodels.ArtistAVM;
import app.mobilebrainz.testnavigation.viewmodels.SearchVM;


public class SearchFragment extends BaseFragment {

    private SearchVM viewModel;

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflate(R.layout.search_fragment, container);

        Button artistButton = view.findViewById(R.id.artistButton);
        //artistButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_searchFragment_to_artistReleasesFragment, null));
        artistButton.setOnClickListener(v -> {
            getActivityViewModel(ArtistAVM.class).artist.setValue("Queen");
            Navigation.findNavController(v).navigate(R.id.action_searchFragment_to_artistReleasesFragment);
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = getViewModel(SearchVM.class);
    }

}

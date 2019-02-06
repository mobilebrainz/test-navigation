package app.mobilebrainz.testnavigation.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;
import app.mobilebrainz.testnavigation.R;
import app.mobilebrainz.testnavigation.adapter.pager.UserProfilePagerAdapter;
import app.mobilebrainz.testnavigation.viewmodels.ArtistAVM;
import app.mobilebrainz.testnavigation.viewmodels.UserProfilePagerAVM;
import app.mobilebrainz.testnavigation.viewmodels.UserProfilePagerVM;


public class UserProfilePagerFragment extends BaseFragment {

    private static final String TAG = "UserProfilePagerF";

    private UserProfilePagerVM viewModel;
    private UserProfilePagerAVM aViewModel;

    private ViewPager pagerView;
    private TabLayout tabsView;

    public static UserProfilePagerFragment newInstance() {
        Bundle args = new Bundle();
        UserProfilePagerFragment fragment = new UserProfilePagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflate(R.layout.fragment_pager_without_icons, container);
        pagerView = view.findViewById(R.id.pagerView);
        tabsView = view.findViewById(R.id.tabsView);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = getViewModel(UserProfilePagerVM.class);
        aViewModel = getActivityViewModel(UserProfilePagerAVM.class);

        aViewModel.tabPosition.observe(this, pos -> pagerView.setCurrentItem(pos));

        aViewModel.onArtist.observe(this, artist -> {
            getActivityViewModel(ArtistAVM.class).artist.setValue(artist);
            Navigation.findNavController(pagerView).navigate(R.id.action_userProfilePagerFragment_to_artistReleasesFragment);
        });

        init();
    }

    protected void init() {
        UserProfilePagerAdapter pagerAdapter = new UserProfilePagerAdapter(getChildFragmentManager(), getResources());
        pagerView.setAdapter(pagerAdapter);
        pagerView.setOffscreenPageLimit(pagerAdapter.getCount());
        tabsView.setupWithViewPager(pagerView);
        tabsView.setTabMode(TabLayout.MODE_FIXED);
        pagerAdapter.setupTabViews(tabsView);
    }

    @Override
    public void onStop() {
        super.onStop();
        aViewModel.tabPosition.setValue(tabsView.getSelectedTabPosition());
    }
}

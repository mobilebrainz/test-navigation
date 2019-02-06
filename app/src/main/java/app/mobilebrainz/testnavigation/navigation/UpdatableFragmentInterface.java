package app.mobilebrainz.testnavigation.navigation;


import android.os.Bundle;

public interface UpdatableFragmentInterface {

    BundleViewModel getBundleViewModel();

    void update(Bundle bundle);

}

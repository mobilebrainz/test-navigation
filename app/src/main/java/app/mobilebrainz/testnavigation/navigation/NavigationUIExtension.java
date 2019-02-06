package app.mobilebrainz.testnavigation.navigation;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import app.mobilebrainz.testnavigation.R;


public class NavigationUIExtension {

    /**
     * From NavigationUI.
     */
    public static NavDestination findStartDestination(@NonNull NavGraph graph) {
        NavDestination startDestination = graph;
        while (startDestination instanceof NavGraph) {
            NavGraph parent = (NavGraph) startDestination;
            startDestination = parent.findNode(parent.getStartDestination());
        }
        return startDestination;
    }

    /**
     * From NavigationUI.
     * Walks up the view hierarchy, trying to determine if the given View is contained within
     * a bottom sheet.
     */
    @SuppressWarnings("WeakerAccess")
    public static BottomSheetBehavior findBottomSheetBehavior(@NonNull View view) {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        if (!(params instanceof CoordinatorLayout.LayoutParams)) {
            ViewParent parent = view.getParent();
            return parent instanceof View ? findBottomSheetBehavior((View) parent) : null;
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) params).getBehavior();
        return behavior instanceof BottomSheetBehavior ? (BottomSheetBehavior) behavior : null;
    }


    public static boolean navigate(int itemId, @NonNull NavController navController) {
        NavOptions.Builder builder = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        // сбросить бек-стек к стартовому фрагменту
        builder.setPopUpTo(findStartDestination(navController.getGraph()).getId(), false);
        NavOptions options = builder.build();
        try {
            navController.navigate(itemId, null, options);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean navigate(@NonNull MenuItem item,
                                   @NonNull NavController navController,
                                   boolean popUpToStart) {
        NavOptions.Builder builder = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        if (popUpToStart && (item.getOrder() & Menu.CATEGORY_SECONDARY) == 0) {
            builder.setPopUpTo(findStartDestination(navController.getGraph()).getId(), false);
        }
        NavOptions options = builder.build();
        try {
            //TODO provide proper API instead of using Exceptions as Control-Flow.
            navController.navigate(item.getItemId(), null, options);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean navigate(int destId, @NonNull NavController navController, int popUpToId) {
        NavOptions.Builder builder = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        builder.setPopUpTo(popUpToId, false);
        NavOptions options = builder.build();

        try {
            //TODO provide proper API instead of using Exceptions as Control-Flow.
            navController.navigate(destId, null, options);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

}

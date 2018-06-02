package com.scriptgo.cossiocafe.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.scriptgo.cossiocafe.bases.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class UtilFragmentTransaction {

    Context context;
    public View iconnavigation;
    public BaseFragment find_fragment;
    public Fragment f_fragment = null,
            f_newfragment = null;

    public static String
            s_newfragment = null,
            s_oldfragment = null;
    public static FragmentManager fragmentManager;
    protected FragmentTransaction fragmentTransaction;

    Boolean enabletobackstack = false;
    String typetransacion = null;
    String tobackstackString = null;
    Boolean animate = true;
    static List<Fragment> fragments = null;
    Integer stackentrycount = 0;
    AppCompatActivity appCompatActivity;
    public int firstitemdefaultmenu;
    int container_layout;

    protected Toolbar toolbar;
    protected FloatingActionButton fab;
    protected DrawerLayout drawer;
    protected AppCompatTextView txttitletoolbar;
    protected ActionBarDrawerToggle toggle;
    protected Boolean statusshowfab, statusbdrawermenu, statusiconarrow = false, statusiconmenu = false;

    public ArrayList<String> iconhomenavigationlist;
    public ArrayList<String> titleToolbarsList;
    public ArrayList<String> fragmentList;
    public ArrayList<String> transactionList;

    private static UtilFragmentTransaction dialoginstance = null;
    private ValueAnimator animiconnavigationtoarrow;

    private UtilFragmentTransaction() {
    }

    public static UtilFragmentTransaction getInstance() {
        if (dialoginstance == null) {
            dialoginstance = new UtilFragmentTransaction();
        }
        return dialoginstance;
    }

    public UtilFragmentTransaction setActivity(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
        this.context = appCompatActivity;
        fragmentManager = appCompatActivity.getSupportFragmentManager();
        fragmentList = new ArrayList<>();
        transactionList = new ArrayList<>();
        iconhomenavigationlist = new ArrayList<>();
        titleToolbarsList = new ArrayList<>();
        return this;
    }

    public void setViews(
            int firstitemdefaultmenu,
            Toolbar toolbar,
            DrawerLayout drawer,
            ActionBarDrawerToggle toggle,
            FloatingActionButton fab,
            int containerlayout) {
        this.firstitemdefaultmenu = firstitemdefaultmenu;
        this.toolbar = toolbar;
        this.fab = fab;
        this.toggle = toggle;
        this.drawer = drawer;

        txttitletoolbar = getToolbarTitle(toolbar);
        txttitletoolbar.setText("Asdadasdasdasdasdasd");
        iconnavigation = getToolbarNavigationIcon(toolbar);
        this.container_layout = containerlayout;
    }

    public UtilFragmentTransaction nextFragment(Class frg) {
        try {
            f_newfragment = (Fragment) frg.newInstance();
            s_newfragment = f_newfragment.getClass().getSimpleName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public UtilFragmentTransaction setTitleToolBar(final String title, final String subtitle) {
        txttitletoolbar.setText(title);
        return this;
    }


    public BaseFragment findFragment() {
        /*Todos los fragments tienen que extender de BaseFragments*/
        find_fragment = (BaseFragment) fragmentManager.findFragmentById(container_layout);
        return find_fragment;
    }

    public static List<Fragment> fragments() {
        fragments = fragmentManager.getFragments();
        return fragments;
    }

    public static int countFragments() {
        return fragmentManager.getFragments().size();
    }

    public int fragmentsStackEntryCount() {
        stackentrycount = fragmentManager.getBackStackEntryCount();
        return stackentrycount;
    }

    public String getLastTitle() {
        return titleToolbarsList.get(getLastIndexFragment());
    }

    public String getPenultimateTitle() {
        String penultimatetitle = titleToolbarsList.get(getPenultimateIndexFragment());
        int lastindex = getLastIndexFragment();
        transactionList.remove(lastindex);
        titleToolbarsList.remove(lastindex);
        iconhomenavigationlist.remove(lastindex);
        fragmentList.remove(lastindex);
        return penultimatetitle;
    }

    private static int getLastIndexFragment() {
        return countFragments() - 1;
    }

    private static int getPenultimateIndexFragment() {
        return getLastIndexFragment() - 1;
    }

    public UtilFragmentTransaction typeTransaction(String type) {
        typetransacion = type;
        return this;
    }

    public UtilFragmentTransaction animate(boolean anim) {
        animate = anim;
        return this;
    }

    public UtilFragmentTransaction setOnBackStask(Boolean is) {
        enabletobackstack = is;
        return this;
    }

    private void runanimate() {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (animate) {
            fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }


    public void commit() {
        switch (typetransacion) {
            case "add":
                proccesAnimate();
                f_fragment = findFragment();
                fragmentTransaction.add(container_layout, f_newfragment, s_newfragment);
                if (f_fragment != null) {
                    s_oldfragment = f_fragment.getTag();
                }
                fragmentTransaction.addToBackStack(s_oldfragment);
                fragmentTransaction.commitAllowingStateLoss();
                break;
            case "replace":
                proccesAnimate();
                fragmentTransaction.replace(container_layout, f_newfragment, s_newfragment);
                if (enabletobackstack) {
                    f_fragment = findFragment();
                    s_oldfragment = f_fragment.getTag();
                    fragmentTransaction.addToBackStack(s_oldfragment);
                }
                fragmentTransaction.commit();
                break;
        }
        transactionList.add(typetransacion);
        fragmentList.add(f_newfragment.getClass().getSimpleName());
    }

    private void proccesAnimate() {
        if (animate == null) {
            animate = true;
            runanimate();
        } else {
            runanimate();
        }
    }

    public UtilFragmentTransaction setFabShow(Boolean is) {
        statusshowfab = is;
        if (statusshowfab) {
            fab.show();
        } else {
            fab.hide();
        }
        return this;
    }

    public UtilFragmentTransaction setShowIconHomeNavigation(String nameicon) {
        iconhomenavigationlist.add(nameicon);
        if (nameicon != null) {
            switch (nameicon) {
                case "menu":
                    toggle.setDrawerIndicatorEnabled(true);
                    setDrawerSwipeEnable(true);
                    break;
                case "arrow":
                    toggle.setDrawerIndicatorEnabled(true);
                    appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                    break;
            }
        } else {
            toggle.setDrawerIndicatorEnabled(false);
            setDrawerSwipeEnable(false);
        }

        return this;
    }

    public UtilFragmentTransaction setDrawerSwipeEnable(Boolean is) {
        statusbdrawermenu = is;
        if (statusbdrawermenu) {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        } else {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
        return this;
    }



    protected AppCompatTextView getToolbarTitle(Toolbar t) {
        t.setTitle(" "); //siempre debe tener un valor.
        if (!t.getTitle().equals("")) {
            int indexAppCompactTextView = 0; //index de AppCompactTextView
            return (AppCompatTextView) t.getChildAt(indexAppCompactTextView);
        }
        return null;
    }

    protected static View getToolbarNavigationIcon(Toolbar toolbar) {
        /* El metodo sera llamado por unica vez */
        //check if contentDescription previously was set
        boolean hadContentDescription = TextUtils.isEmpty(toolbar.getNavigationContentDescription());
        String contentDescription = !hadContentDescription ? toolbar.getNavigationContentDescription().toString() : "navigationIcon";
        toolbar.setNavigationContentDescription(contentDescription);
        ArrayList<View> potentialViews = new ArrayList<View>();
        //find the view based on it's content description, set programatically or with android:contentDescription
        toolbar.findViewsWithText(potentialViews, contentDescription, View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
        //Nav icon is always instantiated at this point because calling setNavigationContentDescription ensures its existence
        View navIcon = null;
        if (potentialViews.size() > 0) {
            navIcon = potentialViews.get(0); //navigation icon is ImageButton
        }
        //Clear content description if not previously present
        if (hadContentDescription)
            toolbar.setNavigationContentDescription(null);
        return navIcon;
    }


//    public void showIconMenuOrArrow(String is, Str) {
//        if (is != null) {
//            iconnavigation.setVisibility(View.VISIBLE);
//            iconnavigation.setAlpha(1);
//            switch (is) {
//                case "menu":
//                    toggle.onDrawerSlide(drawer, 0);
//                    break;
//                case "arrow":
//                    toggle.onDrawerSlide(drawer, 1);
//                    break;
//            }
//        } else {
//            if (titleToolbarsList.size() > 0) {
//
//                if (iconnavigation != null) {
//                    Toast.makeText(context, "con icono", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(context, "sin icono", Toast.LENGTH_SHORT).show();
//                }
//
////                iconnavigation.animate().setUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
////                    @Override
////                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
////                        float slideOffset = (Float) valueAnimator.getAnimatedValue();
////                        toggle.onDrawerSlide(drawer, -slideOffset);
////                    }
////                }).setDuration(0).start();
//            } else {
//                iconnavigation.setVisibility(View.GONE);
//                titleToolbarsList.add(title);
//            }
//
//        }
//
//    }

}

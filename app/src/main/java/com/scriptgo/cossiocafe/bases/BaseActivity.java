package com.scriptgo.cossiocafe.bases;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.scriptgo.cossiocafe.R;
import com.scriptgo.cossiocafe.utils.UtilFragmentTransaction;

import java.util.List;

import butterknife.BindView;

public class BaseActivity extends AppCompatActivity {
    //    protected ValueAnimator animiconnavigationtoarrow;
    @BindView(R.id.toolbar)
    protected Toolbar toolbar;
    protected String title, subtitle;
    @BindView(R.id.fab)
    protected FloatingActionButton fab;
    @BindView(R.id.drawer_layout)
    protected DrawerLayout drawer;
    @BindView(R.id.nav_view)
    protected NavigationView navigationView;
    protected ActionBarDrawerToggle toggle;
    protected TextView txt_nav_user;
    protected Bundle args = new Bundle();
    protected List<Fragment> fragments;
    protected int countfragmenttransaction;
    //    protected UtilSnackBar utilSnackBar = null;
    protected String TAG = this.getClass().getSimpleName();
    protected Integer item_active;
    protected String tagdialog;
    String texttitle;

    protected UtilFragmentTransaction utilFragmentTransaction;

    protected void initUI() {
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toolbar.setContentInsetStartWithNavigation(0);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    protected MenuItem itemmenu_new, itemmenu_old = null;

    public interface FragmentToActivity {
        void openDialogFragmentToActivity(String opendialog,
                                          String tagexecute,
                                          String title,
                                          String msj,
                                          String textpositive,
                                          String textnegative,
                                          Bundle bundle);

        void onChangeFragments(String nombrefragmento, Bundle bundle);
//    void changeFragmentFromFragment(String nombrefragment, Bundle bundle);
    }
}
package com.scriptgo.cossiocafe;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import com.scriptgo.cossiocafe.bases.BaseActivity;
import com.scriptgo.cossiocafe.constants.ConstantsFragments;
import com.scriptgo.cossiocafe.fragments.CarritoFragment;
import com.scriptgo.cossiocafe.fragments.CatalogoFragment;
import com.scriptgo.cossiocafe.fragments.CuentaFragment;
import com.scriptgo.cossiocafe.fragments.SplashFragment;
import com.scriptgo.cossiocafe.utils.UtilFragmentTransaction;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements
        NavigationView.OnNavigationItemSelectedListener,
        BaseActivity.FragmentToActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initUI();
        navigationView.setNavigationItemSelectedListener(this);
        UtilFragmentTransaction
                .getInstance()
                .setActivity(this)
                .setViews(R.id.nav_catalogo,
                        toolbar, drawer, toggle, fab,
                        R.id.container_layout);
        utilFragmentTransaction = UtilFragmentTransaction.getInstance();
        fragments = utilFragmentTransaction.fragments();
        onChangeFragments(ConstantsFragments.F_CATALOGO, null);
    }

    //    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_catalogo:
                onChangeFragments(ConstantsFragments.F_CATALOGO, args);
                break;
            case R.id.nav_carrito:
                onChangeFragments(ConstantsFragments.F_CARRITO, args);
                break;
            case R.id.nav_cuenta:
                onChangeFragments(ConstantsFragments.F_CUENTA, args);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onChangeFragments(String nombrefragmento, Bundle bundle) {
        switch (nombrefragmento) {
            case ConstantsFragments.F_SPLASH:
                utilFragmentTransaction.nextFragment(SplashFragment.class)
                        .setTitleToolBar("Splash", null)
                        .setShowIconHomeNavigation(null)
                        .animate(false)
                        .setFabShow(false)
                        .typeTransaction("replace")
                        .commit();
                break;
            case ConstantsFragments.F_CATALOGO:
                navigationView.getMenu().getItem(0).setChecked(true);
                utilFragmentTransaction.nextFragment(CatalogoFragment.class)
                        .setTitleToolBar("Catalogo", null)
                        .setShowIconHomeNavigation("menu")
                        .animate(true)
                        .setFabShow(true)
                        .typeTransaction("replace")
                        .commit();
                break;
            case ConstantsFragments.F_CARRITO:
                navigationView.getMenu().getItem(1).setChecked(true);
                utilFragmentTransaction.nextFragment(CarritoFragment.class)
                        .setTitleToolBar("Carrito", null)
                        .setShowIconHomeNavigation("menu")
                        .animate(true)
                        .setFabShow(false)
                        .typeTransaction("replace")
                        .commit();
                break;
            case ConstantsFragments.F_CUENTA:
                navigationView.getMenu().getItem(2).setChecked(true);
                utilFragmentTransaction.nextFragment(CuentaFragment.class)
                        .setTitleToolBar("Cuenta", null)
                        .setShowIconHomeNavigation("menu")
                        .animate(true)
                        .setFabShow(false)
                        .typeTransaction("replace")
                        .commit();
                break;
        }
    }

    @Override
    public void openDialogFragmentToActivity(String opendialog, String tagexecute, String title, String msj, String textpositive, String textnegative, Bundle bundle) {

    }
}

package com.scriptgo.cossiocafe.bases;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mobsandgeeks.saripaar.Validator;

import butterknife.Unbinder;

public class BaseFragment extends Fragment {

    /* UI */
    protected View view = null;
    protected Unbinder unbinder;
    protected Menu menu;
    protected MenuItem itemmenu;
    protected LinearLayoutManager layoutManager = null;
    protected Bundle args;

    /* CALLBACKS */
    protected BaseActivity.FragmentToActivity fragmentToActivity = null;

    /* VARS */
    protected String TAG = this.getClass().getSimpleName();
    protected Context context;

    /* VALIDATOR */
    protected Validator validator = null;

    public BaseFragment() {
        super();
    }

    public void clickButtonFloat() {

    }

    /* SE ADJUNTA EL FRAGMENT A LA ACTIVIDAD */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof BaseActivity.FragmentToActivity) {
            fragmentToActivity = (BaseActivity.FragmentToActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


}

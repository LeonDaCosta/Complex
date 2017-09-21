package com.lroxima.demo.complex.complex;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class EntryActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new EntryFragment();
    }
}

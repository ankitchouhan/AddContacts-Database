package com.databasefirst.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.databasefirst.fragments.ContactFragment;
import com.databasefirst.fragments.ContactListFragment;


public class PageAdapter extends FragmentPagerAdapter {

    final private static int TABS = 2;
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new ContactFragment();
            case 1:
               return new ContactListFragment();
        }
        return new ContactFragment();
    }

    @Override
    public int getCount() {
        return TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position ==0)
            return "Add Contact";
        else
            return "Contacts";
    }
}

package com.databasefirst.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.databasefirst.fragments.ContactListFragment;



public class Broadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"BroadcastReceiver",Toast.LENGTH_LONG).show();
        new ContactListFragment().refreshRecyclerAdapter();
    }
}

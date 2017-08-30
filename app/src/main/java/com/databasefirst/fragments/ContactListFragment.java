package com.databasefirst.fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.databasefirst.R;
import com.databasefirst.SignedIn;
import com.databasefirst.adapters.RecyclerAdapter;
import com.databasefirst.beans.ContactBean;
import com.databasefirst.broadcasts.Broadcast;
import com.databasefirst.database.DBHolder;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactListFragment extends Fragment {

    private static RecyclerView recyclerView;
    private static RecyclerAdapter recyclerAdapter;
    static DBHolder dbHolder;
    static List<ContactBean> items;


    private static IntentFilter intentFilter;
    private Broadcast broadcastReceiver;
    private boolean broadcastReceiverRegistered = false;


    public ContactListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_frag_contact_list);
        dbHolder = new DBHolder(getContext());
        items = dbHolder.getAllContacts();
        broadcastReceiver = new Broadcast();
        recyclerAdapter = new RecyclerAdapter(getActivity(),items);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        intentFilter = new IntentFilter(SignedIn.BROADCAST_NAME);
        getActivity().registerReceiver(broadcastReceiver,intentFilter);
        broadcastReceiverRegistered = true;
    }

    @Override
    public void onDestroy() {
        if (broadcastReceiverRegistered)
        {
            getActivity().unregisterReceiver(broadcastReceiver);
            broadcastReceiverRegistered = false;
        }
        super.onDestroy();
    }

    public void refreshRecyclerAdapter() {
        items = dbHolder.getAllContacts();
        recyclerAdapter = new RecyclerAdapter(getActivity(), items);
        recyclerView.setAdapter(recyclerAdapter);
    }
}

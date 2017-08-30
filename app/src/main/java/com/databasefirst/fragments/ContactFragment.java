package com.databasefirst.fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.databasefirst.R;
import com.databasefirst.SignedIn;
import com.databasefirst.beans.ContactBean;
import com.databasefirst.database.DBHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {




    EditText contactName,contactNumber;
    Button button;
    DBHolder dbHolder;


    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        dbHolder = new DBHolder(getActivity());
        contactName = (EditText) view.findViewById(R.id.et_frag_contact_name);
        contactNumber = (EditText) view.findViewById(R.id.et_frag_contactNumber);
        button = (Button) view.findViewById(R.id.b_frag_addContact);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = contactName.getText().toString();
                String number = contactNumber.getText().toString();

                if (name.trim().length()>0&& number.trim().length()>0)
                {
                    if(dbHolder.addContact(new ContactBean(name,number)))
                    {
                        getContext().sendBroadcast(new Intent(SignedIn.BROADCAST_NAME));
                        Toast.makeText(getActivity(),"Contact Added",Toast.LENGTH_LONG).show();
                        contactName.setText("");
                        contactNumber.setText("");
                    }
                }
                else
                    Toast.makeText(getActivity(),"Enter Contact Details",Toast.LENGTH_LONG).show();
            }
        });


    }
}

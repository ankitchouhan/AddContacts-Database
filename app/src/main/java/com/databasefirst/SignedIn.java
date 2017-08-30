package com.databasefirst;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.databasefirst.adapters.PageAdapter;
import com.databasefirst.database.SharedPref;
import com.databasefirst.fragments.ContactListFragment;


public class SignedIn extends AppCompatActivity {

    Button logout;
    SharedPref sharedPref;
    TextView name;
    PageAdapter pageAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;
    public static final String BROADCAST_NAME = "com.databasefirst.fragments.ContactFragment";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        logout = (Button) findViewById(R.id.b_signout);
        name = (TextView) findViewById(R.id.tv_name);
        pageAdapter = new PageAdapter(getSupportFragmentManager());
        sharedPref = new SharedPref(getApplicationContext());
        tabLayout = (TabLayout) findViewById(R.id.tl_tabs);
        String user = sharedPref.getUserDetails();
        name.setText(user);

        viewPager = (ViewPager) findViewById(R.id.vp_tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(pageAdapter);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPref.logoutUser();
                Intent intent = new Intent(SignedIn.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}

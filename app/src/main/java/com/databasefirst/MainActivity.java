package com.databasefirst;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.databasefirst.adapters.PageAdapter;
import com.databasefirst.beans.UserDetails;
import com.databasefirst.database.DBHolder;
import com.databasefirst.database.SharedPref;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button button;
    SharedPref sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.et_user);
        password = (EditText) findViewById(R.id.et_pass);
        button = (Button) findViewById(R.id.b_login);
        sharedPref = new SharedPref(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.trim().length()>0&&pass.trim().length()>0)
                {
                    //if(user.equals("Ankit")&&pass.equals("ankit"))
                   // {
                        sharedPref.createSession(user);
                        Intent intent = new Intent(MainActivity.this,SignedIn.class);
                        startActivity(intent);
                        finish();
                   /* }
                    else
                        Toast.makeText(MainActivity.this,"Enter Correct Details",Toast.LENGTH_LONG).show();*/
                }
                else
                    Toast.makeText(MainActivity.this,"Enter UserName and Password",Toast.LENGTH_LONG).show();
            }
        });


    }
}

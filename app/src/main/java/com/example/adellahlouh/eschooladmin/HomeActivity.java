package com.example.adellahlouh.eschooladmin;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.adellahlouh.eschooladmin.RegisterAdmin.LoginFragment;


public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LoginFragment fragment = new LoginFragment();
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.contentFragment, fragment);
        transaction.commit();


    }

}

package com.company.salemedicine;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Cart.OnFragmentInteractionListener {

    Cart fr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fr=new Cart();

        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_, fr).commit();



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

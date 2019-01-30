package com.example.fragmentes_hazi_6;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String FRAG1 = "1";
    private static final String FRAG2 = "2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentTransaction.add(R.id.fragment1, new ListViewFragment(), FRAG1);
            fragmentTransaction.add(R.id.fragment2, new ShowSelectedView(), FRAG2);
        } else {
            if (fragmentManager.findFragmentByTag(FRAG2) != null)
                fragmentTransaction.remove(fragmentManager.findFragmentByTag(FRAG2));
            fragmentTransaction.add(R.id.fragment1, new ListViewFragment(), FRAG1);
        }
        fragmentTransaction.commit();
    }
}

package com.predatorx.allinone.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.predatorx.allinone.About;
import com.predatorx.allinone.R;

public class Navbar extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navbar);

        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        chipNavigationBar.setItemSelected(R.id.nav_dashboard,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Dashboard()).commit();
        bottomMenu();

    }

    private void bottomMenu() {

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.nav_dashboard:
                        fragment = new Dashboard();
                        break;
                    case R.id.nav_profile:
                        fragment = new Profile();
                        break;
                    case R.id.nav_balance:
                        fragment = new Balance();
                        break;
                    case R.id.nav_expense:
                        fragment = new Expenses();
                        break;
                    case R.id.nav_about:
                        fragment = new About();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });


    }



}
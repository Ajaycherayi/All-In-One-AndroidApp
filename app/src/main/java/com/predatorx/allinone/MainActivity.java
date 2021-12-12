package com.predatorx.allinone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.predatorx.allinone.user.SignUp;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity( new Intent(MainActivity.this, SignUp.class));
                //Initialize SessionManager
                //managerCustomer = new SessionManagerUser(getApplicationContext());
                //managerShop = new SessionManagerShop(getApplicationContext());

//                if (managerShop.getShopLogin()){
//                    startActivity(new Intent(getApplicationContext(), ShopDashBoard.class));
//                }else if (managerCustomer.getCustomerLogin()){
//                    startActivity(new Intent(getApplicationContext(), UserDashBoard.class));
//                }else {
//                    Intent intent = new Intent(MainActivity.this, UserSignUp.class);
//                    startActivity(intent);
//                }
                finish();

            }
        },SPLASH_TIMER);




    }
}
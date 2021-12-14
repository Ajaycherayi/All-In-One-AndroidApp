package com.predatorx.allinone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.predatorx.allinone.database.SessionManager;
import com.predatorx.allinone.user.Navbar;
import com.predatorx.allinone.user.SignUp;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 1000;

    SessionManager manager;
    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = new SessionManager(getApplicationContext());

        phoneNumber = manager.getPhone();

        FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNumber").equalTo(phoneNumber)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        if (snapshot.exists()) { //Check User
                            new Handler().postDelayed(new Runnable() {
                            @Override
                                public void run() {

                                    if (manager.getUserLogin()){
                                        startActivity(new Intent(getApplicationContext(), Navbar.class));
                                    }else {
                                        startActivity(new Intent(MainActivity.this, SignUp.class));
                                    }
                                    finish();

                                }
                        },SPLASH_TIMER);
                        }else{
                            startActivity(new Intent(MainActivity.this, SignUp.class));

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });






    }
}
package com.predatorx.allinone.user;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.predatorx.allinone.R;
import com.predatorx.allinone.database.SessionManager;

public class Profile extends Fragment {

    SessionManager manager;
    Button btn_logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile, container, false);

        btn_logout = (Button) view.findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    return view;

    }


    private void logout() {

        manager = new SessionManager(getActivity());

        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Set Title
        builder.setTitle("Log out");

        //set Message
        builder.setMessage("Are you sure to Log out ?");

        //positive YES button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                manager.setUserLogin(false);
                manager.setDetails("", "", "");

                //activity.finishAffinity();
                dialog.dismiss();

                //Finish Activity
                startActivity(new Intent(getActivity(), SignUp.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                getActivity().finish();
            }
        });

        //Negative NO button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss Dialog
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
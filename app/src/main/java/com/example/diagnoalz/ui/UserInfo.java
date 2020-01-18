package com.example.diagnoalz.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.diagnoalz.R;

public class UserInfo extends Fragment {

EditText name_et,age_et,email_et,mobile_et;
Button edit,submit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_user_info, container, false);

        View view = inflater.inflate(R.layout.fragment_user_info, container, false);



        name_et = view.findViewById(R.id.user_nameet);
        age_et = view.findViewById(R.id.user_ageet);
        email_et = view.findViewById(R.id.user_emailet);
        mobile_et = view.findViewById(R.id.user_mobileet);

        String name = getArguments().getString("name");
        String age = getArguments().getString("age");
        String email = getArguments().getString("email");
        String mobile = getArguments().getString("mobile");


        edit = view.findViewById(R.id.button_edit);
        submit = view.findViewById(R.id.button_submit);

        name_et.setText(name);
        age_et.setText(age);
        email_et.setText(email);
        mobile_et.setText(mobile);

        name_et.setEnabled(false);
        age_et.setEnabled(false);
        email_et.setEnabled(false);
        mobile_et.setEnabled(false);


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name_et.setEnabled(true);
                age_et.setEnabled(true);
                email_et.setEnabled(true);
                mobile_et.setEnabled(true);
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!fieldEmpty(name_et.getText().toString(),age_et.getText().toString(),email_et.getText().toString(),mobile_et.getText().toString()))
                {
                    Toast.makeText(getContext(),"Details Submitted", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getContext(),"Fill all the fields", Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    public boolean fieldEmpty(String name,String age,String email,String mobile) {
        if(name == null || name.isEmpty())
            return true;
        else if(age == null || age.isEmpty())
            return true;
        else if(email == null || email.isEmpty())
            return true;
        else if(mobile == null || mobile.isEmpty())
            return true;
        else return false;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

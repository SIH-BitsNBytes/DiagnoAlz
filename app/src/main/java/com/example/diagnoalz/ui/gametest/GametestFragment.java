package com.example.diagnoalz.ui.gametest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.diagnoalz.MainActivity;
import com.example.diagnoalz.R;
import com.example.diagnoalz.ui.Questions.Question1Fragment;

public class GametestFragment extends Fragment {

    public EditText name,age,email,mobile;

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

    //private GametestViewModel gametestViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.gametest_fragment, container, false);

        class User {
            public String name;
            public String age;
            public String email;
            public String mobile;

            User() {

            }
            User(String name,String age,String email,String mobile) {
                this.age=age;
                this.name=name;
                this.email=email;
                this.mobile=mobile;
            }
        }


        final MainActivity mainact = (MainActivity) getActivity();


        //gametestViewModel = ViewModelProviders.of(this).get(GametestViewModel.class);

        Button testBtn= root.findViewById(R.id.details_nextbtn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=root.findViewById(R.id.name_edittext);
                age=root.findViewById(R.id.age_editText);
                email=root.findViewById(R.id.email_editText);
                mobile=root.findViewById(R.id.phone_editText);

                String userName = name.getText().toString();
                String userAge = age.getText().toString();
                String userEmail = email.getText().toString();
                String userMobile = mobile.getText().toString();

                if(!fieldEmpty(userName,userAge,userEmail,userMobile)) {

                    mainact.users++;
                    String userId = Integer.toString(mainact.users);
                    User user = new User(name.getText().toString(), age.getText().toString(), email.getText().toString(), mobile.getText().toString());
                    mainact.myRef.child(userId).setValue(user);
                    Question1Fragment testFrag = new Question1Fragment();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.nav_host_fragment, testFrag, testFrag.getTag()).commit();
                }
            }
        });
        return root;
    }
}
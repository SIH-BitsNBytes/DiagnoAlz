package com.example.diagnoalz.ui.Questions;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.diagnoalz.MainActivity;
import com.example.diagnoalz.R;

public class Question1Fragment extends Fragment {

    private Question1ViewModel mViewModel;
    RadioButton radioButton;
    RadioGroup radioGroup;
    Button nextBtn;

    int counter=20;
    public static Question1Fragment newInstance() {
        return new Question1Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.question1_fragment, container, false);
        final TextView counttime = root.findViewById(R.id.timer);
        new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counttime.setText(String.valueOf(counter));
                counter--;
            }
            @Override
            public void onFinish() {

                counttime.setText("Finished");
            }
        }.start();

        radioGroup = root.findViewById(R.id.radio);
        nextBtn = root.findViewById(R.id.nextbtn);
        final MainActivity mainact = (MainActivity)getActivity();


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                Log.d("debug1", selectedId+"");
                if(selectedId!=-1) {
                    radioButton = root.findViewById(selectedId);
                    Toast.makeText(getActivity(), radioButton.getText()+" written in database", Toast.LENGTH_SHORT).show();
                    String userId = Integer.toString(mainact.users);
                    
                    mainact.myRef.child(userId).child("answer1").setValue(radioButton.getText());
                }
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(Question1ViewModel.class);
        // TODO: Use the ViewModel
    }

}

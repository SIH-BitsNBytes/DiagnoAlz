package com.example.diagnoalz.ui.gametest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.diagnoalz.R;
import com.example.diagnoalz.ui.Questions.Question1Fragment;

public class GametestFragment extends Fragment {

    //private GametestViewModel gametestViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //gametestViewModel = ViewModelProviders.of(this).get(GametestViewModel.class);
        View root = inflater.inflate(R.layout.gametest_fragment, container, false);
        Button testBtn= root.findViewById(R.id.details_nextbtn);
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Question1Fragment testFrag=new Question1Fragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.nav_host_fragment, testFrag, testFrag.getTag()).commit();
            }
        });
        return root;
    }
}
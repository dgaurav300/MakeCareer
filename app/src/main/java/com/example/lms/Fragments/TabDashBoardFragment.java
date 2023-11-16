package com.example.lms.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lms.R;


public class TabDashBoardFragment extends Fragment {

    private ProgressBar progressBar;
    private TextView progressText;
    int i = 0;
    int completedCourse=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_tab_one, container, false);


                progressBar = view.findViewById(R.id.progress_bar);
        progressText = view.findViewById(R.id.progress_text);

        final Handler handler = new Handler();
        completedCourse=78;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // set the limitations for the numeric
                // text under the progress bar

                if (i <= completedCourse) {
                    progressText.setText("" + i+" %");
                    progressBar.setProgress(i);
                    i++;
                    handler.postDelayed(this, 5);
                } else {
                    handler.removeCallbacks(this);
                }
            }
        }, 5);



        return view;
    }
}
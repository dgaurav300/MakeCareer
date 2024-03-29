package com.example.lms.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lms.Adapters.CourseLearningCustomExpandableListAdapter;
import com.example.lms.Models.CourseLearningExpandableListDataPump;
import com.example.lms.Models.CourseTopicSubTopics;
import com.example.lms.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class LearningFragment extends Fragment {

   ExpandableListView expandableListView;
   CourseLearningCustomExpandableListAdapter expandableListAdapter;
   List<String> expandableListTitle;
   Map<String,List<CourseTopicSubTopics>> expendableListDetails;
   Spinner coursesSpinner,modulesSpinner;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_learning, container, false);
        // Inflate the layout for this fragment



        String courses[]={"FullStack Java","Android Developer"};
        String FullStack_Java_Module[]={"C++","Core Java","DSA","Advance Java"};
        String android_module[]={"Kotlin","Java","XML","API"};



        expandableListView=view.findViewById(R.id.expandableListView);
        expendableListDetails= CourseLearningExpandableListDataPump.getData();
        expandableListTitle=new ArrayList<String>(expendableListDetails.keySet());
        expandableListAdapter=new CourseLearningCustomExpandableListAdapter(getActivity(),expandableListTitle,expendableListDetails);

        expandableListView.setAdapter(expandableListAdapter);
        coursesSpinner=view.findViewById(R.id.coursesListSpinner);
        modulesSpinner=view.findViewById(R.id.courseModuleListSpinner);


        ArrayAdapter<String> courseAdapter=new ArrayAdapter<>(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,courses);
        coursesSpinner.setAdapter(courseAdapter);
        coursesSpinner.setDropDownVerticalOffset(150);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                Toast.makeText(getActivity(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();


            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                Toast.makeText(getActivity(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();


            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(
                        getActivity(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expendableListDetails.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();


                return false;
            }
        });

        return view;
    }
}
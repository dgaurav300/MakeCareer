package com.example.lms.Models;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class CourseLearningExpandableListDataPump {
    public static Map<String, List<CourseTopicSubTopics>> getData() {
        LinkedHashMap<String, List<CourseTopicSubTopics>> expandableListDetail = new LinkedHashMap<String, List<CourseTopicSubTopics>>();

        List<CourseTopicSubTopics> basics = new ArrayList<CourseTopicSubTopics>();

        CourseTopicSubTopics subTopic1=new CourseTopicSubTopics(1,"Introduction to C++",1,"");
        CourseTopicSubTopics subTopic2=new CourseTopicSubTopics(2,"Variables and Data Types",1,"");
        CourseTopicSubTopics subTopic3=new CourseTopicSubTopics(3,"Operators",1,"");
        CourseTopicSubTopics subTopic4=new CourseTopicSubTopics(4,"Control Flow (if, else, switch)",1,"");
        CourseTopicSubTopics subTopic5=new CourseTopicSubTopics(5,"Loops (for, while, do-while)",1,"");

        basics.add(subTopic1);
        basics.add(subTopic2);
        basics.add(subTopic3);
        basics.add(subTopic4);
        basics.add(subTopic5);

        List<CourseTopicSubTopics> oop = new ArrayList<CourseTopicSubTopics>();


        CourseTopicSubTopics subTopic6=new CourseTopicSubTopics(6,"Classes and Objects",2,"");
        CourseTopicSubTopics subTopic7=new CourseTopicSubTopics(7,"Inheritance",2,"");
        CourseTopicSubTopics subTopic8=new CourseTopicSubTopics(8,"Polymorphism",2,"");
        CourseTopicSubTopics subTopic9=new CourseTopicSubTopics(9,"Encapsulation",2,"");
        CourseTopicSubTopics subTopic10=new CourseTopicSubTopics(10,"Abstraction",2,"");
        oop.add(subTopic6);
        oop.add(subTopic7);
        oop.add(subTopic8);
        oop.add(subTopic9);
        oop.add(subTopic10);



        List<CourseTopicSubTopics> advanced = new ArrayList<CourseTopicSubTopics>();

        CourseTopicSubTopics subTopic11=new CourseTopicSubTopics(11,"Templates",3,"");
        CourseTopicSubTopics subTopic12=new CourseTopicSubTopics(12,"STL (Standard Template Library)",3,"");
        CourseTopicSubTopics subTopic13=new CourseTopicSubTopics(13,"Exception Handling",3,"");
        CourseTopicSubTopics subTopic14=new CourseTopicSubTopics(14,"File Handling",3,"");

        advanced.add(subTopic11);
        advanced.add(subTopic12);
        advanced.add(subTopic13);
        advanced.add(subTopic14);




        expandableListDetail.put("Basics", basics);
        expandableListDetail.put("Object-Oriented Programming (OOP)", oop);
        expandableListDetail.put("Advanced Concepts", advanced);

        return expandableListDetail;
    }
}

package com.example.lms.Models;

public class CourseTopics {

    private int topic_id;
    private  String topic_title;
    private int session_number;
    private String Description;
    public CourseTopics(){

    }

    public CourseTopics(String topic_title,int session_number, String description) {
        this.topic_title = topic_title;
        this.session_number=session_number;
        Description = description;
    }

    public CourseTopics(int topic_id, String topic_title,int session_number, String description) {
        this.topic_id = topic_id;
        this.topic_title = topic_title;
        this.session_number=session_number;
        Description = description;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_title() {
        return topic_title;
    }

    public void setTopic_title(String topic_title) {
        this.topic_title = topic_title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getSession_number() {
        return session_number;
    }

    public void setSession_number(int session_number) {
        this.session_number = session_number;
    }
}

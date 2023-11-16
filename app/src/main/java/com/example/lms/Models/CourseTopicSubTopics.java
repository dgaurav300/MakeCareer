package com.example.lms.Models;

public class CourseTopicSubTopics {

    private int subtopic_id;
    private  String sub_topic_title;
    private int session_number;
    private String Description;

    public CourseTopicSubTopics() {
    }

    public CourseTopicSubTopics(String sub_topic_title, int session_number, String description) {
        this.sub_topic_title = sub_topic_title;
        this.session_number = session_number;
        Description = description;
    }

    public CourseTopicSubTopics(int subtopic_id, String sub_topic_title, int session_number, String description) {
        this.subtopic_id = subtopic_id;
        this.sub_topic_title = sub_topic_title;
        this.session_number = session_number;
        Description = description;
    }

    public int getSubtopic_id() {
        return subtopic_id;
    }

    public void setSubtopic_id(int subtopic_id) {
        this.subtopic_id = subtopic_id;
    }

    public String getSub_topic_title() {
        return sub_topic_title;
    }

    public void setSub_topic_title(String sub_topic_title) {
        this.sub_topic_title = sub_topic_title;
    }

    public int getSession_number() {
        return session_number;
    }

    public void setSession_number(int session_number) {
        this.session_number = session_number;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

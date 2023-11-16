package com.example.lms.Models;

public class CourseModule {
    private int module_id;
    private String module_title;
    private int duration_in_hours;
    private String description;

    public  CourseModule(){

    }

    public CourseModule(int module_id, String module_title, int duration_in_hours, String description) {
        this.module_id = module_id;
        this.module_title = module_title;
        this.duration_in_hours = duration_in_hours;
        this.description = description;
    }

    public CourseModule(String module_title, int duration_in_hours, String description) {
        this.module_title = module_title;
        this.duration_in_hours = duration_in_hours;
        this.description = description;
    }

    public int getModule_id() {
        return module_id;
    }

    public void setModule_id(int module_id) {
        this.module_id = module_id;
    }

    public String getModule_title() {
        return module_title;
    }

    public void setModule_title(String module_title) {
        this.module_title = module_title;
    }

    public int getDuration_in_hours() {
        return duration_in_hours;
    }

    public void setDuration_in_hours(int duration_in_hours) {
        this.duration_in_hours = duration_in_hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

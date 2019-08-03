package com.homework.entity;

import java.sql.Date;
import java.sql.Time;

public class HomeworkMaster {
    private String id,title,type;
    private Time update_time;
    private Date opwen_date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Time getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Time update_time) {
        this.update_time = update_time;
    }

    public Date getOpwen_date() {
        return opwen_date;
    }

    public void setOpwen_date(Date opwen_date) {
        this.opwen_date = opwen_date;
    }
}

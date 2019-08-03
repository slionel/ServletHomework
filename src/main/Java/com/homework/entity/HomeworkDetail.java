package com.homework.entity;

import java.sql.Time;

public class HomeworkDetail {
    private String id, master_id,content;
    private Time update_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaster_id() {
        return master_id;
    }

    public void setMaster_id(String master_id) {
        this.master_id = master_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Time getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Time update_time) {
        this.update_time = update_time;
    }
}

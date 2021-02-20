package com.example.noteshome;

import android.widget.TextView;

public class Note {
    private String title;
    private String description;
    private String DayOfWeek;
    private int priority;

    public Note(String title, String description, String dayOfWeek, int priority) {
        this.title = title;
        this.description = description;
        this.DayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDayOfWeek() {
        return DayOfWeek;
    }

    public int getPriority() {
        return priority;
    }
}

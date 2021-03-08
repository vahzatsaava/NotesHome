package com.example.noteshome;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")

public class Note {
    @PrimaryKey(autoGenerate = true)
    private int ID;
    private String title;
    private String description;
    private String DayOfWeek;
    private int priority;

    public Note(int ID, String title, String description, String DayOfWeek, int priority) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.DayOfWeek = DayOfWeek;
        this.priority = priority;
    }

    @Ignore
    public Note(String title, String description, String dayOfWeek, int priority) {
        this.title = title;
        this.description = description;
        DayOfWeek = dayOfWeek;
        this.priority = priority;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDayOfWeek(String dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getID() {
        return ID;
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

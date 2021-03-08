package com.example.noteshome;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;
@Database(entities = {Note.class},version = 1,exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {

    private static NotesDatabase database;
    private static final String DB_NAME = "db2name";
    private static final Object KFC = new Object();

    public static NotesDatabase getInstance(Context context) {
        synchronized (KFC) {
            if (database != null) {
                database = Room.databaseBuilder(context, NotesDatabase.class, DB_NAME).build();
            }
        }
        return database;
    }

    public abstract NotesDAO notesDAO();
}




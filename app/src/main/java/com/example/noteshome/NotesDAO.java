package com.example.noteshome;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDAO {
    @Query("SELECT * FROM notes ORDER BY priority")
    LiveData<List<Note>> getAllnotes();

    @Insert
    void insertNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM notes")
    void deleteAllNote();
}

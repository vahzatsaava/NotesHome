package com.example.noteshome;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static NotesDatabase database;
    private LiveData<List<Note>> notes ;

    public MainViewModel(@NonNull Application application) {
        super(application);
        database = NotesDatabase.getInstance(getApplication());
      notes=  database.notesDAO().getAllnotes();

    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }

    public void insertNotes(Note note) {
        new insertTusk().execute(note);
    }

    public void deleteNotes(Note note) {
        new deleteTusk().execute(note);
    }

    public void deleteAllNotes() {
        new deleteAllTusk().execute();
    }

    private static class insertTusk extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... notes) {
            if (notes != null && notes.length > 0) {
                database.notesDAO().insertNote(notes[0]);
            }
            return null;
        }
    }

    private static class deleteTusk extends AsyncTask<Note, Void, Void> {

        @Override
        protected Void doInBackground(Note... notes) {
            if (notes != null && notes.length > 0) {
                database.notesDAO().deleteNote(notes[0]);
            }
            return null;
        }
    }

    private static class deleteAllTusk extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            database.notesDAO().deleteAllNote();
            return null;
        }
    }
}
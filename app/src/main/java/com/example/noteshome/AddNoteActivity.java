package com.example.noteshome;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDayOfweek;
    private RadioGroup radioGroupPriority;
    private MainViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MainViewModel.class);
        // viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(MainViewModel.class);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        spinnerDayOfweek = findViewById(R.id.spinnerDayOfWeek);
        radioGroupPriority = findViewById(R.id.RadioGroupPriority);


    }


    public void onClickSaveNote(View view) {
        String title = editTextTitle.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();
        String dayOfWeek = spinnerDayOfweek.getSelectedItem().toString().trim();
        int radioButtonId = radioGroupPriority.getCheckedRadioButtonId();
        RadioButton button = findViewById(radioButtonId);
        int priority = Integer.parseInt(button.getText().toString());
        if (isFilling(title, description)) {
            Note note = new Note(title, description, dayOfWeek, priority);
            viewModel.insertNotes(note);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, getString(R.string.Folder_mustBe_full), Toast.LENGTH_SHORT).show();
        }
        //   Note note=new Note(title,description,dayOfWeek,priority);

        //удаляем запись MainActivity.notes.add(note);


    }

    private boolean isFilling(String title, String description) {
        return !title.isEmpty() && !description.isEmpty();
    }

}
package com.example.noteshome;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextTitle;
    private EditText editTextDescription;
    private Spinner spinnerDayOfweek;
    private RadioGroup radioGroupPriority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
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
        int radioButtonId=radioGroupPriority.getCheckedRadioButtonId();
        RadioButton button=findViewById(radioButtonId);
        int priority=Integer.parseInt(button.getText().toString());
        Note note=new Note(title,description,dayOfWeek,priority);
        MainActivity.notes.add(note);
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);


    }
}
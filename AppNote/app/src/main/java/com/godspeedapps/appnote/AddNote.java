package com.godspeedapps.appnote;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.godspeedapps.appnote.Handlers.FileHandler;

public class AddNote extends Activity
{

    EditText noteTitleField = null;
    EditText noteDescriptionField = null;
    FileHandler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        noteTitleField =  findViewById(R.id.noteTitleField);
        noteDescriptionField = findViewById(R.id.noteDescriptionField);
        handler = new FileHandler(this);

    }

    public void addNote(View v)
    {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                String title, description = null;
                title = noteTitleField.getText().toString();
                description = noteDescriptionField.getText().toString();
                handler.createFile(title, description);
                Toast("Created successfully");
            }
        };

        Handler h = new Handler();
        h.post(r);
    }

    private void Toast(String text)
    {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}

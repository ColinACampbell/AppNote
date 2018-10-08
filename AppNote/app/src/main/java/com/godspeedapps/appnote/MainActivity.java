package com.godspeedapps.appnote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.godspeedapps.appnote.Handlers.CustomListView;
import com.godspeedapps.appnote.Handlers.FileHandler;

public class MainActivity extends Activity {

    ListView mListView;
    ListAdapter adapter;
    String[] titles = null;
    String[] descriptions = null;
    FileHandler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new FileHandler(this);
        titles = handler.getFileNames();
        descriptions = handler.getFileContents();

        mListView = findViewById(R.id.noteListView);
        adapter = new CustomListView(this, titles, descriptions);
    }

    public void onStart()
    {
        super.onStart();

        removeNoteEventListener();
        mListView.setAdapter(adapter);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        //refreshActivity();
    }

    ////////

    private void openAddNoteActivity()
    {
        Intent i = new Intent(this,AddNote.class);
        startActivity(i);
    }

    private  void openHelpActivity()
    {
        Intent i = new Intent(this,Help.class);
        startActivity(i);
    }

    private void removeNoteEventListener()
    {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                handler.getFiles()[i].delete();
                Toast(" Item is removed");
                Toast("Please refresh");
            }
        });
    }

    private void refreshActivity()
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    //////////

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.mainmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.addNoteMenu:
                openAddNoteActivity();
                break;
            case R.id.refreshMenu:
                refreshActivity();
                break;
            case R.id.settingsMenu:
                openHelpActivity();
                break;
        }
        return true;
    }

    private void Toast(String text)
    {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }


    // TODO Create the settings activity for the finishing touch
}


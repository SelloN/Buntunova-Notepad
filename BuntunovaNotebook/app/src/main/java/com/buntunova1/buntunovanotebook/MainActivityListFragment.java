package com.buntunova1.buntunovanotebook;


import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.widget.ListPopupWindowCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    //Override the list fragment method, only executed when the activity that belonngs to this fragment is created
    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        /*
        //Create an array
        String[] values = new String[]{"Lesego", "Sello", "Katlego", "Tshepo","Frank","Sarah",
                "Natasha", "Kennedy", "Johannes", "Wiseman", "Mohau", "John"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
         */

        notes = new ArrayList<Note>();
        notes.add(new Note("This is a note Title", "This is the body of our note",
                Note.Category.PERSONAL));
        notes.add(new Note("Tile number 2", "This is the body of our note",
                Note.Category.QUOTE));
        notes.add(new Note("This is a note Title", "This is the body of our note",
                Note.Category.QUOTE));
        notes.add(new Note("This is a note Title", "This is the body of our note",
                Note.Category.TECHNICAL));
        notes.add(new Note("This is a note Title", "This is the body of our note",
                Note.Category.FINANCE));
        notes.add(new Note("This is a note Title", "This is the body of our note",
                Note.Category.TECHNICAL));
        notes.add(new Note("This is a note Title", "This is the body of our note",
                Note.Category.TECHNICAL));
        notes.add(new Note("This is a note Title", "This is the body of our note",
                Note.Category.FINANCE));

        noteAdapter = new NoteAdapter(getActivity(), notes);
        setListAdapter(noteAdapter);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        //Don't forget the super class
        super.onListItemClick(l, v, position, id);
        launchDetailActivity(position);
    }

    //Create a method that will help in launching the activity

    private void launchDetailActivity(int position){

        
        //Grab the note information on whatever we clicked on
        Note note = (Note) getListAdapter().getItem(position);

        //Create an intent that launches our next note activity
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);

        //Pass along the information associated with the we clicked to our note activity
        intent.putExtra(MainActivity.NOTE_TITLE_EXTRA, note.getTitle());
        intent.putExtra(MainActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(MainActivity.NOTE_CATEGORY_EXTRA, note.getCategory());
        intent.putExtra(MainActivity.NOTE_ID_EXTRA, note.getNoteId());


        //Start the damn activity
        startActivity(intent);
    }




}

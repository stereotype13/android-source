package com.bloc.blocnotes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by stereotype13 on 7/23/14.
 */
public class ShowNoteFragmentIntent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // setContentView(R.layout.activity_bloc_notes);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int noteID = bundle.getInt("NOTE_ID");

        Note note = Note.getNoteByID(noteID);

        NoteFragment noteFragment = new NoteFragment(note);

        getFragmentManager().beginTransaction().replace(R.id.container, noteFragment, "INTENT_NOTE_FRAGMENT");

        if(intent != null) {
            if(intent.getAction().equals("SHOW_SNOOZE")) {

            }

        }
    }


}

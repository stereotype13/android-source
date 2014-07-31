package com.bloc.blocnotes;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stereotype13 on 7/6/14.
 */
public class NotebookFragment extends Fragment {

    private ListView mNotesListView;
    private List<Note> mNoteList;
    private Notebook mNotebook;
    private static final String IMAGE_URL_FRAGMENT_TAG = "IMAGE_URL_FRAGMENT_TAG";

    public NotebookFragment() {

    }

    public NotebookFragment(Notebook notebook) {
        mNotebook = notebook;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null) {
            mNotebook = new Notebook(savedInstanceState.getInt("notebook_id"), null);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView;

        if(mNotebook == null || mNotebook.notes.isEmpty()) {
            rootView = inflater.inflate(R.layout.fragment_notebook_empty, container, false);
        }
        else {
            rootView = inflater.inflate(R.layout.fragment_notebook, container, false);
            mNotesListView = (ListView) rootView.findViewById(R.id.notesListView);

            setNotes(mNotebook);

            mNotesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Note note = (Note)adapterView.getItemAtPosition(i);
                    ImageURLFragment imageURLFragment = new ImageURLFragment(getActivity(), note);
                    imageURLFragment.show(getFragmentManager(), IMAGE_URL_FRAGMENT_TAG);
                    return true;
                }
            });


        }

        return rootView;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("notebook_id", mNotebook.getId());

    }

    public void setNotes(Notebook notebook) {

        //add a test Note
        //mNoteList.add(new Note(1, mNotebook, "This is a test note"));
        //mNoteList.add(new Note(2, mNotebook, "This is another test note. This will be a very long note. When in the course of human events it becomes necessary..."));
        if( mNotesListView != null) {
            mNotesListView.setAdapter(new NotebookCustomAdapter(
                    getActivity(),
                    mNotebook.notes));
        }



    }
}

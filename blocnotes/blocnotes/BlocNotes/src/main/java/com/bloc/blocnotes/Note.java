package com.bloc.blocnotes;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stereotype13 on 6/29/14.
 */
public class Note extends Model {
    private int mId;
    private String mBody;
    private int mNotebookID;
    private Notebook mNotebook; //parent notebook

    // Populate model with data from the cursor
    @Override
    protected void _load(Cursor row) {
        mId = row.getInt(row.getColumnIndex("_id"));
        mBody = row.getString(row.getColumnIndex("BODY"));
        mNotebookID = row.getInt(row.getColumnIndex("NOTEBOOK_ID"));
    }

    // Recover ContentValues for the model
    @Override
    protected ContentValues _getContentValues() {
        ContentValues values = new ContentValues();
        values.put("_id", mId);
        values.put("BODY", mBody);
        values.put("NOTEBOOK_ID", mNotebookID);
        return values;
    }

    static List<Note> getNotesForNotebook(Notebook notebook) {
        List<Note> notes = new ArrayList<Note>();

        Cursor notesCursor = BlocNotesApplication.getBlocNotesDBHelper().getWritableDatabase().rawQuery(String.format("SELECT * FROM Notes WHERE NOTEBOOK_ID = %s", notebook.getId()), null);
                /*BlocNotesApplication.getBlocNotesDBHelper().getWritableDatabase().query(true,
                        "Notes",
                        null, "NOTEBOOK_ID=",
                        new String[]{String.valueOf(notebook.getId())},
                        null, null, null, null);*/

        while(notesCursor.moveToNext()) {
            Note note = new Note();
            note.setId(notesCursor.getInt(notesCursor.getColumnIndex("_id")));
            note.setBody(notesCursor.getString(notesCursor.getColumnIndex("BODY")));
            note.setNotebook(notebook);

            notes.add(note);
        }

        notesCursor.close();
        return notes;
    }

    public int getId() {
        return mId;
    }

    public String getBody() {
        return mBody;
    }

    public void setId(int id) {
        mId = id;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public void setNotebook(Notebook notebook) {
        mNotebook = notebook;
        mNotebookID = notebook.getId();
    }

    public Note(long rowId) {
        super("Notes", rowId);
    }

    public Note(int id, Notebook notebook, String body) {
        mId = id;
        mNotebookID = notebook.getId();
        mBody = body;
        mNotebook = notebook;
    }

    public Note(int id, int notebookID, String body) {
        mId = id;
        mNotebookID = notebookID;
        mBody = body;
        mNotebook = null;
    }

    public Note() {
        mId = -1;
        mNotebookID = -1;
        mBody = null;
    }

    @Override
    public String toString() {
        return (mId + " " + mNotebookID + " " + mBody);
    }
}

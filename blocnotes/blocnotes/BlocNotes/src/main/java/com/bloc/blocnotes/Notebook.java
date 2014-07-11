package com.bloc.blocnotes;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

/**
 * Created by stereotype13 on 6/29/14.
 */
public class Notebook extends Model {
    private int mId;
    private String mName;
    public List<Note> notes;

    @Override
    protected void _load(Cursor row) {
        mId = row.getInt(row.getColumnIndex("_id"));
        mName = row.getString(row.getColumnIndex("NAME"));
    }

    @Override
    protected ContentValues _getContentValues() {
        ContentValues values = new ContentValues();
        values.put("_id", mId);
        values.put("NAME", mName);
        return values;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setId(int id) {
        mId = id;
    }

    public void setName(String name) {
        mName = name;
    }

    public Notebook(long rowId){
        super("Notebooks", rowId);
        load();

        notes = Note.getNotesForNotebook(this);
    }

    public Notebook(int id, String name) {
        mId = id;
        mName = name;
    }

    public Notebook() {
        mId = -1;
        mName = null;
    }

    @Override
    public String toString() {
        return (mId + " " + mName);
    }
}

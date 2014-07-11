package com.bloc.blocnotes;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stereotype13 on 7/10/14.
 */
public class NotebookCenter extends ModelCenter<Notebook> {

    public List<Notebook> notebooks;

    public NotebookCenter() {
        super("Notebooks");
    }

    @Override
    protected Notebook _createModel(long rowId) {
        return new Notebook(rowId);
    }

    //Gets ALL notebooks!
    public void fill() {
        notebooks = new ArrayList<Notebook>();

        Cursor cursor =
                BlocNotesApplication.getBlocNotesDBHelper().getWritableDatabase().query(true,
                        "Notebooks",
                        null, null,
                        null,
                        null, null, null, null);

        while(cursor.moveToNext()) {
            Notebook notebook = new Notebook();
            notebook.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            notebook.setName(cursor.getString(cursor.getColumnIndex("NAME")));
            notebook.notes = Note.getNotesForNotebook(notebook);

            notebooks.add(notebook);
        }


    }
}

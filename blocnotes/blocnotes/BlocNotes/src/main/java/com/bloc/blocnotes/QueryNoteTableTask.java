package com.bloc.blocnotes;

import android.database.Cursor;
import android.os.AsyncTask;

/**
 * Created by stereotype13 on 7/11/14.
 */
public class QueryNoteTableTask extends AsyncTask<Notebook, Integer, Cursor> {
    private GetQueryNoteTableListener mCallBacks;

    public QueryNoteTableTask(GetQueryNoteTableListener listener) {
        mCallBacks = listener;
    }

    @Override
    protected Cursor doInBackground(Notebook... notebook) {
        Cursor cursor = BlocNotesApplication.getBlocNotesDBHelper().getWritableDatabase().rawQuery(String.format("SELECT * FROM Notes WHERE NOTEBOOK_ID = %s", notebook[0].getId()), null);
        return cursor;
    }

    @Override
    protected void onPostExecute(Cursor cursor) {
        mCallBacks.onQueryComplete(cursor);
        cursor.close();
    }

    public interface GetQueryNoteTableListener {
        public void onQueryComplete(Cursor cursor);
    }
}

package com.bloc.blocnotes;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

/**
 * Created by stereotype13 on 7/12/14.
 */
public class QueryNotebookTask extends AsyncTask<Void, Integer, Cursor> {

    private IQueryNotebookTask mListener;

    public QueryNotebookTask(Context listener) {
        mListener = (QueryNotebookTask.IQueryNotebookTask)listener;
    }

    @Override
    protected Cursor doInBackground(Void... voids) {

        Cursor cursor =
                BlocNotesApplication.getBlocNotesDBHelper().getWritableDatabase().query(true,
                        "Notebooks",
                        null, null,
                        null,
                        null, null, null, null);


        //BlocNotesApplication.showMessage("There are " + cursor.getCount() + " columns in the cursor");

        return cursor;
    }

    @Override
    protected void onPostExecute(Cursor result) {

        mListener.onNotebookQueryComplete(result);
    }

    public interface IQueryNotebookTask {
        public void onNotebookQueryComplete(Cursor cursor);
    }
}

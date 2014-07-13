package com.bloc.blocnotes;

import android.app.Application;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.bloc.blocnotes.database.BlocNotesDBHelper;

/**
 * Created by rhodel on 6/27/2014.
 */
public class BlocNotesApplication extends Application implements QueryNotebookTask.IQueryNotebookTask, NotebookCenter.INotebookCenter {
    private static BlocNotesDBHelper dbHelper;
    private static BlocNotesApplication mApplicationContext;

    @Override
    public void onNotebookQueryComplete(Cursor cursor) {
        NotebookCenter.getInstance(this).fill(cursor);
    }

    @Override
    public void onDataSetUpdated() {
        //Do nothing
    }

    @Override
    public void onCreate() {

        mApplicationContext = (BlocNotesApplication) getApplicationContext();
        dbHelper = new BlocNotesDBHelper(getApplicationContext());

        QueryNotebookTask queryNotebookTask = new QueryNotebookTask(mApplicationContext);
        queryNotebookTask.execute();
    }

    public static BlocNotesApplication get(Context context) {

        return mApplicationContext;
    }

    public static BlocNotesDBHelper getBlocNotesDBHelper() {
        return dbHelper;
    }
    public static void showMessage(String message) {
        Toast.makeText(mApplicationContext, message, Toast.LENGTH_SHORT).show();
    }
}

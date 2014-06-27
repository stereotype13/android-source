package com.bloc.blocnotes;

import android.app.Application;
import android.content.Context;

import com.bloc.blocnotes.database.BlocNotesDBHelper;

/**
 * Created by rhodel on 6/27/2014.
 */
public class BlocNotesApplication extends Application {
    private BlocNotesDBHelper dbHelper;

    @Override
    public void onCreate() {
        dbHelper = new BlocNotesDBHelper(getApplicationContext());
    }

    public static BlocNotesApplication get(Context context) {
        return (BlocNotesApplication) context.getApplicationContext();
    }

    public BlocNotesDBHelper getBlocNotesDBHelper() {
        return dbHelper;
    }
}

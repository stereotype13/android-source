package com.bloc.blocnotes.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rhodel on 6/26/2014.
 */
public class NotebooksTable extends Table {

    private static final String SQL_CREATE_NOTEBOOKS =
            "CREATE TABLE Notebooks (" +
                    "_id INTEGER PRIMARY KEY," +
                    "NAME TEXT" +
                    " )";

    public NotebooksTable(String name) {
        super(name);
    }

    @Override
    public String getCreateStatement() {
        return SQL_CREATE_NOTEBOOKS;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){

    }

}

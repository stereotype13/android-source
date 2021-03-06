package com.bloc.blocnotes.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rhodel on 6/26/2014.
 */
public class NotesTable extends Table {

    private static final String SQL_CREATE_NOTES =
            "CREATE TABLE Notes (" +
                    "_id INTEGER PRIMARY KEY autoincrement," +
                    "BODY TEXT," +
                    "NOTEBOOK_ID INTEGER" +
                    "URL TEXT" +
                    " )";

    public NotesTable(String name) {
        super(name);
    }

    @Override
    public String getCreateStatement() {
        return SQL_CREATE_NOTES;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){

    }

}

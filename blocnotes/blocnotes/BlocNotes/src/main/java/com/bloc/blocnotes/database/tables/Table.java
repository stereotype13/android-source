package com.bloc.blocnotes.database.tables;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rhodel on 6/26/2014.
 */
// Table.java
public abstract class Table {
    private String TABLE_NAME;

    public Table(String name) {
        this.TABLE_NAME = name;
    }

    public String getName() {
        return this.TABLE_NAME;
    }

    /*
     * Return the create statement for this Table
     */
    public abstract String getCreateStatement();

    /*
     * Upgrade the table
     */
    public abstract void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion);
}

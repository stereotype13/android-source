package com.bloc.blocnotes.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bloc.blocnotes.database.tables.NotebooksTable;
import com.bloc.blocnotes.database.tables.NotesTable;
import com.bloc.blocnotes.database.tables.Table;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by rhodel on 6/26/2014.
 */
public class BlocNotesDBHelper extends SQLiteOpenHelper {

    // Version
    private static final int DATABASE_VERSION = 1;
    // Name
    private static final String DATABASE_NAME = "BlocNotesDB";

    // Tables
    private static Set<Table> sTables = new HashSet<Table>();
    static {
        sTables.add(new NotebooksTable("NOTEBOOKS"));
        sTables.add(new NotesTable("NOTES"));
    }

    public BlocNotesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Iterator<Table> tables = sTables.iterator();
        while (tables.hasNext()){
            sqLiteDatabase.execSQL(tables.next().getCreateStatement());
        }

        ContentValues values = new ContentValues();
        values.put("NAME", "Uncategorized");
        long NotebookID = sqLiteDatabase.insert("Notebooks", null, values);
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Iterator<Table> tables = sTables.iterator();
        while (tables.hasNext()) {
            tables.next().onUpgrade(sqLiteDatabase, oldVersion, newVersion);
        }
    }

}
